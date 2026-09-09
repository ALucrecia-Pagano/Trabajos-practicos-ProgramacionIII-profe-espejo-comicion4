import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        // Crear Sede Olímpica
        SedeOlimpica sede = new SedeOlimpica("Parque Olímpico Central", 12500000.0); //->Va a mostrar un valor 1.25E7 (Porque es un numero bastante grande)

        // Crear Complejo Unideportivo (Pista de Atletismo)
        ComplejoUnideportivo estadioAtletismo = new ComplejoUnideportivo(
                "Estadio Olímpico", "Sector Norte", "Laura Morales", 45000.0, "Atletismo");
        estadioAtletismo.agregarArea(new AreaDesignada("Carreras de velocidad", "Pista central"));
        estadioAtletismo.agregarArea(new AreaDesignada("Salto con pértiga", "Esquina N-E"));

        // Crear Polideportivo (Pabellón Multiuso)
        Polideportivo pabellon = new Polideportivo(
                "Pabellón Multidisciplinario", "Sector Sur", "Marcos Gómez", 28000.0);
        pabellon.agregarArea(new AreaDesignada("Gimnasia Artística", "Centro"));
        pabellon.agregarArea(new AreaDesignada("Balonmano", "Cancha A"));

        // Crear Comisarios
        Comisario juez1 = new Comisario("10203040A", "Ana Ruiz");
        Comisario juez2 = new Comisario("50607080B", "Carlos Díaz");

        // Crear Eventos y asignarles Material y Comisarios
        Evento carrera100m = new Evento("100 Metros Llanos - Final", LocalDate.of(2026, 7, 24), 30, 8);
        carrera100m.agregarMaterial(new Material("Tacos de salida", 8));
        carrera100m.agregarMaterial(new Material("Pistola de largada", 1));
        carrera100m.asignarComisario(juez1);

        Evento saltoPertiga = new Evento("Salto con Pértiga - Clasificatoria", LocalDate.of(2026, 7, 25), 120, 16);
        saltoPertiga.agregarMaterial(new Material("Pértigas", 20));
        saltoPertiga.agregarMaterial(new Material("Colchonetas de caída", 2));
        saltoPertiga.asignarComisario(juez1);
        saltoPertiga.asignarComisario(juez2);

        estadioAtletismo.celebrarEvento(carrera100m);
        estadioAtletismo.celebrarEvento(saltoPertiga);

        // Registrar en Sede y mostrar salida
        sede.agregarComplejo(estadioAtletismo);
        sede.agregarComplejo(pabellon);

        sede.mostrarResumenSede();

    }
}
