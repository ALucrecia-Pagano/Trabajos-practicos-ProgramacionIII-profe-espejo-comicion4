classDiagram
    direction TB

    class ParqueNatural {
        -String nombre
    }

    class Personal {
        -String dni
        -String nombre
        -String direccion
        -String telefono
        -double sueldo
        -String numeroSeguridadSocial
    }

    class Cargo {
        <<abstract>>
    }

    class Guarda {
        -String tipoVehiculo
        -String matriculaVehiculo
    }

    class Celador {
    }

    class RegistroVisita {
        -LocalDate fecha
    }

    class Investigador {
        -String titulacion
    }

    class ProyectoInvestigacion {
        -String nombre
        -double presupuesto
        -LocalDate fechaInicio
        -LocalDate fechaFin
    }

    class Entrada {
        -int numero
    }

    class Area {
        -String nombre
    }

    class Especie {
        <<abstract>>
    }

    class Visitante {
        -String dni
    }

    %% Relaciones de Personal y Cargos (Composición de Roles)
    ParqueNatural "1" *--> "*" Personal : emplea
    Personal "1" *--> "1..*" Cargo : desempeña

    Cargo <|-- Guarda
    Cargo <|-- Celador
    Cargo <|-- Investigador

    %% Asignaciones específicas por rol
    Guarda "*" --> "1" Area : asignadoA
    Celador "*" --> "1" Entrada : destinadoEn

    Celador "1" --> "*" RegistroVisita : registra
    RegistroVisita "*" --> "1" Visitante : visitaDe

    Investigador "*" -- "*" ProyectoInvestigacion : participaEn
    ProyectoInvestigacion "*" -- "*" Especie : investiga