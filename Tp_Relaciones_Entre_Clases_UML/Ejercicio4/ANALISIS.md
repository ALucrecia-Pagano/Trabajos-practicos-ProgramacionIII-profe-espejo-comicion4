# Ejercicio 4 - Análisis (cooperativa de agricultores)

## Enunciado original
Una cooperativa de agricultores requiere de un sistema que le aconseje cual es el cereal que puede sembrar en un determinado lote. Los lotes son clasificados como especiales cuando contienen ciertos minerales de interés primario para la cooperativa y comunes cuando contienen sólo minerales secundarios en la composición de la tierra.
Para poder sembrar un cereal en un lote, éste debe contener determinados minerales. Los cereales se clasifican en granos de cosecha gruesa (como girasol, maíz,...), granos de cosecha fina (como trigo, avena,..) y pasturas (como alfalfa, trébol subterráneo,..). Un lote satisface los requerimientos de un cereal si contiene todos de los minerales que requiere ese cereal. Además, para el caso de las pasturas no se puede haber sembrado previamente otra pastura.

## 1. Sustantivos detectados

 Sustantivo ¿Clase o atributo?

 cooperativa --> Clase (Cooperativa) 
 cereal --> Clase abstracta (Cereal) 
 lote --> Clase (Lote) 
 minerales de interés primario/secundario --> Clase (Mineral) + enum (TipoInteres) 
 granos de cosecha gruesa --> Clase (GranoCosechaGruesa) 
 granos de cosecha fina --> Clase (GranoCosechaFina) 
 pasturas --> Clase (Pastura) 
 requerimientos (minerales que requiere un cereal) --> Atributo (List<Mineral> en Cereal)

## 2. Verbos que conectan clases

 Frase | Relación 
 lotes contienen minerales --> Lote o-- Mineral (agregación) 
 cereal requiere minerales --> Cereal o-- Mineral (agregación) 
 granos/pasturas "son tipos de" cereal --> Herencia: GranoCosechaGruesa, GranoCosechaFina, Pastura extends Cereal 
 lote satisface requerimientos de cereal-->  Método (no relación estructural): Lote.satisfaceRequerimientos(Cereal) 
 lote "sembró previamente" un cereal  Lote --> Cereal (asociación, historialSiembra) 
 cooperativa aconseja/ofrece cereales --> Cooperativa o-- Cereal (agregación) 

## 3. Restricciones / reglas

- Un lote satisface los requerimientos de un cereal solo si contiene TODOS los minerales que ese cereal requiere.
- Para pasturas: no se puede sembrar una pastura si ya se sembró otra pastura antes en ese mismo lote (no aplica esta restricción a granos gruesos/finos).
- Un lote es "especial" si contiene algún mineral de interés primario; "común" si solo tiene secundarios.

## 4. Justificación composición/agregación y multiplicidades

- **Cereal o-- Mineral** (mineralesRequeridos): Agregación. Multiplicidad: Cereal "1" -- "1..*" Mineral. Un mineral no es "parte exclusiva" de un cereal: el mismo mineral (ej. Fósforo) puede ser requerido por varios cereales distintos a la vez. No hay pertenencia exclusiva, por eso agregación y no composición.
- **Lote o-- Mineral** (minerales del lote): Agregación. Multiplicidad: Lote "1" -- "0..*" Mineral. Mismo argumento: un mineral no pertenece en exclusiva a un lote (podría, conceptualmente, describir la composición de varios lotes). Mínimo 0 porque un lote recién creado podría no tener minerales cargados todavía.
- **Lote --> Cereal** (historialSiembra): Asociación simple, no parte-todo. Multiplicidad: Lote "1" -- "0..*" Cereal. Es un registro histórico de qué se sembró, no una relación de pertenencia estructural.
- **Cooperativa o-- Cereal** (cerealesDisponibles): Agregación. Multiplicidad: Cooperativa "1" -- "0..*" Cereal. Un cereal (ej. "Maíz") tiene sentido y existencia propia independientemente de estar o no en el catálogo de una cooperativa particular.

*(No hay relaciones de composición fuerte en este ejercicio — a diferencia del Ejercicio 3, acá los "todos" no controlan el ciclo de vida exclusivo de sus "partes".)*

## 5. Dudas abiertas

- ¿Un mismo Mineral puede realmente ser compartido entre distintos Lotes en la práctica, o cada lote debería tener su propia instancia aunque el mineral se llame igual? Se asumió que sí se puede compartir (agregación), pero el enunciado no lo aclara explícitamente.
- ¿La regla de "no sembrar dos pasturas seguidas" aplica sobre TODO el historial del lote, o solo respecto de la última siembra? Se implementó revisando todo el historial completo.
- ¿Qué pasa si un lote no tiene ningún mineral cargado — puede igualmente sembrarse algo? Con el modelo actual, `satisfaceRequerimientos` daría `false` para cualquier cereal que requiera al menos un mineral, lo cual parece razonable, pero no está dicho explícitamente en el enunciado.