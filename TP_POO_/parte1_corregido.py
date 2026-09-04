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
"""

from __future__ import annotations

from typing import ClassVar, Iterable


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


class Poligono(Figura):
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

    def lados_esperados(self) -> int:
        return 0

    def perimetro(self) -> float:
        return sum(lado.longitud for lado in self._lados)

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

    def lados_esperados(self) -> int:
        return 3


class Cuadrado(Poligono):
    def __init__(
        self,
        nombre: str = "cuadrado",
        color: str = "negro",
        lados: Iterable[Lado] | None = None,
    ) -> None:
        super().__init__(nombre, color, lados)

    def lados_esperados(self) -> int:
        return 4


class PoligonoRegular(Poligono):
    """Poligono de N lados de igual longitud."""

    def __init__(
        self, nombre: str, color: str, medida: float, cantidad: int
    ) -> None:
        super().__init__(
            nombre,
            color,
            (Lado(medida) for _ in range(cantidad)),
        )
        self._cantidad = cantidad

    def lados_esperados(self) -> int:
        return self._cantidad


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
        regular = PoligonoRegular("Pentagono", "verde", 4, 5)
        print(f"Perimetro del pentagono: {regular.perimetro()}")
