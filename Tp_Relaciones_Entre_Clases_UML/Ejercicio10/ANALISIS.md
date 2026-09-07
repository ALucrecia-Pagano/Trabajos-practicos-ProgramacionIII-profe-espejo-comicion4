# Ejercicio 10 - Análisis (Juegos Olímpicos)

## Enunciado original
Las sedes olímpicas se dividen en complejos deportivos. Los complejos deportivos se subdividen en aquellos en los que se desarrolla un único deporte y los polideportivos. Ambos tipos manejan diferente tipo de información.

Por cada sede se almacena el número de complejos que tiene y su presupuesto aproximado.

Los complejos tienen áreas designadas para cada deporte con un indicador de su situación (ejemplo: centro, esquina N-E, etc.).

Un complejo tiene una localización, un jefe de organización y el área ocupada. Cada complejo celebra una serie de eventos (ejemplo: la pista del estadio puede celebrar muchas carreras distintas).

Cada evento tiene prevista una fecha, duración, número de participantes y número de comisarios.

Para cada comisario se almacena la lista de eventos en los que está involucrado. Para cada evento se guarda el material necesario para su desarrollo (porterías, pértigas, barras paralelas).

## 1. Sustantivos detectados

| Sustantivo | ¿Clase o atributo? |
|---|---|
| Sede Olímpica | Clase contenedora del recinto/sede (SedeOlimpica) |
| Complejo Deportivo | Clase abstracta base (ComplejoDeportivo) |
| Complejo Unideportivo | Clase hija de ComplejoDeportivo |
| Polideportivo | Clase hija de ComplejoDeportivo |
| Área Designada | Clase interna del complejo (AreaDesignada) |
| Evento | Clase (Evento) |
| Comisario | Clase (Comisario) |
| Material | Clase (Material) |
| Presupuesto | Atributo (presupuesto: double) en SedeOlimpica |
| Número de complejos | Método derivado (getNumeroComplejos(): int) en SedeOlimpica |
| Localización, jefe de organización, área ocupada | Atributos en ComplejoDeportivo |
| Deporte, situación/indicador de ubicación | Atributos en AreaDesignada |
| Fecha, duración, número de participantes, número de comisarios | Atributos en Evento |

## 2. Verbos que conectan clases

| Frase | Relación |
|---|---|
| dividirse en / poseer (complejos) | Una SedeOlimpica compone a ComplejoDeportivo (Composición) |
| subdividirse en / ser (unideportivo vs. polideportivo) | Herencia entre ComplejoUnideportivo y Polideportivo desde ComplejoDeportivo |
| tener (áreas designadas) | Un ComplejoDeportivo compone a AreaDesignada (Composición) |
| celebrar (eventos) | Un ComplejoDeportivo compone a Evento (Composición) |
| estar involucrado / participar en | Asociación \*..* entre Evento y Comisario |
| requerir / guardar (material) | Un Evento compone a Material (Composición) |

## 3. Restricciones / reglas

- Una sede olímpica agrupa uno o varios complejos deportivos.
- Los complejos se diferencian según si albergan un único deporte o múltiples disciplinas (polideportivos).
- Todo complejo posee áreas específicas con un indicador de situación espacial (ej. Centro, Esquina N-E).
- Un mismo complejo puede celebrar múltiples eventos independientes.
- Un comisario puede supervisar varios eventos y un evento requiere varios comisarios (asociación \*..*).
- Cada evento especifica el material y equipamiento exacto necesario para su desarrollo.

## 4. Justificación composición/agregación y multiplicidades

- **Una SedeOlimpica compone a ComplejoDeportivo (1 a 1..\*)**: Los complejos forman parte estructural de la infraestructura de la sede; no tienen sentido de existencia fuera de ella.
- **Un ComplejoDeportivo compone a AreaDesignada (1 a 1..\*)**: La zonificación interna (sectores, canchas, esquinas) no tiene existencia independiente fuera del complejo que la contiene.
- **Un ComplejoDeportivo compone a Evento (1 a \*)**: El complejo gestiona el calendario de eventos celebrados en sus instalaciones; un evento no tiene sentido fuera del complejo que lo alberga.
- **Un Evento compone a Material (1 a 1..\*)**: El requerimiento de material está acoplado a la ficha técnica de cada evento deportivo.
- **Evento se asocia con Comisario (\* a \*)**: Se implementa una asociación bidireccional mediante colecciones (List\<Comisario> en Evento y List\<Evento> en Comisario), satisfaciendo el requerimiento de consultar qué comisarios arbitran un evento y en qué eventos está involucrado un comisario. El numeroComisarios se calcula dinámicamente (comisarios.size()) para evitar inconsistencias.
- Se extraen los atributos universales (localizacion, jefeOrganizacion, areaOcupada) a la clase abstracta ComplejoDeportivo para evitar duplicación en las subclases ComplejoUnideportivo y Polideportivo.

## 5. Dudas abiertas

- **Material compartido vs. requerimiento por evento**: Se modeló Material como un requerimiento propio de cada evento. Si la sede tuviera un inventario centralizado donde los eventos "reservan" material disponible, se requeriría una clase intermedia de asignación de recursos.
- **Roles de comisarios**: El enunciado menciona solo el recuento total de comisarios por evento. Si en el futuro se distinguen roles de arbitraje (ej. Juez Principal, Cronometrista), convendría añadir un atributo de rol en la vinculación.
- **Asignación de evento a un área específica**: Se asoció Evento directamente a ComplejoDeportivo. Si fuera obligatorio que cada evento se desarrolle en una única AreaDesignada, la relación debería apuntar de Evento a AreaDesignada directamente.
