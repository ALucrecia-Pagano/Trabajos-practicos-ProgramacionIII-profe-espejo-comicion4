# Ejercicio 7 - Diagrama UML (campeonato de esquí)

\`\`\`mermaid
classDiagram
    class Federacion {
        -String nombre
        -int numFederados
    }

    class EstacionEsqui {
        -String codigo
        -String nombre
        +agregarPista()
    }

    class Pista {
        -int numeroCorrelativo
        -double longitudKm
        -String dificultad
    }

    class Esquiador {
        -String dni
        -String nombre
        -LocalDate fechaNacimiento
        +getEdad()
    }

    class Equipo {
        -String codigo
        -String entrenador
        +agregarEsquiador()
        +getCantidadEsquiadores()
    }

    class ParticipanteEnPrueba {
        <<interface>>
        +getNombreParticipante() String
    }

    class Prueba {
        -String nombre
        -TipoPrueba tipo
        -boolean esPorEquipos
        +inscribir()
        +registrarResultado()
    }

    class Inscripcion {
        -int dorsal
        +getCodigo()
    }

    class TipoPrueba {
        <<enumeration>>
        FONDO
        SLALOM
        SALTO
    }

    ParticipanteEnPrueba <|.. Esquiador
    ParticipanteEnPrueba <|.. Equipo

    EstacionEsqui "1" *-- "1..*" Pista
    Federacion "1..*" o-- "1..*" EstacionEsqui
    Equipo "1" o-- "1..*" Esquiador
    Prueba "1" o-- "0..*" Inscripcion

    Esquiador "1..*" --> "1" Federacion
    Prueba "1" --> "1" EstacionEsqui
    Inscripcion "1..*" --> "1" Prueba
    Inscripcion "1" --> "1" ParticipanteEnPrueba
    Prueba "1" --> "1" TipoPrueba
\`\`\`