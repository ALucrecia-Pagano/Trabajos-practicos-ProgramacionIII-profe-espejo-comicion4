```mermaid
classDiagram
    class Restaurante {
        -nombre: String
    }
    class Sucursal {
        -direccion: String
    }
    class Plato {
        -nombre: String
    }
    class PlatoServido {
        -precio: double
    }
    class Persona {
        -nombre: String
    }

    Restaurante "1" *-- "1..*" Sucursal : tiene >
    Restaurante "1" -- "0..20" PlatoServido : ofrece >
    PlatoServido "*" -- "1" Plato : es un >
    Persona "*" -- "*" Restaurante : frecuenta >
    Persona "*" -- "*" PlatoServido : le gusta >