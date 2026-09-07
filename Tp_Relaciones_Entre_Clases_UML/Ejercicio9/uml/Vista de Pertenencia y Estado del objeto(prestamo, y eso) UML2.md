classDiagram
direction TB

    class ObjetoArte {
        <<abstract>>
        -int id
        -String titulo
    }

    class Pertenencia {
        <<abstract>>
        +obtenerTipoPertenencia()* String
    }

    class ColeccionPermanente {
        -LocalDate fechaAdquisicion
        -double coste
        -boolean enExposicion
        +isEnExposicion() boolean
        +setEnExposicion(boolean) void
        +obtenerTipoPertenencia() String
    }

    class EnPrestamo {
        -LocalDate fechaRecepcion
        -LocalDate fechaDevolucion
        +getColeccionOrigen() ColeccionExterna
        +obtenerTipoPertenencia() String
    }

    class ColeccionExterna {
        -String nombre
        -String tipo
        -String descripcion
        -String direccion
        -String telefono
        -String personaContacto
        +getNombre() String
    }

    %% Composición de Pertenencia
    ObjetoArte "1" *--> "1" Pertenencia : -pertenencia

    %% Herencia de Estados de Pertenencia
    Pertenencia <|-- ColeccionPermanente
    Pertenencia <|-- EnPrestamo

    %% Asociación con la Colección Externa prestamista
    EnPrestamo "0..*" --> "1" ColeccionExterna : -coleccionOrigen