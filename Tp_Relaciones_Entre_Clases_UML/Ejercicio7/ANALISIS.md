# Ejercicio 7 - Análisis (campeonato de esquí)

## Enunciado original
Dadas las siguientes especificaciones de un “Campeonato de esqui”.
El campeonato consta de una serie de pruebas. En cada una se inscribe un conjunto de participantes. Hay pruebas individuales y por equipos. Un esquiador puede participar en varias pruebas a título individual o sino formando parte de un equipo (pero NO unas veces individualmente y otras en equipo).
Por cada esquiador se desea guardar su DNI, nombre, fecha de nacimiento y edad. A cada participante en una prueba (equipo, para pruebas por equipos o esquiador si es individual) se le asigna un código formado por el nombre de la prueba y un dorsal. Por cada equipo se tiene su código, entrenador, sus esquiadores y cuántos son. No todos los esquiadores de un equipo deben participar en cada prueba donde se ha inscrito. Hay varias federaciones de esquí. De cada una se conoce su nombre y nº de federados. Cada esquiador pertenece a una única federación. No se admite la participación de esquiadores no federados.
Cada federación puede administrar estaciones de esquí. Toda estación se administra al menos por una federación, aunque puede serlo por varias. Cada estación de esquí dispone de un código identificativo. Tiene un nombre, personas de contacto, dirección, teléfono, nº total de kilómetros esquiables y nº de pistas. Cada pista se identifica por el código de la estación a la que pertenece y un número correlativo. Se guarda su longitud en kilómetros y su nivel de dificultad (según un código de colores).
Algunas pruebas de largo recorrido utilizan varias pistas de una misma estación como si fuesen una sola pista compuesta de varias subpistas. Cada prueba se realizará en las pistas de una única estación. Puede durar varios días. Se almacenan las fechas en las que tiene lugar.
Los participantes podrán competir en diferentes pruebas y en diferentes pistas. Se registrará la fecha o fechas en las que cada participante compite en cada prueba así como el tiempo empleado y la posición obtenida. Cada prueba se identifica por un nombre, será de un tipo (fondo, slalom, salto, ...) tendrá unas fechas previstas de realización y se registrará el vencedor y el tiempo empleado por éste.

## 1. Sustantivos detectados

Sustantivo -- ¿Clase o atributo? 
 pruebas --> Clase (Prueba) 
 esquiador --> Clase (Esquiador) 
 equipo --> Clase (Equipo) 
 federaciones --> Clase (Federacion) 
 estaciones de esquí --> Clase (EstacionEsqui) 
 pistas --> Clase (Pista) 
 participante (código dorsal) --> Clase (Inscripcion) - no es el mismo objeto que Esquiador/Equipo, es el registro de inscripción a UNA prueba 
 dorsal --> Atributo (int, en Inscripcion) 
 edad --> No es atributo guardado: se calcula (getEdad(), a partir de fechaNacimiento) 
 tiempo empleado, posición --> Atributos (en el resultado de una inscripción) 

## 2. Verbos que conectan clases

| Frase | Relación |

| esquiador pertenece a una federación | Esquiador --> Federacion (asociación, 1 esquiador - 1 federación) |
| federación administra estaciones | Federacion o-- EstacionEsqui (agregación, puede ser varias federaciones por estación) |
| estación tiene pistas | EstacionEsqui *-- Pista (composición) |
| esquiador/equipo se inscribe en una prueba | Prueba o-- Inscripcion (agregación) |
| prueba se realiza en una estación | Prueba --> EstacionEsqui (asociación) |
| equipo tiene esquiadores | Equipo o-- Esquiador (agregación) |

## 3. Restricciones / reglas

- No se admite la participación de esquiadores no federados (validado en el constructor de Esquiador).
- Un esquiador participa en varias pruebas, siempre a título individual O siempre en equipo, nunca mezclado (no implementado como restricción de código, ver Dudas abiertas).
- Cada prueba se identifica por tipo (individual o por equipos); la inscripción debe coincidir con ese tipo (validado en Prueba.inscribir()).
- Cada prueba se realiza en las pistas de una única estación.

## 4. Justificación composición/agregación y multiplicidades

- **EstacionEsqui *-- Pista**: Composición. Multiplicidad: EstacionEsqui "1" -- "1..*" Pista. Una pista no tiene sentido fuera de la estación a la que pertenece (su propio código depende del código de la estación).
- **Federacion o-- EstacionEsqui**: Agregación. Multiplicidad: Federacion "1..*" -- "1..*" EstacionEsqui (muchos a muchos). El enunciado dice explícitamente que una estación puede ser administrada por varias federaciones, y una federación administra varias estaciones — no hay pertenencia exclusiva.
- **Equipo o-- Esquiador**: Agregación. Multiplicidad: Equipo "1" -- "1..*" Esquiador. Un esquiador tiene existencia propia (compite, tiene DNI, federación) independientemente de pertenecer a algún equipo.
- **Prueba o-- Inscripcion**: Agregación. Multiplicidad: Prueba "1" -- "0..*" Inscripcion. Una prueba recién creada puede no tener inscriptos todavía.
- **Esquiador --> Federacion**: Asociación simple. Multiplicidad: Esquiador "1..*" -- "1" Federacion (cada esquiador pertenece a exactamente una federación; una federación tiene muchos esquiadores federados).

## 5. Dudas abiertas

- La regla "un esquiador participa individualmente O en equipo, pero no ambas veces" no quedó reflejada como restricción de código — solo se validó que el TIPO de prueba (individual/equipo) coincida con el tipo de participante al inscribirse, pero no se impide que un mismo esquiador se inscriba individualmente en una prueba y en equipo en otra. ¿Se espera que el sistema lo bloquee activamente?
- ¿Qué pasa si una prueba "de largo recorrido" usa varias pistas combinadas como si fuera una sola? El modelo actual permite asociar varias pistas a una prueba, pero no las trata como una "pista compuesta" con longitud/dificultad propia — quedó simplificado.
- No se implementó el registro completo de resultados históricos por participante y fecha (el enunciado pide guardar fecha, tiempo y posición por cada vez que compite) — el modelo actual simplificó a un solo resultado por inscripción, sin ParticipacionResultado como clase aparte.