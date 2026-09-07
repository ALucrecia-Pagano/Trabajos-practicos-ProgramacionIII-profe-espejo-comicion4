import java.util.ArrayList;
import java.util.List;

public class Pais {
    private String nombre;
    private List<Provincia> provincias = new ArrayList<>();

    public Pais(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
    return nombre;
}

    public void agregarProvincia(Provincia provincia) {
        provincias.add(provincia);
    }

    public List<Ciudad> getCiudadesEnDeficit() {
        List<Ciudad> resultado = new ArrayList<>();
        for (Provincia p : provincias) {
            for (Ciudad c : p.getCiudades()) {
                if (c.esControlada() && c.estaEnDeficit()) {
                    resultado.add(c);
                }
            }
        }
        return resultado;
    }

    public List<Provincia> getProvinciasEnDeficit() {
        List<Provincia> resultado = new ArrayList<>();
        for (Provincia p : provincias) {
            if (p.estaEnDeficit()) {
                resultado.add(p);
            }
        }
        return resultado;
    }
}