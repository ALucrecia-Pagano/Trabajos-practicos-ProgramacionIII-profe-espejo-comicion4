# Ejercicio 6 - Análisis (Parques Naturales)

## Enunciado original
Por cada comunidad autónoma (CA) se guarda su nombre, sus parques y el organismo responsable de estos. Hay parques que se extienden por varias CAs. De un parque se almacena su nombre (no habrá dos de igual nombre), la fecha en la que fue declarado PN, sus diferentes áreas y los km2 de cada una.

No hay dos áreas del mismo PN que se llamen igual.

En cada área de un parque residen varias especies. Cada especie tiene sus nombres científico y vulgar y se conoce el nº de individuos en cada área.

Por cada especie vegetal desean conocer si tiene floración y, en ese caso, en qué periodo florece. De las especies animales se guardará cuál es su periodo de celo. Según su alimentación, las especies animales se clasifican en herbívoras, carnívoras y omnívoras. También hay que registrar qué animales o vegetales sirven de alimento a los animales de los parques.

Por cada visitante a PNs se recoge su DNI, nombre, dirección y profesión. Los PN tienen alojamientos propios que organizan excursiones. No hay dos alojamientos de un parque con igual nombre, además, se guarda su capacidad, categoría, visitantes que lo utilizaron y en qué habitación y fechas de inicio y fin.

Cada excursión tiene un código que la identifica. Además, se registra el día, la hora y los alojamientos que la organizan. También se almacenan los visitantes que se inscriben en cada excursión.

El personal que trabaja en cada parque puede ser: celador, investigador y guarda. Una persona puede desempeñar varios cargos al mismo tiempo (por ejemplo, guarda e investigador). Para todos ellos se guarda su DNI, nombre, dirección, teléfono, sueldo, nº de seguridad social y el parque donde trabaja.

Cada parque tiene una o varias entradas. Éstas se numeran del uno al nº de entradas al mismo. Cada celador está destinado en una de ellas y se encarga de registrar quién visita el parque y en qué fecha.

Cada guarda tiene asignada un área de su parque y la recorre en un vehículo, del que se almacena su tipo y matrícula. Se pueden asignar varios guardas a un área del parque y varios celadores a una entrada.

Por cada investigador se recoge su titulación, los proyectos de investigación en los que ha intervenido junto a las especies investigadas por él en cada proyecto. De cada proyecto se registra su nombre, presupuesto y período de realización (fechas de inicio y fin).

## 1. Sustantivos detectados

| Sustantivo | ¿Clase o atributo? |
|---|---|
| Comunidad Autónoma (CA) | Clase (ComunidadAutonoma) |
| Organismo Responsable | Clase (o atributo dentro de ComunidadAutonoma) |
| Parque Natural (PN) | Clase (ParqueNatural) |
| Área | Clase (Area) |
| Entrada | Clase (Entrada) |
| Especie | Clase abstracta base (Especie) |
| Especie Vegetal, Especie Animal | Clases hijas de Especie |
| Herbívoras, Carnívoras, Omnívoras | Enum (TipoAlimentacion) |
| Censo / Población | Clase de asociación (CensoEspecie) para registrar individuos por área |
| Visitante | Clase (Visitante) |
| Alojamiento | Clase (Alojamiento) |
| Estancia | Clase de asociación entre Visitante y Alojamiento |
| Excursión | Clase (Excursion) |
| Personal | Clase base de datos personales/laborales |
| Cargo / Rol | Clase abstracta (patrón Role) |
| Guarda, Celador, Investigador | Clases hijas de Cargo |
| Vehículo | Atributos en Guarda (tipo, matricula) |
| Registro de Visita | Clase gestionada por Celador |
| Proyecto de Investigación | Clase (ProyectoInvestigacion) |
| DNI, nombres, sueldos, teléfonos, fechas, km2, presupuestos | Atributos identificativos/descriptivos en sus respectivas clases |

## 2. Verbos que conectan clases

| Frase | Relación |
|---|---|
| extenderse por (CAs) | Asociación \*..* entre ComunidadAutonoma y ParqueNatural |
| dividirse en / poseer (áreas, entradas, alojamientos) | Un ParqueNatural compone a Area, Entrada y Alojamiento (Composición) |
| residir en / censar | Relación mediante la clase intermedia CensoEspecie entre Area y Especie |
| servir de alimento a (cadena trófica) | Asociación recursiva \*..* en EspecieAnimal hacia Especie |
| utilizar / alojarse | Relación mediante la clase intermedia Estancia entre Visitante y Alojamiento |
| organizar (excursiones) | Asociación \*..* entre Alojamiento y Excursion |
| inscribirse en | Asociación \*..* entre Visitante y Excursion |
| desempeñar (cargos) | Un Personal compone a Cargo (Composición, 1 a 1..*) |
| asignar a (área/entrada) | Asociación de Guarda hacia Area y de Celador hacia Entrada |
| registrar (visitas) | Asociación entre Celador, RegistroVisita y Visitante |
| participar en / investigar | Asociación \*..* entre Investigador, ProyectoInvestigacion y Especie |

## 3. Restricciones / reglas

- Un parque puede abarcar varias CAs y una CA puede tener varios parques.
- Los nombres de parques son únicos a nivel global.
- Los nombres de áreas y alojamientos son únicos dentro de su respectivo parque (dependencia de contexto).
- Las entradas se numeran secuencialmente del 1 al N para cada parque.
- Una persona puede desempeñar múltiples cargos simultáneos (ej. Guarda e Investigador).
- Varios guardas pueden estar asignados a una misma área y varios celadores a una misma entrada.
- El censo de individuos es específico para cada combinación de área y especie.

## 4. Justificación composición/agregación y multiplicidades

- **Patrón Role para Personal**: Para satisfacer la regla de que "una persona puede desempeñar varios cargos al mismo tiempo", se desacopló la identidad de la persona (Personal) de sus funciones (Cargo). Si se usara herencia simple (Personal extiende Guarda), no se podría modelar a alguien con dos cargos sin recurrir a herencia múltiple (inexistente en Java).
- **Un ParqueNatural compone a Area, Entrada y Alojamiento**: Es composición porque estas entidades no tienen ciclo de vida ni sentido de existencia fuera del parque al que pertenecen.
- **CensoEspecie (clase de asociación)**: El número de individuos no pertenece ni al área sola ni a la especie sola, sino a la intersección de ambas.
- **Estancia (clase de asociación)**: Permite almacenar el número de habitación, fecha de inicio y fecha de fin para cada visita de un usuario a un alojamiento.

## 5. Dudas abiertas

- **Sueldo único vs. sueldo por cargo**: El enunciado indica "para todos ellos se guarda su sueldo", ubicándolo a nivel de la persona (Personal). Si en el futuro se requiriera liquidar sueldos independientes por cada rol desempeñado, el atributo debería migrar a la clase Cargo.
- **Control de capacidad en alojamientos**: Se modeló la capacidad total como atributo numérico en Alojamiento, quedando para la capa de lógica de negocio validar que la concurrencia de Estancias no supere dicho límite.
- **Asignación de vehículos**: Se asumió que los datos del vehículo (tipo y matrícula) son propios de la asignación del Guarda. Si los vehículos pertenecieran a una flota compartida del parque, convendría modelar una entidad independiente Vehiculo.
