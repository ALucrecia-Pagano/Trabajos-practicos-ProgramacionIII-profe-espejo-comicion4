classDiagram
direction TB

    class OrganismoResponsable {
        -String nombre
    }

    class ComunidadAutonoma {
        -String nombre
    }

    class ParqueNatural {
        -String nombre
        -LocalDate fechaDeclaracionPN
    }

    class Entrada {
        -int numero
    }

    class Area {
        -String nombre
        -double km2
    }

    OrganismoResponsable "1" --> "*" ComunidadAutonoma : gestiona
    ComunidadAutonoma "*" -- "*" ParqueNatural : abarca
    ParqueNatural "1" *--> "1..*" Area : se divide en
    ParqueNatural "1" *--> "1..*" Entrada : posee