import java.util.ArrayList;
import java.util.List;

public class Comisario {
    private String dni;
    private String nombre;
    private List<Evento> eventosAsignados;



    //Constructor
    public Comisario(String dni, String nombre) {
        this.dni = dni;
        this.nombre = nombre;
        this.eventosAsignados = new ArrayList<>();
    }


    //Metodo para agregar un evento
    public void agregarEvento(Evento evento) {
        eventosAsignados.add(evento);
    }


    //Getters
    public String getNombre() { return nombre; }
    public String getDni() { return dni; }




}
