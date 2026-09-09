classDiagram
direction TB


    class Figura {
        <<abstract>>
        +calcularArea()* double
    }

    class FiguraCompuesta {
        +agregarFigura(Figura f) void
        +calcularArea() double
    }

    class Elipse {
        -double radioMayor
        -double radioMenor
        +calcularArea() double
    }

    class Circulo {
    }

    class Poligono {
        <<abstract>>
        -int numeroLados
    }

    class Triangulo {
        -double base
        -double altura
        +calcularArea() double
    }

    class Cuadrilatero {
        +calcularArea() double
    }

    class Rectangulo {
        -double base
        -double altura
        +calcularArea() double
    }

    class Cuadrado {
    }

    class Lado {
    }

    class Punto {
        -double x
        -double y
        +getX() double
        +getY() double
    }

    %% Jerarquía de Herencia
    Figura <|-- FiguraCompuesta
    Figura <|-- Elipse
    Figura <|-- Poligono

    Elipse <|-- Circulo

    Poligono <|-- Triangulo
    Poligono <|-- Cuadrilatero
    Cuadrilatero <|-- Rectangulo
    Rectangulo <|-- Cuadrado

    %% Relaciones Estructurales (Composición)
    FiguraCompuesta "1" *--> "*" Figura : contiene
    Poligono "1" *--> "3..*" Lado : contiene
    Lado "1" *--> "2" Punto : definido por
    