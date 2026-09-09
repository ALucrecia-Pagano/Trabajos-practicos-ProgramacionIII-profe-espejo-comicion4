import java.util.ArrayList;
import java.util.List;

public class Provincia implements Calculable {
    private String nombre;
    private List<Ciudad> ciudades = new ArrayList<>();

    public Provincia(String nombre) {
        this.nombre = nombre;
    }

    public void agregarCiudad(Ciudad ciudad) {
        ciudades.add(ciudad);
    }

    public List<Ciudad> getCiudades() {
        return ciudades;
    }

    public String getNombre() {
        return nombre;
    }

    private List<Ciudad> getCiudadesControladas() {
        List<Ciudad> controladas = new ArrayList<>();
        for (Ciudad c : ciudades) {
            if (c.esControlada()) {
                controladas.add(c);
            }
        }
        return controladas;
    }

    @Override
    public boolean estaEnDeficit() {
        List<Ciudad> controladas = getCiudadesControladas();
        if (controladas.isEmpty()) {
            return false;
        }
        int enDeficit = 0;
        for (Ciudad c : controladas) {
            if (c.estaEnDeficit()) {
                enDeficit++;
            }
        }
        return enDeficit > controladas.size() / 2.0;
    }

    @Override
    public String toString() {
        return nombre;
    }
}
