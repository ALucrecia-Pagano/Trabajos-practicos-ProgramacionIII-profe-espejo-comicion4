import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Celador extends Cargo{
    private Entrada entradaAsignada;
    private List<RegistroVisita> visitasRegistradas;

    public Celador(Entrada entradaAsignada) {
        this.entradaAsignada = entradaAsignada;
        this.visitasRegistradas = new ArrayList<>();
    }

    public void registrarVisita(Visitante visitante, LocalDate fecha) {
        visitasRegistradas.add(new RegistroVisita(fecha, visitante));
    }

    @Override
    public String getDescripcionCargo() {
        return "Celador en Entrada Nº " + entradaAsignada.getNumero() + " (" + visitasRegistradas.size() + " visitas registradas)";
    }

}
