import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ParqueNatural {
    private String nombre;
    private LocalDate fechaDeclaracionPN;
    private List<Area> areas;
    private List<Entrada> entradas;
    private List<Alojamiento> alojamientos;
    private List<Personal> personal;


    //Constructor
    public ParqueNatural(String nombre, LocalDate fechaDeclaracionPN) {
        this.nombre = nombre;
        this.fechaDeclaracionPN = fechaDeclaracionPN;
        this.areas = new ArrayList<>();
        this.entradas = new ArrayList<>();
        this.alojamientos = new ArrayList<>();
        this.personal = new ArrayList<>();
    }
    //Metodos para agregar area, entrada, alojamiento y poder contratar nuevo personal dentro del Parque
    public void agregarArea(Area area) { areas.add(area); }
    public void agregarEntrada(Entrada entrada) { entradas.add(entrada); }
    public void agregarAlojamiento(Alojamiento alojamiento) { alojamientos.add(alojamiento); }
    public void contratarPersonal(Personal p) { personal.add(p); }

    public void mostrarResumen() {
        System.out.println("=================================================");
        System.out.println("PARQUE NATURAL: " + nombre + " (Declarado: " + fechaDeclaracionPN + ")");
        System.out.println("Áreas: " + areas.size() + " | Entradas: " + entradas.size() + " | Alojamientos: " + alojamientos.size());
        System.out.println("Personal Activo:");
        for (Personal p : personal) {
            p.mostrarPerfil();
        }
        System.out.println("=================================================");
    }
}
