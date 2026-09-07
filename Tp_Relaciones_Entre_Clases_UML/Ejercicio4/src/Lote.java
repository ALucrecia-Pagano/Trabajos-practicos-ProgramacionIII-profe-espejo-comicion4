import java.util.ArrayList;
import java.util.List;

public class Lote {
    private String identificador;
    private List<Mineral> minerales = new ArrayList<>();
    private List<Cereal> historialSiembra = new ArrayList<>();

    public Lote(String identificador) { this.identificador = identificador; }

    public void agregarMineral(Mineral mineral) { minerales.add(mineral); }

    public boolean esEspecial() {
        for (Mineral m : minerales) {
            if (m.getTipoInteres() == TipoInteres.PRIMARIO) return true;
        }
        return false;
    }

    public boolean satisfaceRequerimientos(Cereal cereal) {
        return minerales.containsAll(cereal.getMineralesRequeridos());
    }

    private boolean yaSembroPastura() {
        for (Cereal c : historialSiembra) {
            if (c instanceof Pastura) return true;
        }
        return false;
    }

    public boolean puedeSembrar(Cereal cereal) {
        if (!satisfaceRequerimientos(cereal)) return false;
        if (cereal instanceof Pastura) return !yaSembroPastura();
        return true;
    }

    public void registrarSiembra(Cereal cereal) {
        historialSiembra.add(cereal);
    }

    @Override
    public String toString() { return identificador; }
}
