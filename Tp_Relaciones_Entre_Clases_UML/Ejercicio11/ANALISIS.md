# Ejercicio 11 - Análisis (Cosmética Natural)

## Enunciado original
Cosmética Natural, una empresa de venta directa, solicitó implementar parte de su funcionamiento en forma inmediata, con vistas a sistematizar todos sus procesos a corto plazo. Con este fin aportó la siguiente información:
La empresa fabrica en su laboratorio diversos productos, los cuales distribuye exclusivamente a través de sus representantes de ventas. Identifica a cada producto por su nombre y ha fijado un único precio para cada uno de ellos, el de venta al público.
La estructura de ventas se organiza en equipos coordinados por líderes. De cada líder se registra su nombre, dirección, teléfono, fecha de nacimiento, CUIT o CUIL, la fecha de su incorporación a la empresa y la fecha de su promoción a la categoría de líder, así como su equipo de vendedores. De cada vendedor se asienta la misma información, excepto la fecha de promoción a la categoría de líder, la cual se registra oportunamente, dado el caso.
Todos los representantes de ventas, vendedores y líderes, poseen su propia cartera de clientes, de los cuales se registra el nombre, dirección, teléfono y fecha de nacimiento, así como la fecha de ingreso a la empresa en calidad de cliente, con fines promocionales y de seguimiento.
Los vendedores y líderes adquieren cada producto en forma directa a la empresa, el  cual abonan contra entrega de un ticket de venta por unidad que registra la fecha, el producto y el precio. Los tickets se emiten por triplicado con el fin de que, una vez efectuada la venta final, el representante complete una de las copias con el nombre del cliente y la remita a la empresa para que se registre este dato.
Una vez por mes la empresa lleva a cabo una reunión general con toda su fuerza de ventas, en la cual informa la fecha de la próxima reunión, manteniendo el registro tanto de la última como de la próxima reunión, y brinda información de seguimiento de ventas. 
En la oportunidad, la empresa rinde a cada representante un importe en concepto de  comisión, el cual calcula a partir de un porcentaje fijo para toda la fuerza de ventas,  según el siguiente criterio:
A cada vendedor se le reintegra el porcentaje de comisión sobre el monto total de sus ventas registradas desde la fecha de la última reunión general.
A cada líder se le reintegra, además, el mismo porcentaje de comisión sobre el monto total de las ventas registradas de sus vendedores en el mismo período.

## 1. Sustantivos detectados

| Sustantivo | ¿Clase o atributo? |

| productos | Clase (Producto) |
| representantes de ventas | Clase abstracta (Representante) |
| líder | Clase (Lider extends Representante) |
| vendedor | Clase (Vendedor extends Representante) |
| clientes | Clase (Cliente) |
| ticket de venta | Clase (Ticket) |
| reunión general | Clase (ReunionGeneral) |
| comisión | No es clase ni atributo: es un valor calculado (ComisionCalculator) |
| precio de venta al público | Atributo (double, en Producto) |
| fecha de incorporación / promoción | Atributos (LocalDate, en Representante/Lider) |

## 2. Verbos que conectan clases

| Frase | Relación |

| líder tiene su equipo de vendedores | Lider o-- Vendedor (agregación) |
| representantes poseen su cartera de clientes | Representante o-- Cliente (agregación) |
| vendedores/líderes adquieren productos (tickets) | Representante *-- Ticket (composición) |
| ticket registra el producto | Ticket --> Producto (asociación) |
| representante completa el ticket con el nombre del cliente | Ticket --> Cliente (asociación, opcional/nullable) |

## 3. Restricciones / reglas

- Un Ticket recién emitido no tiene cliente asignado; se completa cuando se concreta la venta final (esVentaConcretada()).
- Solo se consideran "ventas" para el cálculo de comisión los tickets con venta concretada, desde la fecha de la última reunión general.
- La comisión de un vendedor: % sobre sus propias ventas del período.
- La comisión de un líder: % sobre sus propias ventas MÁS % sobre las ventas de todo su equipo, en el mismo período.

## 4. Justificación composición/agregación y multiplicidades

- **Representante *-- Ticket**: Composición. Multiplicidad: Representante "1" -- "0..*" Ticket. Un ticket no tiene sentido fuera del representante que lo generó (es su propio registro de compra a la empresa).
- **Representante o-- Cliente**: Agregación. Multiplicidad: Representante "0..*" -- "0..*" Cliente (un cliente podría, en teoría, ser atendido por más de un representante a lo largo del tiempo, y un representante tiene varios clientes). Un cliente tiene existencia propia, no depende de un único representante.
- **Lider o-- Vendedor**: Agregación. Multiplicidad: Lider "1" -- "0..*" Vendedor. Un vendedor existe y opera de forma independiente, con o sin líder asignado en un momento dado.
- **Ticket --> Producto**: Asociación simple. Multiplicidad: Ticket "1..*" -- "1" Producto (un producto puede estar en muchos tickets; cada ticket referencia exactamente un producto).
- **Ticket --> Cliente**: Asociación simple, opcional. Multiplicidad: Ticket "0..*" -- "0..1" Cliente (un ticket puede no tener cliente todavía; un cliente puede tener muchos tickets asociados).

## 5. Dudas abiertas

- ¿Un Cliente puede pertenecer a la cartera de más de un Representante al mismo tiempo, o es exclusivo de uno solo? Se modeló como posible compartir (agregación 0..*—0..*), pero el enunciado no lo aclara del todo.
- La clase Lider hereda de Representante, pero el enunciado aclara que un Vendedor puede "promocionar" a Líder en algún momento. El modelo actual no contempla ese cambio de tipo en tiempo de ejecución (en Java no se puede "convertir" un objeto Vendedor en Lider dinámicamente) — ¿se esperaría modelarlo distinto, por ejemplo con un rol/estado en vez de subclases separadas?
- No se implementó el ticket "por triplicado" mencionado en el enunciado (una copia para la empresa, una para el cliente, una para el representante) — se simplificó a un solo objeto Ticket por venta.