import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Prueba {
    private String nombre;
    private TipoPrueba tipo;
    private boolean esPorEquipos;
    private EstacionEsqui estacion;
    private List<LocalDate> fechas = new ArrayList<>();
    private List<Inscripcion> inscripciones = new ArrayList<>();
    private Inscripcion vencedor;
    private double tiempoVencedor;

    public Prueba(String nombre, TipoPrueba tipo, boolean esPorEquipos, EstacionEsqui estacion) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.esPorEquipos = esPorEquipos;
        this.estacion = estacion;
    }

    public String getNombre() { return nombre; }

    public void agregarFecha(LocalDate fecha) { fechas.add(fecha); }

    public Inscripcion inscribir(ParticipanteEnPrueba participante, int dorsal) {
        boolean esEquipo = participante instanceof Equipo;
        if (esEquipo != esPorEquipos) {
            throw new IllegalArgumentException(
                "Esta prueba es " + (esPorEquipos ? "por equipos" : "individual") + ".");
        }
        Inscripcion inscripcion = new Inscripcion(this, participante, dorsal);
        inscripciones.add(inscripcion);
        return inscripcion;
    }

    public void registrarResultado(Inscripcion inscripcion, double tiempo, int posicion) {
        if (vencedor == null || tiempo < tiempoVencedor) {
            vencedor = inscripcion;
            tiempoVencedor = tiempo;
        }
    }

    public Inscripcion getVencedor() { return vencedor; }
    public double getTiempoVencedor() { return tiempoVencedor; }

    @Override
    public String toString() { return nombre; }
}
