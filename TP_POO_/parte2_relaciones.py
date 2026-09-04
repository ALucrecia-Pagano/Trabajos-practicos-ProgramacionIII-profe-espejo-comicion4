from dataclasses import dataclass

from parte1_diagnostico import Lado, Poligono


@dataclass(frozen=True)
class Etiqueta:
    texto: str


def etiquetar_lado(lado: Lado, texto: str) -> None:
    lado.etiqueta = Etiqueta(texto)


class Taller:
    def __init__(self) -> None:
        self._inventario: list[Poligono] = []

    def recibir(self, poligono: Poligono) -> None:
        self._inventario.append(poligono)

    def restaurar(self, poligono: Poligono) -> None:
        self._inventario.remove(poligono)

    def inventario(self) -> tuple[Poligono, ...]:
        return tuple(self._inventario)