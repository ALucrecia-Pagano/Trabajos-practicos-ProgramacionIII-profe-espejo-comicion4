"""parte1_corregido.py — Version corregida de parte1_diagnostico.py.

La implementacion conserva el dominio Figura/Poligono/Lado, pero elimina
los ocho java-ismos de diseno y el ruido sintactico del archivo diagnostico.

Correcciones aplicadas:
  1. getNombre / getColor reemplazados por @property
  2. catalogo = [] (mutable compartido) → ClassVar[list] con append defensivo
  3. lados=[], observaciones=[] (mutables por defecto) → None + list() interno
  4. super().__init__() faltante en Poligono → delegacion correcta
  5. self._lados = lados (alias) → list(lados) copia + getLados → @property tuple
  6. Bucle acumulador manual en perimetro → sum() + generator
  7. area() -> int devolviendo str → -> float devolviendo 0.0
  8. Triangulo/Cuadrado con *args + isinstance → firmas explicitas con defaults
  9. Poligono como ABC: lados_esperados() abstracto, falla temprana al instanciar
"""


from __future__ import annotations

from abc import ABC, abstractmethod
from typing import ClassVar, Iterable, Protocol

class Exportable(Protocol):
    """Contrato estructural: cualquier objeto con exportar() -> str lo cumple,
    sin necesidad de heredar de esta clase (a diferencia de una ABC)."""

    def exportar(self) -> str: ... #los tres puntos en un Protocol, 
                                 #el cuerpo del método nunca se implementa, 
                                 # solo se declara la firma que hay que cumplir."

class Figura:
    def __init__(self, nombre: str, color: str) -> None:
        self._nombre = nombre
        self._color = color
        self._construida = True

    @property
    def nombre(self) -> str:
        return self._nombre

    @property
    def color(self) -> str:
        return self._color

    def area(self) -> float:
        return 0.0


class Lado:
    def __init__(self, longitud: float) -> None:
        self.longitud = longitud

    @property
    def longitud(self) -> float:
        return self._longitud

    @longitud.setter
    def longitud(self, valor: float) -> None:
        if valor <= 0:
            raise ValueError("La longitud debe ser positiva")
        self._longitud = valor


class Poligono(Figura, ABC):
    _catalogo: ClassVar[list[Poligono]] = []

    def __init__(
        self,
        nombre: str,
        color: str,
        lados: Iterable[Lado] | None = None,
        observaciones: Iterable[str] | None = None,
    ) -> None:
        super().__init__(nombre, color)
        self._lados = list(lados) if lados is not None else []
        self._observaciones = list(observaciones) if observaciones is not None else []
        Poligono._catalogo.append(self)

    @classmethod
    def todos(cls) -> tuple[Poligono, ...]:
        return tuple(cls._catalogo)

    @classmethod
    @abstractmethod
    def lados_esperados(cls) -> int:
        """Cada subclase concreta define cuántos lados le corresponden."""

    def perimetro(self) -> float:
        return sum(lado.longitud for lado in self._lados)

    def exportar(self) -> str:
        return f"{type(self).__name__}[{self.nombre}, {self.lados_esperados()} lados, perimetro={self.perimetro()}]"

    def area(self) -> float:
        return 0.0

    def agregar_observacion(self, texto: str) -> None:
        self._observaciones.append(texto)

    @property
    def lados(self) -> tuple[Lado, ...]:
        return tuple(self._lados)

    @property
    def observaciones(self) -> tuple[str, ...]:
        return tuple(self._observaciones)


class Triangulo(Poligono):
    def __init__(
        self,
        nombre: str = "triangulo",
        color: str = "negro",
        lados: Iterable[Lado] | None = None,
    ) -> None:
        super().__init__(nombre, color, lados)

    @classmethod
    def lados_esperados(cls) -> int:
        return 3   # (o 4, 5, 6 según corresponda)


class Cuadrado(Poligono):
    def __init__(
        self,
        nombre: str = "cuadrado",
        color: str = "negro",
        lados: Iterable[Lado] | None = None,
    ) -> None:
        super().__init__(nombre, color, lados)

    @classmethod
    def lados_esperados(cls) -> int:
        return 4   # (o 4, 5, 6 según corresponda)

class Pentagono(Poligono):
    def __init__(
        self,
        nombre: str = "pentagono",
        color: str = "negro",
        lados: Iterable[Lado] | None = None,
    ) -> None:
        super().__init__(nombre, color, lados)

    @classmethod
    def lados_esperados(cls) -> int:
        return 5


class Hexagono(Poligono):
    def __init__(
        self,
        nombre: str = "hexagono",
        color: str = "negro",
        lados: Iterable[Lado] | None = None,
    ) -> None:
        super().__init__(nombre, color, lados)

    @classmethod
    def lados_esperados(cls) -> int:
        return 6

def crear_regular(
        clase: type[Poligono], medida: float, nombre: str = "regular", color: str = "negro"
    ) -> Poligono:
        """Construye un polígono del tipo dado con todos los lados iguales a `medida`.

        Reemplaza a la antigua clase PoligonoRegular: la cantidad de lados la define
        la propia clase (Triangulo→3, Cuadrado→4, etc.), no un parámetro aparte.
        """
        cantidad = clase.lados_esperados()
        lados = [Lado(medida) for _ in range(cantidad)]
        return clase(nombre, color, lados)

def exportar_todo(items: list[Exportable]) -> list[str]:
    """Recibe polígonos y PlanoCAD en la misma lista, sin que les importe
    el tipo del otro: alcanza con que cada uno tenga exportar() -> str."""
    return [item.exportar() for item in items]


if __name__ == "__main__":
    activo = True
    if activo:
        triangulo = Triangulo("Triangulo", "rojo", [Lado(3), Lado(4), Lado(5)])
        cuadrado = Cuadrado("Cuadrado", "azul", [Lado(2), Lado(2), Lado(2), Lado(2)])
        print(f"Perimetro del triangulo: {triangulo.perimetro()}")
        print(f"Perimetro del cuadrado: {cuadrado.perimetro()}")
        triangulo.agregar_observacion("revisar el vertice A")
        print(f"Figuras en el catalogo: {len(Poligono.todos())}")
        print(f"Nombre mediante property: {triangulo.nombre}")
        regular = crear_regular(Pentagono, medida=4, nombre="Pentagono", color="verde")
        print(f"Perimetro del pentagono: {regular.perimetro()}")
       