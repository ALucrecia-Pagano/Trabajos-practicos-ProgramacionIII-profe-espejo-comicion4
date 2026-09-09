public class Mineral {
    private String nombre;
    private TipoInteres tipoInteres;

    public Mineral(String nombre, TipoInteres tipoInteres) {
        this.nombre = nombre;
        this.tipoInteres = tipoInteres;
    }

    public String getNombre() { return nombre; }
    public TipoInteres getTipoInteres() { return tipoInteres; }

    @Override
    public String toString() { return nombre; }
}
