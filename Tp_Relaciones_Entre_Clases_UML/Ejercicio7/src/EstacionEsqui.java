import java.util.ArrayList;
import java.util.List;

public class EstacionEsqui {
    private String codigo;
    private String nombre;
    private List<Pista> pistas = new ArrayList<>();

    public EstacionEsqui(String codigo, String nombre) {
        this.codigo = codigo;
        this.nombre = nombre;
    }

    public void agregarPista(Pista pista) { pistas.add(pista); }
    public String getCodigo() { return codigo; }
    public List<Pista> getPistas() { return pistas; }

    @Override
    public String toString() { return nombre; }
}