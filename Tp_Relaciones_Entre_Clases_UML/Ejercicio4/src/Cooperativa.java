import java.util.ArrayList;
import java.util.List;

public class Cooperativa {
    private List<Cereal> cerealesDisponibles = new ArrayList<>();

    public void agregarCereal(Cereal cereal) { cerealesDisponibles.add(cereal); }

    public List<Cereal> aconsejarCerealesPara(Lote lote) {
        List<Cereal> aconsejados = new ArrayList<>();
        for (Cereal c : cerealesDisponibles) {
            if (lote.puedeSembrar(c)) aconsejados.add(c);
        }
        return aconsejados;
    }
}
