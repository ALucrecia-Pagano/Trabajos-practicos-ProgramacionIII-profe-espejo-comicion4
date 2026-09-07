classDiagram
direction TB

    class SedeOlimpica {
        -String nombre
        -double presupuesto
        +getNumeroComplejos() int
        +agregarComplejo(ComplejoDeportivo c) void
    }

    class ComplejoDeportivo {
        <<abstract>>
        -String nombre
        -String localizacion
        -String jefeOrganizacion
        -double areaOcupada
        +agregarArea(AreaDesignada a) void
        +celebrarEvento(Evento e) void
    }

    class ComplejoUnideportivo {
        -String deportePrincipal
    }

    class Polideportivo {
        -int cantidadCanchas
    }

    class AreaDesignada {
        -String deporte
        -String situacion
    }

    %% Herencia de complejos
    ComplejoDeportivo <|-- ComplejoUnideportivo
    ComplejoDeportivo <|-- Polideportivo

    %% Composición de Sede y Áreas
    SedeOlimpica "1" *--> "1..*" ComplejoDeportivo : posee
    ComplejoDeportivo "1" *--> "1..*" AreaDesignada : zonificadoEn