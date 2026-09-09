import java.util.ArrayList;
import java.util.List;

public class Museo {
    private String nombre;
    private List<ObjetoArte> inventario; // Composición
    private List<Exposicion> exposiciones;


    public Museo(String nombre) {
        this.nombre = nombre;
        this.inventario = new ArrayList<>();
        this.exposiciones = new ArrayList<>();
    }

    public void agregarObjetoAlInventario(ObjetoArte obra) {
        inventario.add(obra);
    }

    public void registrarExposicion(Exposicion expo) {
        exposiciones.add(expo);
    }

    public void mostrarInventarioGeneral() {
        System.out.println("\n============ INVENTARIO GENERAL: " + nombre + " ============");
        for (ObjetoArte obra : inventario) {
            obra.mostrarFichaTecnica();
        }
    }
}
