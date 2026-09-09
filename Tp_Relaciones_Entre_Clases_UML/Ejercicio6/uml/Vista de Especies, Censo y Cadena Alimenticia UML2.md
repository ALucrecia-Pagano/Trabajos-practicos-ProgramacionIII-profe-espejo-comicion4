classDiagram
direction TB

    class Area {
        -String nombre
        -double km2
    }

    class Especie {
        <<abstract>>
        -String nombreCientifico
        -String nombreVulgar
    }

    class EspecieVegetal {
        -boolean tieneFloracion
        -String periodoFloracion
    }

    class EspecieAnimal {
        -String periodoCelo
        -TipoAlimentacion alimentacion
    }

    class TipoAlimentacion {
        <<enumeration>>
        HERBIVORO
        CARNIVORO
        OMNIVORO
    }

    class CensoEspecie {
        -int numeroIndividuos
    }

    %% Jerarquía de Especies
    Especie <|-- EspecieVegetal
    Especie <|-- EspecieAnimal

    %% Relación con Censo por Área
    Area "1" *--> "*" CensoEspecie : registra
    CensoEspecie "*" --> "1" Especie : de

    %% Cadena Alimentaria (Animales comen otras especies animales o vegetales)
    EspecieAnimal "0..*" --> "0..*" Especie : seAlimentaDe