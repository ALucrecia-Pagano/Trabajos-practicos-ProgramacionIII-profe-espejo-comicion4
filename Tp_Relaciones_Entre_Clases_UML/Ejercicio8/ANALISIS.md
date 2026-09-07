# Análisis - Ejercicio 8 (Aeródromo)

## 1. Sustantivos detectados
- **Avión**: clase.
- **TipoAvion**: clase, separada de Avión porque varios aviones pueden compartir el mismo tipo.
- **Hangar**: clase.
- **Persona**: clase base.
- **Piloto**: subclase de Persona.
- **Mecánico**: subclase de Persona.
- **Propietario**: clase/rol vinculado a la propiedad del avión.
- **Servicio**: clase intermedia que resuelve la relación N:N entre Mecánico y Avión.

## 2. Verbos que conectan clases
- **se guarda**: Avión en Hangar.
- **es de tipo**: Avión es de TipoAvion.
- **es dueño de**: Propietario tiene Aviones.
- **realiza mantenimiento**: Mecánico realiza Servicio a Avión.
- **está autorizado a volar**: Piloto vuela TipoAvion.
- **puede dar mantenimiento**: Mecánico repara TipoAvion.

## 3. Restricciones o reglas del enunciado
- No puede haber dos servicios realizados al mismo avión en la misma fecha con el mismo tipo de trabajo.
- El avión se identifica por su matrícula.
- El propietario actual del avión tiene asociada la fecha de adquisición.

## 4. Justificación de decisiones (herencia, asociación, agregación y multiplicidad)
- **Persona, Piloto y Mecánico (herencia):** el enunciado define atributos comunes para Persona y atributos específicos para Piloto y Mecánico, por lo que corresponde una generalización.
- **Avión y TipoAvion (asociación):** un avión pertenece a un tipo, y un tipo puede corresponder a muchos aviones.
- **Avión y Hangar (asociación):** un avión se guarda en un hangar. No es composición porque el avión existe independientemente del hangar.
- **Mecánico, Avión y Servicio (clase intermedia):** la relación entre mecánico y avión es N:N y además tiene atributos propios (`fecha`, `horasInvertidas`, `tipoTrabajo`), por eso se modela `Servicio`.
- **Propietario y Avión (agregación):** el propietario es el todo lógico de la relación de posesión, pero el avión mantiene existencia independiente.

## 5. Dudas abiertas o problemas encontrados
- El atributo “fecha de adquisición por su propietario actual” debe quedar asociado al vínculo entre Propietario y Avión.
- Conviene revisar si la autorización de un piloto o mecánico sobre un `TipoAvion` puede cambiar con el tiempo, porque eso podría requerir una clase intermedia si se quiere historial.
