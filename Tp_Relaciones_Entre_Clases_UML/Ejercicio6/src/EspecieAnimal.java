import java.util.ArrayList;
import java.util.List;

public class EspecieAnimal extends Especie{
    private String periodoCelo;
    private TipoAlimentacion alimentacion;
    private List<Especie> dieta; // Cadena trófica: animales o vegetales que le sirven de alimento


    //Constructor
    public EspecieAnimal(String nombreCientifico, String nombreVulgar, String periodoCelo, TipoAlimentacion alimentacion) {
        super(nombreCientifico, nombreVulgar);
        this.periodoCelo = periodoCelo;
        this.alimentacion = alimentacion;
        this.dieta = new ArrayList<>();
    }

    //Metodo para agregar un alimento a la dieta del animal
    public void agregarAlimento(Especie alimento) {
        dieta.add(alimento);
    }

    @Override
    public String getDetalleBiologico() {
        return "Animal [" + alimentacion + ", Celo: " + periodoCelo + ", Presas/Alimento: " + dieta.size() + "]";
    }
}
