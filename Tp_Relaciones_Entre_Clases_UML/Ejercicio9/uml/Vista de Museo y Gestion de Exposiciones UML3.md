classDiagram
direction TB

    class Museo {
        -String nombre
        +agregarObjetoAlInventario(ObjetoArte obra) void
        +registrarExposicion(Exposicion expo) void
        +mostrarInventarioGeneral() void
    }

    class Exposicion {
        -String nombre
        -LocalDate fechaInicio
        -LocalDate fechaFin
        +agregarObjeto(ObjetoArte obra) void
        +mostrarCatalogoExposicion() void
    }

    class ObjetoArte {
        <<abstract>>
        -int id
        -String titulo
        +mostrarFichaTecnica()* void
    }

    %% Relaciones del Museo y Eventos
    Museo "1" *--> "*" ObjetoArte : -inventario (posee)
    Museo "1" o--> "*" Exposicion : -exposiciones (organiza)
    Exposicion "0..*" o--> "1..*" ObjetoArte : -obrasExhibidas (exhibe)