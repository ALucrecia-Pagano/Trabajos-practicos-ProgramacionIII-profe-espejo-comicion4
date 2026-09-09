import java.time.LocalDate;

public class ReunionGeneral {
    private LocalDate fechaUltimaReunion;
    private LocalDate fechaProximaReunion;

    public ReunionGeneral(LocalDate fechaUltimaReunion, LocalDate fechaProximaReunion) {
        this.fechaUltimaReunion = fechaUltimaReunion;
        this.fechaProximaReunion = fechaProximaReunion;
    }

    public LocalDate getFechaUltimaReunion() { return fechaUltimaReunion; }
}
