# Tp_Relaciones_Entre_Clases_UML
Este es un trabajo práctico para la materia de (Programación 3) de la Tecnicatura Universitaria en Programación. UTN FRM.

**Integrantes:** Amanda Pagano, Mateo Liendo, Lucas Ávila

## Consigna de entrega (por cada ejercicio)

1. Diagrama de clases en archivo editable (no alcanza con la imagen).
2. Sustantivos detectados (aclarando si quedaron como clase o atributo), verbos que conectan clases, y restricciones o reglas del enunciado.
3. Justificación de decisiones: para cada relación todo-parte, si es composición o agregación y por qué; y el fundamento de las multiplicidades elegidas (1..n, 1..1, n..n).
4. Dudas abiertas o problemas encontrados.

## Estructura de cada ejercicio

EjercicioN/
├── ANALISIS.md    → sustantivos, verbos, reglas, justificación de comp/agreg, dudas abiertas
├── uml/            → diagrama de clases editable (según el ejercicio: .uxf de UMLetino, código
│                      Mermaid en .md, y/o imagen .png exportada)
└── src/            → código Java de referencia (complementario, no pedido explícitamente por la consigna)

Nota: el formato del diagrama varía un poco entre ejercicios (UMLetino vs. Mermaid) según qué
herramienta se usó, pero en todos los casos hay un archivo de texto editable dentro de uml/,
no solo una imagen.

## Cómo ver los diagramas

Los diagramas de cada `UML.md` están en formato [Mermaid](https://mermaid.js.org/) y se renderizan automáticamente al abrir el archivo en GitHub. Para editarlos, se puede pegar el código en [mermaid.live](https://mermaid.live) y previsualizar los cambios en tiempo real.

Algunos ejercicios (3 y 4) además tienen un archivo `.uxf` hecho en [UMLetino](https://umletino.com), que se puede reabrir ahí mismo para seguir editando visualmente.

## Cómo correr el código Java de un ejercicio

Si te aparece el ícono ▶️ (Run) arriba del método `main` en VS Code, podés usar eso directamente.

Si no te aparece, corré manualmente desde la carpeta `src` del ejercicio correspondiente:

1. `javac *.java` (compila todo)
2. `java Main` (ejecuta)

**Importante:** después de probarlo, borrá los archivos `.class` que se generan (son el código ya compilado, no hace falta subirlos a GitHub). Si te olvidás, no pasa nada grave — están en el `.gitignore`, así que Git los va a ignorar solo y no se van a subir por error.

## Estado de los ejercicios

| Ejercicio | Tema | Estado |

| 1 | Figuras geométricas | ✅ Completo |
| 2 | Países y provincias | ✅ Completo |
| 3 | Control de gasto público | ✅ Completo |
| 4 | Cooperativa de agricultores | ✅ Completo |
| 5 | Restaurantes y platos | ✅ Completo |
| 6 | Parques nacionales | ✅ Completo |
| 7 | Campeonato de esquí | ✅ Completo |
| 8 | Aeródromo | ✅ Completo |
| 9 | Museo | ✅ Completo |
| 10 | Juegos olímpicos | ✅ Completo |
| 11 | Cosmética Natural | ✅ Completo |