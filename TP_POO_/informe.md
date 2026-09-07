# Parte 1 — Diagnóstico de Java-ismos

## Checklist de referencia

El siguiente cuadro conserva el checklist de la actividad. No todos sus puntos
aparecen en este código; por ejemplo, no hay una interfaz vacía ni atributos con
doble guion bajo.

| # | Java-ismo posible | → Corrección aplicable |
|---|---|---|
| 1 | `get_x()` / `set_x()` sin lógica (Figura.getNombre, getColor) | `@property` (o acceso directo si no hay lógica) |
| 2 | `_doble_guion` creyendo que es private | `_simple` es la convención; `__doble` crea name mangling |
| 3 | Herencia de una clase base solo para tener un tipo común (Figura) | Duck typing o `Protocol` (interfaz sin herencia) |
| 4 | Una interfaz vacía para hacer `implements` (no aplica en este código) | `Protocol` en lugar de clase abstracta |
| 5 | `__init__` que solo asigna campos (Poligono, Triangulo, Cuadrado) | `@dataclass` (genera `__init__` automáticamente) |
| 6 | Stream traducido con `for + append + acumulador` (perimetro) | List comprehension o `sum()` |
| 7 | Confiar en que type hints protegen solos (area() -> int devuelve str) | Correr `mypy` o confesar que type hints son solo documentación |
| 8 | Sobrecarga de constructor: `__init__(*args)` + `isinstance()` (Triangulo, Cuadrado) | Argumentos con valor por defecto o `@classmethod` constructor |

## Ocho casos encontrados y corregidos

| # | Java-ismo | Dónde | Inversión que lo explica | Síntoma observable |
|---|---|---|---|---|
| 1 | Getters sin lógica | `Figura.getNombre`, `Figura.getColor` | Declaración → runtime | Cliente obligado a invocar métodos ceremoniales |
| 2 | Atributo de clase mutable usado como static | `Poligono.catalogo` | Declaración → runtime | Todas las instancias comparten una lista mutable |
| 3 | Argumentos mutables por defecto | `Poligono.__init__` | Declaración → runtime | Instancias distintas comparten observaciones o lados |
| 4 | Constructor que no delega en la clase base | `Poligono.__init__` | Herencia → acuerdo | `Figura.__init__` no se ejecuta y falta `_construida` |
| 5 | Alias de una lista recibida | `Poligono.__init__` | Encapsulamiento por convención | El llamador modifica el polígono desde afuera |
| 6 | Acumulador manual | `Poligono.perimetro` | Compilador → acuerdo | Código más extenso para una suma directa |
| 7 | Type hint que contradice el retorno | `Poligono.area` | Declaración → runtime | Se anuncia `int`, pero se devuelve `str` |
| 8 | Simulación de sobrecarga con `*args` | `Triangulo.__init__`, `Cuadrado.__init__` | Compilador → acuerdo | Firmas ambiguas y ramas por `isinstance` |

### Noveno hallazgo adicional

El getter `getLados` devolvía la lista real en lugar de una copia. Se corrigió
con `Poligono.lados()`, que devuelve una tupla defensiva. No lo cuento entre los
8 del checklist porque fue un hallazgo adicional trabajado con el profesor.

## Síntomas y explicaciones breves

**Getters y setters** → En Python, el acceso directo es idiomático. Se usa `@property` cuando hay validación o copia defensiva, como en `Lado.longitud`.

**Herencia para tipos comunes** → Python usa duck typing; una clase base común puede ser innecesaria. Este caso no se encontró en el código de partida porque `Figura` forma parte del dominio.

**`__init__` repetitivo** → `@dataclass` puede generar asignaciones automáticamente, aunque no era necesario para todas las clases del dominio.

**6**: Bucles manuales → `sum()` + generator o list comprehension es más legible y eficiente.

**Type hints falsos** → `mypy` puede detectarlos. Los type hints documentan y permiten analizar, pero no se validan solos en runtime.

**Sobrecarga de constructor** → Python no ofrece múltiples `__init__`; una firma explícita con valores por defecto es más clara.

## Parte 2 — Relaciones

### Pregunta obligatoria: ¿cómo se distingue agregación de composición si la sintaxis es idéntica?

Las tres relaciones usan `self._algo = algo` para guardar la referencia, pero
la diferencia no está en la sintaxis: está en **quién crea el objeto relacionado
y qué pasa con su ciclo de vida**.

---

**Composición — `Poligono` ↔ `Lado` (3..\*)**

`parte1_diagnostico.py`, línea donde se crean los lados de `PoligonoRegular`:

```python
super().__init__(nombre, color, [Lado(medida) for _ in range(cantidad)])
```

Los `Lado` se construyen **dentro** del constructor de `PoligonoRegular`. Nadie
fuera del polígono tiene referencia a esos objetos; si el polígono desaparece,
los lados no tienen sentido de existir por separado. Eso es composición: el
compuesto fabrica y posee sus partes.

---

**Agregación — `Taller` ↔ `Poligono` (0..\*)**

`parte2_relaciones.py`, línea 17:

```python
def recibir(self, poligono: Poligono) -> None:
    self._inventario.append(poligono)
```

El `Poligono` llega **ya construido** como argumento. El `Taller` solo guarda
la referencia. Si el taller cierra (el objeto `Taller` se elimina), los
polígonos siguen existiendo en otro lugar. Eso es agregación: el contenedor no
fabrica ni destruye lo que contiene.

---

**Asociación — `Lado` ↔ `Etiqueta` (0..1)**

`parte2_relaciones.py`, línea 10:

```python
def etiquetar_lado(lado: Lado, texto: str) -> None:
    lado.etiqueta = Etiqueta(texto)
```

La `Etiqueta` se crea fuera de `Lado` y se asigna opcionalmente. Un lado puede
existir sin etiqueta (`None`), y una etiqueta puede conceptualmente describir
cualquier cosa. No hay relación de propiedad ni de ciclo de vida compartido.
Eso es asociación: vínculo débil entre objetos independientes.

---

**Resumen de la diferencia en una línea**

| Relación | Quién crea el objeto relacionado | Si el "contenedor" desaparece |
|---|---|---|
| Composición (`Poligono`→`Lado`) | El propio `Poligono` (dentro del `__init__`) | Los `Lado` no tienen existencia propia |
| Agregación (`Taller`→`Poligono`) | Código externo, antes de llamar a `recibir` | Los `Poligono` siguen existiendo |
| Asociación (`Lado`→`Etiqueta`) | Código externo, vía `etiquetar_lado` | La `Etiqueta` existe independientemente |

## Parte 3 — Herencia justificada por dominio

### Decisión sobre `PoligonoRegular`

En el código de partida, `PoligonoRegular` hereda de `Poligono` solo para poder
convivir con `Triangulo` y `Cuadrado` bajo el mismo tipo. Pero esa necesidad
es de Java, no de Python: acá no hace falta que dos objetos compartan un
ancestro común para estar en la misma lista (`[1, "hola", Lado(3)]` es una
lista válida, con tipos que no tienen nada que ver entre sí).

Sacando ese argumento de encima, queda la pregunta real: ¿un "polígono
regular" es un tipo de figura distinto, con comportamiento propio? No. Es la
misma figura de siempre (un pentágono, un hexágono) con una restricción extra:
todos los lados miden igual. La prueba está en cómo estaba armada la clase:
la cantidad de lados no la definía el tipo, se la pasabas vos como parámetro
cada vez (`PoligonoRegular(nombre, color, medida, cantidad)`). Eso ya es una
señal de que no estaba modelando un "es-un" del dominio, sino resolviendo un
problema de organización de código.

**Decisión:** se elimina `PoligonoRegular` de la jerarquía de herencia. En su
lugar, se agrega una función `crear_regular(clase, medida)` que construye un
`Triangulo`, `Cuadrado`, `Pentagono` o `Hexagono` ya existente, con todos los
lados iguales a `medida`. Para esto, `lados_esperados()` pasó de ser un método
de instancia a un `@classmethod`: la cantidad de lados es un dato de la clase
(un triángulo siempre tiene 3, exista o no un triángulo construido), no de un
objeto particular ya armado. Eso permite que `crear_regular` le pregunte a la
clase cuántos lados necesita *antes* de construir el objeto, sin el problema
de "necesito instanciar para saber cuántos lados, pero no puedo instanciar sin
lados".

## Parte 4 — ABC vs. Protocol

### Punto 3 — ¿Por qué una ABC no hubiera servido para PlanoCAD?

Con una ABC, para que `PlanoCAD` "cumpla" el contrato `Exportable` tendría que
heredar explícitamente de él — eso significa modificar `libreria_externa.py`,
algo que la consigna prohíbe. No se trata de adaptar el código a la librería:
directamente no hay forma de hacer que una ABC funcione sin tocar la clase
ajena, porque una ABC valida por herencia, no por forma.

Con `Protocol`, en cambio, no hace falta que `PlanoCAD` sepa que `Exportable`
existe. Cumple el contrato solo por tener un método `exportar() -> str` con la
firma correcta — "por casualidad", como dice el propio docstring del archivo.

### ¿Lo decide el lenguaje o el dominio?

Lo decide el dominio, pero no porque "Python no sea tipado y corra igual" —
esa razón valdría para cualquier decisión del TP. La razón puntual acá es que
"ser un polígono" es identidad (una jerarquía "es-un": un `Pentagono` siempre
es un `Poligono`), mientras que "ser exportable" es un rol, una capacidad que
comparten objetos sin parentesco entre sí (`Poligono` y `PlanoCAD` no tienen
nada que ver, salvo que ambos saben exportar). El dominio es el que dice cuál
de las dos cosas es cada relación; el lenguaje solo te da la herramienta
correcta para cada una: `ABC` para identidad, `Protocol` para rol.



