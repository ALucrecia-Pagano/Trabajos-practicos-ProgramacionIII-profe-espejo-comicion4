import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Evento {
    private String nombre;
    private LocalDate fecha;
    private int duracionMinutos;
    private int numeroParticipantes;
    private List<Material> materiales;
    private List<Comisario> comisarios;


    //Constructor
    public Evento(String nombre, LocalDate fecha, int duracionMinutos, int numeroParticipantes) {
        this.nombre = nombre;
        this.fecha = fecha;
        this.duracionMinutos = duracionMinutos;
        this.numeroParticipantes = numeroParticipantes;
        this.materiales = new ArrayList<>();
        this.comisarios = new ArrayList<>();
    }


    //Getter
    public int getNumeroComisarios() {
        return comisarios.size();
    }




    //Metodo para agregar un material, asignar un comisario y mostrar los detalles del evento
    public void agregarMaterial(Material material) {
        materiales.add(material);
    }

    public void asignarComisario(Comisario comisario) {
        comisarios.add(comisario);
        comisario.agregarEvento(this);
    }


    public void mostrarDetalle() {
        System.out.println("  - Evento: " + nombre + " (" + fecha + ", " + duracionMinutos + " min) | Participantes: " + numeroParticipantes + " | Comisarios: " + getNumeroComisarios());
        System.out.print("    Materiales: ");
        for (Material m : materiales) {
            System.out.print(m.getNombre() + " (" + m.getCantidad() + ") ");
        }
        System.out.println();
    }
}
