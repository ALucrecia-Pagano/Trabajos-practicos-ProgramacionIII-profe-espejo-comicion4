import java.util.ArrayList;
import java.util.List;

public class SedeOlimpica {
    private String nombre;
    private double presupuesto;
    private List<ComplejoDeportivo> complejos;


    //Constructor
    public SedeOlimpica(String nombre, double presupuesto) {
        this.nombre = nombre;
        this.presupuesto = presupuesto;
        this.complejos = new ArrayList<>();
    }


    //Getters
    public int getNumeroComplejos() {
        return complejos.size();
    }




    //Metodo para agregar un complejo deportivo
    public void agregarComplejo(ComplejoDeportivo complejo) {
        complejos.add(complejo);
    }



    public void mostrarResumenSede() {
        System.out.println("=================================================");
        System.out.println("SEDE OLÍMPICA: " + nombre + " | Presupuesto: $" + presupuesto);
        System.out.println("Total Complejos: " + getNumeroComplejos());
        for (ComplejoDeportivo c : complejos) {
            c.mostrarFicha();
        }
        System.out.println("=================================================");
    }
}
