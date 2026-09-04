"""demo_sintomas.py — Demostración de síntomas ANTES del arreglo.

Reproduce dos de los ocho java-ismos encontrados en parte1_diagnostico.py.
Cada bloque muestra el comportamiento roto y luego la corrección aplicada.

Síntoma 1 — Argumento mutable por defecto (java-ismo #3)
Síntoma 2 — Alias de lista recibida sin copiar (java-ismo #5)
"""

print("=" * 60)
print("SÍNTOMA 1: argumento mutable por defecto")
print("=" * 60)

# ── ANTES (código del diagnóstico) ──────────────────────────────────────────
# En parte1_diagnostico.py, Poligono.__init__ tiene esta firma:
#
#   def __init__(self, nombre, color, lados=[], observaciones=[]):
#
# El objeto [] se crea UNA sola vez cuando Python interpreta la definición
# de la función. Todas las instancias que no pasen observaciones comparten
# ese mismo objeto en memoria.

class PoligonoANTES:
    def __init__(self, nombre, color, lados=[], observaciones=[]):
        self._nombre = nombre
        self._color = color
        self._lados = lados
        self._observaciones = observaciones

    def agregar_observacion(self, texto):
        self._observaciones.append(texto)

    def observaciones(self):
        return self._observaciones


p1 = PoligonoANTES("Triángulo", "rojo")
p2 = PoligonoANTES("Cuadrado", "azul")

p1.agregar_observacion("revisar vértice A")

print(f"Observaciones de p1: {p1.observaciones()}")
print(f"Observaciones de p2: {p2.observaciones()}")   # ← debería estar vacío
print(f"p1._observaciones is p2._observaciones → {p1._observaciones is p2._observaciones}")
# Salida esperada: True  (las dos instancias COMPARTEN la misma lista)

# ── DESPUÉS (corrección aplicada) ────────────────────────────────────────────
print()
print("--- Después del arreglo ---")

class PoligonoDESPUES:
    def __init__(self, nombre, color, lados=None, observaciones=None):
        self._nombre = nombre
        self._color = color
        self._lados = list(lados) if lados is not None else []
        self._observaciones = list(observaciones) if observaciones is not None else []

    def agregar_observacion(self, texto):
        self._observaciones.append(texto)

    def observaciones(self):
        return self._observaciones


q1 = PoligonoDESPUES("Triángulo", "rojo")
q2 = PoligonoDESPUES("Cuadrado", "azul")

q1.agregar_observacion("revisar vértice A")

print(f"Observaciones de q1: {q1.observaciones()}")
print(f"Observaciones de q2: {q2.observaciones()}")   # ← ahora sí vacío
print(f"q1._observaciones is q2._observaciones → {q1._observaciones is q2._observaciones}")
# Salida esperada: False  (cada instancia tiene su propia lista)


print()
print("=" * 60)
print("SÍNTOMA 2: alias de lista recibida sin copiar")
print("=" * 60)

# ── ANTES ────────────────────────────────────────────────────────────────────
# En parte1_diagnostico.py:
#
#   self._lados = lados   ← guarda la referencia, no una copia
#
# Si el llamador modifica su lista original, el polígono queda afectado
# sin que nadie lo haya pedido.

class LadoSimple:
    def __init__(self, longitud):
        self._longitud = longitud
    def getLongitud(self):
        return self._longitud

class PoligonoAliasANTES:
    def __init__(self, nombre, color, lados=None, observaciones=None):
        self._nombre = nombre
        self._color = color
        self._lados = lados if lados is not None else []   # ← alias

    def perimetro(self):
        total = 0
        for l in self._lados:
            total = total + l.getLongitud()
        return total

    def lados(self):
        return self._lados   # ← devuelve la lista interna directa


lados_externos = [LadoSimple(3), LadoSimple(4), LadoSimple(5)]
tri = PoligonoAliasANTES("Triángulo", "rojo", lados_externos)

print(f"Perímetro inicial: {tri.perimetro()}")          # 12.0

# El llamador modifica su lista después de construir el polígono
lados_externos.append(LadoSimple(99))

print(f"Perímetro luego de modificar lista externa: {tri.perimetro()}")  # 111.0 — ¡cambió!
print(f"lados_externos is tri._lados → {lados_externos is tri._lados}")  # True

# ── DESPUÉS ──────────────────────────────────────────────────────────────────
print()
print("--- Después del arreglo ---")

class PoligonoAliasDESPUES:
    def __init__(self, nombre, color, lados=None, observaciones=None):
        self._nombre = nombre
        self._color = color
        self._lados = list(lados) if lados is not None else []   # ← copia

    def perimetro(self):
        return sum(l.getLongitud() for l in self._lados)

    def lados(self):
        return tuple(self._lados)   # ← copia defensiva al leer


lados_externos2 = [LadoSimple(3), LadoSimple(4), LadoSimple(5)]
tri2 = PoligonoAliasDESPUES("Triángulo", "rojo", lados_externos2)

print(f"Perímetro inicial: {tri2.perimetro()}")         # 12.0

lados_externos2.append(LadoSimple(99))

print(f"Perímetro luego de modificar lista externa: {tri2.perimetro()}")  # 12.0 — no cambia
print(f"lados_externos2 is tri2._lados → {lados_externos2 is tri2._lados}")  # False
