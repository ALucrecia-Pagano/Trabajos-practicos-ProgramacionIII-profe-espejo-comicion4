import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ProyectoInvestigacion {
    private String nombre;
    private double presupuesto;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private List<Especie> especiesInvestigadas;

    public ProyectoInvestigacion(String nombre, double presupuesto, LocalDate fechaInicio, LocalDate fechaFin) {
        this.nombre = nombre;
        this.presupuesto = presupuesto;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.especiesInvestigadas = new ArrayList<>();
    }

    public void agregarEspecie(Especie e) {
        especiesInvestigadas.add(e);
    }

    public String getNombre() { return nombre; }
}
