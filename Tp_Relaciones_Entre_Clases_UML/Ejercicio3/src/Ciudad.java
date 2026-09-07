import java.util.ArrayList;
import java.util.List;

public class Ciudad implements Calculable {
    private String nombre;
    private int habitantes;
    private List<Impuesto> impuestos = new ArrayList<>();
    private List<Gasto> gastos = new ArrayList<>();

    public Ciudad(String nombre, int habitantes) {
        this.nombre = nombre;
        this.habitantes = habitantes;
    }

    public void agregarImpuesto(Impuesto impuesto) {
        impuestos.add(impuesto);
    }

    public void agregarGasto(Gasto gasto) {
        gastos.add(gasto);
    }

    public String getNombre() {
        return nombre;
    }

    public int getHabitantes() {
        return habitantes;
    }

    public boolean esControlada() {
        return habitantes > 100_000;
    }

    public double getTotalRecaudado() {
        double total = 0;
        for (Impuesto i : impuestos) {
            total += i.getMonto();
        }
        return total;
    }

    public double getTotalGastado() {
        double total = 0;
        for (Gasto g : gastos) {
            total += g.getMonto();
        }
        return total;
    }

    @Override
    public boolean estaEnDeficit() {
        return getTotalGastado() > getTotalRecaudado();
    }

    @Override
    public String toString() {
        return nombre;
    }
}
