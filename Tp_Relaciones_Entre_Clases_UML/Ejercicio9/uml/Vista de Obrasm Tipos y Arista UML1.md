classDiagram
direction TB

    class ObjetoArte {
        <<abstract>>
        -int id
        -String titulo
        -String descripcion
        -Integer anioCreacion
        -String paisOrigen
        -String culturaOrigen
        -String epocaOrigen
        +mostrarFichaTecnica()* void
    }

    class Pintura {
        -String tipoPintura
        -String soporte
        -String estilo
        +mostrarFichaTecnica() void
    }

    class Escultura {
        -String material
        -double altura
        -double peso
        -String estilo
        +mostrarFichaTecnica() void
    }

    class OtroObjeto {
        -String tipoEspecifico
        +mostrarFichaTecnica() void
    }

    class Artista {
        -String nombre
        -LocalDate fechaNacimiento
        -LocalDate fechaDefuncion
        -String paisOrigen
        -String epoca
        -String estiloPrincipal
        -String descripcion
        +getNombre() String
    }

    %% Herencia por tipo de obra
    ObjetoArte <|-- Pintura
    ObjetoArte <|-- Escultura
    ObjetoArte <|-- OtroObjeto

    %% Asociación con Artista
    ObjetoArte "0..*" --> "0..1" Artista : -artista (creado por)