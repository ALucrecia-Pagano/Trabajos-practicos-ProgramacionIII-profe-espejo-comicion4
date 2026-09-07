import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Federacion fedArg = new Federacion("Federacion Argentina de Ski", 500);

        EstacionEsqui catedral = new EstacionEsqui("EST-01", "Cerro Catedral");
        fedArg.administrar(catedral);
        catedral.agregarPista(new Pista(catedral, 1, 3.5, "Roja"));

        Esquiador juan = new Esquiador("30111222", "Juan Perez", LocalDate.of(1998, 5, 10), fedArg);
        Esquiador ana = new Esquiador("30333444", "Ana Gomez", LocalDate.of(2000, 3, 22), fedArg);

        Prueba slalom = new Prueba("Slalom Bariloche", TipoPrueba.SLALOM, false, catedral);
        slalom.agregarFecha(LocalDate.of(2026, 8, 20));

        Inscripcion insJuan = slalom.inscribir(juan, 1);
        Inscripcion insAna = slalom.inscribir(ana, 2);

        slalom.registrarResultado(insJuan, 65.2, 1);
        slalom.registrarResultado(insAna, 68.9, 2);

        System.out.println("Vencedor: " + slalom.getVencedor() + " con tiempo " + slalom.getTiempoVencedor());
    }
}
