import java.time.LocalDate;

public class RegistroVisita {
    private LocalDate fecha;
    private Visitante visitante;

    public RegistroVisita(LocalDate fecha, Visitante visitante) {
        this.fecha = fecha;
        this.visitante = visitante;
    }

    public Visitante getVisitante() { return visitante; }
    public LocalDate getFecha() { return fecha; }
}
