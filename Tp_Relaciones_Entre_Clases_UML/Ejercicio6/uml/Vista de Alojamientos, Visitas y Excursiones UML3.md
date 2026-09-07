classDiagram
direction TB

    class ParqueNatural {
        -String nombre
    }

    class Alojamiento {
        -String nombre
        -int capacidad
        -String categoria
    }

    class Visitante {
        -String dni
        -String nombre
        -String direccion
        -String profesion
    }

    class Estancia {
        -String habitacion
        -LocalDate fechaInicio
        -LocalDate fechaFin
    }

    class Excursion {
        -String codigo
        -LocalDate dia
        -LocalTime hora
    }

    %% Relaciones
    ParqueNatural "1" *--> "*" Alojamiento : posee
    Alojamiento "1" *--> "*" Estancia : registra
    Estancia "*" --> "1" Visitante : realizadaPor

    Alojamiento "*" -- "*" Excursion : organiza
    Visitante "*" -- "*" Excursion : seInscribeEn