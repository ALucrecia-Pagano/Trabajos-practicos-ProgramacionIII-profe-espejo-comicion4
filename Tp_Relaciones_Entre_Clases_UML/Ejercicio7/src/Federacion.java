import java.util.ArrayList;
import java.util.List;

public class Federacion {
    private String nombre;
    private int numFederados;
    private List<EstacionEsqui> estacionesAdministradas = new ArrayList<>();

    public Federacion(String nombre, int numFederados) {
        this.nombre = nombre;
        this.numFederados = numFederados;
    }

    public void administrar(EstacionEsqui estacion) {
        estacionesAdministradas.add(estacion);
    }

    public String getNombre() { return nombre; }

    @Override
    public String toString() { return nombre; }
}