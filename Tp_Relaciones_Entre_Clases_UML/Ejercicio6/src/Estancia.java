import java.time.LocalDate;

public class Estancia {
    private String habitacion;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private Visitante visitante;

    //Constructor
    public Estancia(String habitacion, LocalDate fechaInicio, LocalDate fechaFin, Visitante visitante) {
        this.habitacion = habitacion;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.visitante = visitante;
    }

    public String getHabitacion() { return habitacion; }
    public Visitante getVisitante() { return visitante; }
}
