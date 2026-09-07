import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Exposicion {
    private String nombre;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private List<ObjetoArte> obrasExhibidas; // Agregación

    public Exposicion(String nombre, LocalDate fechaInicio, LocalDate fechaFin) {
        this.nombre = nombre;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.obrasExhibidas = new ArrayList<>();
    }

    public void agregarObjeto(ObjetoArte obra) {
        obrasExhibidas.add(obra);
    }

    public void mostrarCatalogoExposicion() {
        System.out.println("\n=== Exposición: " + nombre + " (" + fechaInicio + " al " + fechaFin + ") ===");
        for (ObjetoArte obra : obrasExhibidas) {
            obra.mostrarFichaTecnica();
        }
    }
}
