import java.util.ArrayList;
import java.util.List;

public class Investigador extends Cargo{
    private String titulacion;
    private List<ProyectoInvestigacion> proyectos;


    //Constructor
    public Investigador(String titulacion) {
        this.titulacion = titulacion;
        this.proyectos = new ArrayList<>();
    }

    //Metodo para asignarle un proyecto a un investigador
    public void asignarProyecto(ProyectoInvestigacion proyecto) {
        proyectos.add(proyecto);
    }

    @Override
    public String getDescripcionCargo() {
        return "Investigador [Titulación: " + titulacion + ", Proyectos: " + proyectos.size() + "]";
    }

}
