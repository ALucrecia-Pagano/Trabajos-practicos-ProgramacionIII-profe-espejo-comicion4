import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Alojamiento {
    private String nombre;
    private int capacidad;
    private String categoria;
    private List<Estancia> estancias;
    private List<Excursion> excursionesOrganizadas;

    //Constructor
    public Alojamiento(String nombre, int capacidad, String categoria) {
        this.nombre = nombre;
        this.capacidad = capacidad;
        this.categoria = categoria;
        this.estancias = new ArrayList<>();
        this.excursionesOrganizadas = new ArrayList<>();
    }

    //Metodos para registrar una estancia

    public void registrarEstancia(String habitacion, LocalDate inicio, LocalDate fin, Visitante visitante) {
        estancias.add(new Estancia(habitacion, inicio, fin, visitante));
    }

    public void agregarExcursion(Excursion excursion) {
        excursionesOrganizadas.add(excursion);
    }

    public String getNombre() { return nombre; }
}
