from typing import List, Optional
from fastapi import HTTPException, status
from .schemas import ProveedorCreate, ProveedorRead

db_proveedores: List[ProveedorRead] = []
id_counter = 1


def _buscar_por_codigo(codigo: str, excluir_id: Optional[int] = None) -> Optional[ProveedorRead]:
    for p in db_proveedores:
        if p.codigo == codigo and p.id != excluir_id:
            return p
    return None


def crear(data: ProveedorCreate) -> ProveedorRead:
    global id_counter
    if _buscar_por_codigo(data.codigo):
        raise HTTPException(
            status_code=status.HTTP_409_CONFLICT,
            detail=f"Ya existe un proveedor con el código '{data.codigo}'",
        )
    nuevo = ProveedorRead(id=id_counter, **data.model_dump())
    db_proveedores.append(nuevo)
    id_counter += 1
    return nuevo


def obtener_todos(skip: int = 0, limit: int = 10, activo: Optional[bool] = None) -> List[ProveedorRead]:
    resultado = db_proveedores
    if activo is not None:
        resultado = [p for p in resultado if p.activo == activo]
    return resultado[skip : skip + limit]


def obtener_por_id(id: int) -> Optional[ProveedorRead]:
    for p in db_proveedores:
        if p.id == id:
            return p
    return None


def actualizar_total(id: int, data: ProveedorCreate) -> Optional[ProveedorRead]:
    for index, p in enumerate(db_proveedores):
        if p.id == id:
            if _buscar_por_codigo(data.codigo, excluir_id=id):
                raise HTTPException(
                    status_code=status.HTTP_409_CONFLICT,
                    detail=f"Ya existe un proveedor con el código '{data.codigo}'",
                )
            actualizado = ProveedorRead(id=id, **data.model_dump())
            db_proveedores[index] = actualizado
            return actualizado
    return None


def desactivar(id: int) -> Optional[ProveedorRead]:
    for index, p in enumerate(db_proveedores):
        if p.id == id:
            if not p.activo:
                raise HTTPException(
                    status_code=status.HTTP_409_CONFLICT,
                    detail="El proveedor ya está desactivado",
                )
            p_dict = p.model_dump()
            p_dict["activo"] = False
            actualizado = ProveedorRead(**p_dict)
            db_proveedores[index] = actualizado
            return actualizado
    return None