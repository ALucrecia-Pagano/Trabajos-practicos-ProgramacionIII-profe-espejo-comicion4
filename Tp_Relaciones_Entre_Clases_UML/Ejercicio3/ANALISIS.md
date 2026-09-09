# Ejercicio 3 - Análisis (control de gasto público)

# Enunciado original
Un país tiene que controlar el gasto público de las ciudades con más de 100.000 habitantes. Para ello, tiene información del monto recaudado por cada ciudad a través de cinco diferentes tipos de impuestos (denominados, aquí, de imp1, imp2, imp3, imp4 e imp5) e información acerca de gastos realizados en mantenimiento de la ciudad. Este país necesita un sistema que le informe cuales son las ciudades que gastan mas de lo que recaudan, y las provincias que tienen mas de la mitad de las ciudades en condición de déficit.

# 1. Sustantivos detectados 

Sustantivo  ¿Clase o atributo? 

 país --> Clase (Pais) 
 provincias --> Clase (Provincia) 
 ciudades --> Clase (Ciudad) 
 habitantes --> Atributo (int, en Ciudad) 
 monto recaudado --> Atributo (double monto, en Impuesto) 
 tipos de impuestos (imp1..imp5) --> Clase enum (TipoImpuesto) 
 gastos de mantenimiento --> Clase (Gasto) 
 déficit --> es un valor calculado (estaEnDeficit()) 

## 2. Verbos que conectan clases

 Frase  Relación 

 país tiene provincias --> Pais *-- Provincia (composición) 
 provincias tienen ciudades --> Provincia *-- Ciudad (composición) 
 ciudad recauda impuestos --> Ciudad *-- Impuesto (composición) 
 ciudad realiza gastos --> Ciudad *-- Gasto (composición) 
 ciudades/provincias "están en déficit" --> Ciudad y Provincia implementan Calculable 

## 3. Restricciones / reglas

- Solo se controlan ciudades con más de 100.000 habitantes (esControlada()).
- Una ciudad está en déficit si gastoTotal > recaudacionTotal.
- Una provincia está en déficit si más de la mitad de sus ciudades controladas están en déficit.

## 4. Justificación composición/agregación y multiplicidades

- Pais *-- Provincia (1 -- 1..*): composición, una provincia no existe fuera de su país.
- Provincia *-- Ciudad (1 -- 1..*): composición, misma razón.
- Ciudad *-- Impuesto (1 -- 1..*): composición; se dejó abierto (1..*) en vez de fijo en 5, para tolerar que se agreguen nuevos tipos de impuesto sin romper el modelo, aunque el enunciado hoy define exactamente 5.
- Ciudad *-- Gasto (1 -- 0..*): composición; el mínimo es 0 porque una ciudad puede no tener gastos registrados todavía.
- Impuesto --> TipoImpuesto (1 -- 1): asociación simple, no es parte-todo.

## 5. Dudas abiertas

- ¿La cantidad de tipos de impuesto (5) es fija para siempre, o el modelo debe tolerar que se agreguen más? Se decidió modelarlo como 1..* por flexibilidad, aunque el enunciado da un número cerrado.
- ¿Qué pasa con provincias sin ninguna ciudad controlada (todas con menos de 100.000 hab.)? Se decidió que no entran en el reporte de déficit.
- ¿El monto recaudado corresponde a un período (mensual/anual) o es acumulado histórico? No está aclarado en el enunciado.