import java.util.Collections;
import java.util.List;

public abstract class Poligono extends Figura {
    private int numeroLados;
    private List<Lado> lados;

    //Constructor
    public Poligono(int numeroLados, List<Lado> lados) {
        this.numeroLados = numeroLados;
        this.lados = lados;
    }


    //Getters
    public int getNumeroLados() {
        return numeroLados;
    }

    public List<Lado> getLados() {
        return Collections.unmodifiableList(lados);
    }


}


