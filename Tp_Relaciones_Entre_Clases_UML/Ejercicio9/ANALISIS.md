# Ejercicio 9 - Análisis (Museo de Arte)

## Enunciado original
El museo tiene una colección de objetos de arte. Cada uno tiene su nº de identificación, artista y año de creación (si se conocen), título y una descripción.

Los objetos de arte se clasifican en varias categorías. Basándose en su tipo se distinguen pinturas, esculturas y otros. Las pinturas incluyen el tipo de pintura (óleo, acuarela, ...), soporte (lienzo, papel, ...) y estilo (impresionista, abstracto, etc.). Para las esculturas se almacena el material (mármol, bronce, ...), altura, peso y estilo. Basándose en su pertenencia al museo se distinguen objetos en préstamo u objetos de la colección permanente. Para estos últimos se guarda la fecha de adquisición y coste además de si está en exposición o en almacén. Para las obras en préstamo se incluye el nombre de la colección a la que pertenece, la fecha en la que se recibió en préstamo y la fecha de devolución.

Por cada objeto de arte se tiene también información sobre su origen mediante información de su país y cultura (romano, egipcio, maya, etc.) y su época (renacimiento, neoclásico, etc.). También se guarda información de los artistas: su nombre (se supone que único), fecha de nacimiento y en su caso de defunción, país de origen, época, estilo principal y descripción.

En el museo se celebran diferentes exposiciones, cada una de ellas tiene un nombre que la identifica, tiene una fecha de comienzo y de finalización e incluye el conjunto de objetos de arte exhibidos. Sobre las colecciones de obras de arte con las que el museo intercambia obras es útil guardar su nombre (único), tipo (museo, colección privada, etc.), descripción, dirección, teléfono y el nombre de la persona de contacto.

## 1. Sustantivos detectados

| Sustantivo | ¿Clase o atributo? |
|---|---|
| Museo | Clase contenedora del dominio |
| Objeto de Arte | Clase abstracta (ObjetoDeArte) |
| Pintura | Clase concreta hija de ObjetoDeArte |
| Escultura | Clase concreta hija de ObjetoDeArte |
| Otro | Clase concreta hija de ObjetoDeArte |
| Pertenencia | Clase abstracta (estado legal/administrativo de una obra) |
| Colección Permanente | Clase hija de Pertenencia |
| En Préstamo | Clase hija de Pertenencia |
| Artista | Clase independiente |
| Colección Externa | Clase independiente |
| Exposición | Clase (Exposicion) |
| Nº identificación, título, descripción, año de creación, país, cultura, época | Atributos de ObjetoDeArte |
| Tipo de pintura, soporte, estilo | Atributos de Pintura |
| Material, altura, peso, estilo | Atributos de Escultura |
| Fecha de adquisición, coste, en exposición | Atributos de ColeccionPermanente |
| Fecha de recepción, fecha de devolución | Atributos de EnPrestamo |
| nombre, fecha de nacimiento/defunción, país de origen, época, estilo, descripción | Atributos de Artista |
| nombre, tipo, dirección, teléfono, contacto | Atributos de ColeccionExterna |
| nombre, fecha de inicio, fecha de fin | Atributos de Exposicion |

## 2. Verbos que conectan clases

| Frase | Relación |
|---|---|
| tener (colección de objetos/exposiciones) | Un Museo compone a ObjetoDeArte y agrega a Exposicion |
| clasificarse en / distinguirse | Herencia entre ObjetoDeArte y sus subtipos (Pintura, Escultura, Otro), y entre Pertenencia y sus subtipos |
| crear / ser creado por | Asociación entre ObjetoDeArte y Artista |
| pertenecer a (colección externa) | Asociación entre EnPrestamo y ColeccionExterna |
| exhibir / incluir | Una Exposicion agrega a ObjetoDeArte (Agregación) |

## 3. Restricciones / reglas

- El artista y el año de creación pueden ser desconocidos (atributos opcionales, multiplicidad 0..1).
- El nombre del artista y el nombre de la colección externa son únicos (identificadores clave).
- Una obra pertenece exclusivamente a una modalidad: o es de la colección permanente del museo o está en calidad de préstamo.
- Una exposición agrupa un conjunto de objetos de arte durante un intervalo de tiempo definido.

## 4. Justificación composición/agregación y multiplicidades

- **Un Museo compone a ObjetoDeArte (1 a \*)**: El catálogo de inventario pertenece al museo. Las obras no tienen existencia fuera del museo que las registra.
- **Un ObjetoDeArte compone a Pertenencia (1 a 1)**: Cada obra posee estrictamente un único estado de pertenencia que define sus datos administrativos. Se utiliza composición para evitar problemas de herencia múltiple en Java (evitando clases como PinturaPermanente o PinturaEnPrestamo).
- **Una Exposicion agrega a ObjetoDeArte (\* a 1..\*)**: Se modela como agregación porque las obras existen de forma independiente a la exposición temporal; la finalización de una exposición no destruye las obras exhibidas.
- **Un Museo agrega a Exposicion (1 a \*)**: El museo organiza eventos que tienen un ciclo de vida propio delimitado por fechas.
- **Un ObjetoDeArte se asocia a Artista (\* a 0..1)**: Un artista puede tener varias obras en el museo, pero una obra puede ser anónima (0..1).
- **Un EnPrestamo se asocia a ColeccionExterna (\* a 1)**: Muchas obras en préstamo pueden provenir de la misma colección externa o institución prestamista.
- **Una Exposicion se asocia a ObjetoDeArte (\* a 1..\*)**: Una exposición exhibe al menos un objeto de arte, y un objeto puede haber participado en múltiples exposiciones históricas.
