import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FiguraCompuesta extends Figura {
    private List<Figura> figuras;


    //Constructor
    public FiguraCompuesta(){
        this.figuras = new ArrayList<>();
    }




    //Metodo para agregar figuras
    public void agregarFigura(Figura f){
        this.figuras.add(f);
    }


    //Metodo para calcular el area total de la figura (aplica para la mayoria de figuras)
    @Override
    public double calcularArea() {
        double areaTotal = 0;
        for (Figura f : figuras){
            areaTotal += f.calcularArea();
        }
        return areaTotal;
    }
}
