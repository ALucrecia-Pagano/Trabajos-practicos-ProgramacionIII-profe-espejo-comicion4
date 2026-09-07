classDiagram
direction TB

    class ComplejoDeportivo {
        <<abstract>>
        -String nombre
    }

    class Evento {
        -String nombre
        -LocalDate fecha
        -int duracionMinutos
        -int numeroParticipantes
        +getNumeroComisarios() int
        +asignarComisario(Comisario c) void
        +agregarMaterial(Material m) void
    }

    class Material {
        -String nombre
        -int cantidad
    }

    class Comisario {
        -String dni
        -String nombre
        -String rolJuez
    }

    %% Relaciones de Eventos
    ComplejoDeportivo "1" *--> "*" Evento : celebra
    Evento "1" *--> "1..*" Material : requiere
    Evento "*" -- "*" Comisario : supervisadoPor