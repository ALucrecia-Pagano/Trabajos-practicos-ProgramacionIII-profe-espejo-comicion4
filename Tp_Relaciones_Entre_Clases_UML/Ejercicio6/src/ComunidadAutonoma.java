import java.util.ArrayList;
import java.util.List;

public class ComunidadAutonoma {

    private String nombre;
    private OrganismoResponsable organismoResponsable;
    private List<ParqueNatural> parques;


    //Constructor
    public ComunidadAutonoma(String nombre, OrganismoResponsable organismoResponsable) {
        this.nombre = nombre;
        this.organismoResponsable = organismoResponsable;
        this.parques = new ArrayList<>();
    }

    public void agregarParque(ParqueNatural parque) {
        parques.add(parque);
    }

    public String getNombre() { return nombre; }
}
