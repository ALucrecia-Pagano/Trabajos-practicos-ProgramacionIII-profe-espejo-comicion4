classDiagram
    class Producto {
        -String nombre
        -double precioVentaPublico
    }

    class Cliente {
        -String nombre
        -String direccion
        -String telefono
        -LocalDate fechaNacimiento
        -LocalDate fechaIngreso
    }

    class Ticket {
        -LocalDate fecha
        -double precio
        +registrarVentaFinal()
        +esVentaConcretada() boolean
    }

    class Representante {
        <<abstract>>
        -String nombre
        -String direccion
        -String telefono
        -LocalDate fechaNacimiento
        -String cuitCuil
        -LocalDate fechaIncorporacion
        +getMontoVentasDesde() double
    }

    class Vendedor

    class Lider {
        -LocalDate fechaPromocion
        +getMontoVentasEquipoDesde() double
    }

    class ReunionGeneral {
        -LocalDate fechaUltimaReunion
        -LocalDate fechaProximaReunion
    }

    Representante <|-- Vendedor
    Representante <|-- Lider

    Representante "1" *-- "0..*" Ticket
    Representante "0..*" o-- "0..*" Cliente
    Lider "1" o-- "0..*" Vendedor

    Ticket "1..*" --> "1" Producto
    Ticket "0..*" --> "0..1" Cliente