import java.util.ArrayList;
import java.util.List;

public class Equipo implements ParticipanteEnPrueba {
    private String codigo;
    private String entrenador;
    private List<Esquiador> esquiadores = new ArrayList<>();

    public Equipo(String codigo, String entrenador) {
        this.codigo = codigo;
        this.entrenador = entrenador;
    }

    public void agregarEsquiador(Esquiador esquiador) { esquiadores.add(esquiador); }
    public int getCantidadEsquiadores() { return esquiadores.size(); }

    @Override
    public String getNombreParticipante() { return codigo; }

    @Override
    public String toString() { return codigo; }
}
