import java.util.ArrayList;
import java.util.List;

public abstract class Cereal {
    private String nombre;
    private List<Mineral> mineralesRequeridos = new ArrayList<>();

    public Cereal(String nombre) {
        this.nombre = nombre;
    }

    public void agregarMineralRequerido(Mineral mineral) {
        mineralesRequeridos.add(mineral);
    }

    public List<Mineral> getMineralesRequeridos() { return mineralesRequeridos; }
    public String getNombre() { return nombre; }

    @Override
    public String toString() { return nombre; }
}
