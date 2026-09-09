# Análisis - Ejercicio 5 (Restaurantes y Platos)

## 1. Sustantivos detectados
- **Restaurante**: clase.
- **Sucursal**: clase.
- **Plato**: clase.
- **Persona**: clase.
- **PlatoServido**: clase intermedia, para representar el plato dentro de un restaurante específico.

## 2. Verbos que conectan clases
- **tiene**: Restaurante tiene Sucursales.
- **ofrece**: Restaurante ofrece Platos.
- **frecuenta**: Persona frecuenta Restaurantes.
- **le gusta**: Persona gusta de un PlatoServido en un Restaurante.

## 3. Restricciones o reglas del enunciado
- Un restaurante ofrece un máximo de 20 platos.
- A las personas les gustan los platos dependiendo de cómo los sirven en un restaurante específico, no el plato por sí mismo.

## 4. Justificación de decisiones (composición, asociación y multiplicidad)
- **Restaurante y Sucursal (composición):** una sucursal física no existe de manera independiente sin la entidad Restaurante a la que pertenece.
- **Restaurante y PlatoServido (asociación con restricción):** un restaurante ofrece platos. La multiplicidad es `1` a `0..20` por la restricción del enunciado.
- **PlatoServido y Plato (asociación):** `PlatoServido` referencia al plato base que se sirve.
- **Persona y Restaurante (asociación):** relación de “frecuenta”, de muchos a muchos.
- **Persona y PlatoServido (asociación):** relación de “le gusta”, de muchos a muchos.

## 5. Dudas abiertas o problemas encontrados
- La relación “le gusta” originalmente puede interpretarse como ternaria entre Persona, Plato y Restaurante. Se modeló con `PlatoServido` para simplificar y dejar explícito el contexto del restaurante.
- Si se quisiera un modelo más estricto, podría revisarse si `PlatoServido` debe estar vinculado directamente a una sucursal concreta.
