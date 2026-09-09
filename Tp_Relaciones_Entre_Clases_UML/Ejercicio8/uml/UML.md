```mermaid
classDiagram
    class Persona {
        -nroSeguridadSocial: String
        -nombre: String
        -direccion: String
        -telefono: String
    }
    class Piloto {
        -nroLicencia: String
        -restricciones: String
    }
    class Mecanico {
        -salario: double
        -turno: String
    }
    class Propietario {
        -fechaAdquisicionAvion: Date
    }
    class Avion {
        -matricula: String
    }
    class TipoAvion {
        -nroModelo: String
        -capacidad: int
        -peso: double
    }
    class Hangar {
        -numero: int
        -capacidad: int
        -ubicacion: String
    }
    class Servicio {
        -fecha: Date
        -horasInvertidas: int
        -tipoTrabajo: String
    }

    Persona <|-- Piloto : es un
    Persona <|-- Mecanico : es un
    Persona <|-- Propietario : es un

    Avion "*" -- "1" TipoAvion : es de tipo >
    Avion "*" -- "1" Hangar : se guarda en >
    Propietario "1" o-- "*" Avion : es dueño de >
    
    Piloto "*" -- "*" TipoAvion : autorizado a volar >
    Mecanico "*" -- "*" TipoAvion : autorizado a mantener >
    
    Servicio "*" -- "1" Mecanico : realizado por >
    Servicio "*" -- "1" Avion : realizado a >
```