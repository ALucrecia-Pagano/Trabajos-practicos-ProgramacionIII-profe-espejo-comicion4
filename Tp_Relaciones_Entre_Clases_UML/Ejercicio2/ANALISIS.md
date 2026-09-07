# Análisis - Ejercicio 2 (Países y Provincias)

## 1. Sustantivos detectados
- **País**: clase.
- **Provincia**: clase.
- **Ciudad**: clase.
- **Continente**: clase.
- **Capital**: no se modela como clase; se representa como un rol de la relación o como una referencia a una ciudad.

## 2. Verbos que conectan clases
- **tiene**: País tiene Provincias, Provincia tiene Ciudades.
- **limita con**: País con País, Provincia con Provincia, Provincia con País.
- **se localiza en**: País en Continente.

## 3. Restricciones o reglas del enunciado
- Una de las ciudades de una provincia es su capital.
- El país también tiene una capital, que lógicamente es una ciudad.
- Las provincias de un país limitan con provincias del mismo país y pueden limitar con otros países.

## 4. Justificación de decisiones (composición, asociación y multiplicidad)
- **País y Provincia (composición):** una provincia no tiene sentido fuera del país al que pertenece. Si se elimina el país, sus provincias también dejan de existir en el modelo.
- **Provincia y Ciudad (composición):** mismo criterio. La ciudad pertenece de forma exclusiva a una provincia.
- **Continente y País (asociación simple):** es una relación de localización; no hay una dependencia fuerte de ciclo de vida.
- **Relaciones de límite (asociación reflexiva y simple):** un país limita con muchos países (`*` a `*`) y una provincia limita con muchas provincias (`*` a `*`).

## 5. Dudas abiertas o problemas encontrados
- El enunciado dice que un país tiene una capital y que cada provincia también tiene una capital. Se modela como una referencia a una ciudad, no como una clase aparte.
- Las relaciones de frontera pueden ser simétricas, por lo que conviene mantenerlas como asociaciones reflexivas bien documentadas.
- No queda totalmente claro si la capital debe ser siempre una ciudad existente dentro de la composición o si puede marcarse con un atributo booleano; se eligió la opción más clara para UML.
- **Aclaración final sobre la capital:** la capital no se modela como clase porque no agrega información nueva al dominio; es simplemente una **Ciudad** que cumple el rol de capital. En UML, esto evita duplicar conceptos y deja explícito que toda capital pertenece al conjunto de ciudades ya definidas.
