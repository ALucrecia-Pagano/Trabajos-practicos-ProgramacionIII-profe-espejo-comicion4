import java.util.ArrayList;
import java.util.List;

public class Area {

    private String nombre;
    private double km2;
    private List<CensoEspecie> censos;


    //Constructor
    public Area(String nombre, double km2) {
        this.nombre = nombre;
        this.km2 = km2;
        this.censos = new ArrayList<>();
    }

    public void registrarCenso(Especie especie, int individuos) {
        censos.add(new CensoEspecie(especie, individuos));
    }

    public String getNombre() { return nombre; }
    public double getKm2() { return km2; }
    public List<CensoEspecie> getCensos() { return censos; }
}
