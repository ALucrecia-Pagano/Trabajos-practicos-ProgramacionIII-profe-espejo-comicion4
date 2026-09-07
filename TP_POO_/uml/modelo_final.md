# Diagrama de clases final — TP Integrador Unidad 3

Refleja las decisiones tomadas en las Partes 3 y 4. Para verlo renderizado,
copiá el bloque de código y pegalo en https://mermaid.live

```mermaid
classDiagram
class Exportable {
    <<Protocol>>
    +exportar() str
}
class Figura {
    <<abstract>>
    #_nombre str
    #_color str
    +area()* float
}
class Poligono {
    <<abstract>>
    #_lados list~Lado~
    #_observaciones list~str~
    +lados_esperados()* int
    +perimetro() float
    +lados() tuple~Lado~
    +exportar() str
}
class Lado {
    #_longitud float
    #_etiqueta Etiqueta
    +longitud float
}
class Etiqueta {
    <<frozen dataclass>>
    +texto str
}
class Taller {
    #_poligonos list~Poligono~
    +recibir(poligono)
    +restaurar(poligono)
    +inventario() tuple~Poligono~
}
class Triangulo
class Cuadrado
class Pentagono
class Hexagono
class PlanoCAD {
    <<libreria externa>>
    +exportar() str
}

Figura <|-- Poligono : herencia
Poligono <|-- Triangulo
Poligono <|-- Cuadrado
Poligono <|-- Pentagono
Poligono <|-- Hexagono
Poligono "1" *-- "3..*" Lado : composicion
Lado "1" --> "0..1" Etiqueta : asociacion
Taller "1" o-- "0..*" Poligono : agregacion
Poligono ..|> Exportable : cumple
PlanoCAD ..|> Exportable : cumple sin saberlo
```

## Nota sobre PoligonoRegular

No aparece como clase en este diagrama. Se decidio en la Parte 3 que "ser
regular" (todos los lados iguales) no es un tipo de figura distinto: es un
Triangulo, Cuadrado, Pentagono o Hexagono con una restriccion extra sobre sus
lados. Se reemplazo por una funcion `crear_regular(clase, medida)` que
construye cualquiera de las 4 subclases existentes, en vez de agregar una
quinta clase a la jerarquia solo para eso.