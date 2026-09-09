public class Pista {
    private EstacionEsqui estacion;
    private int numeroCorrelativo;
    private double longitudKm;
    private String dificultad;

    public Pista(EstacionEsqui estacion, int numeroCorrelativo, double longitudKm, String dificultad) {
        this.estacion = estacion;
        this.numeroCorrelativo = numeroCorrelativo;
        this.longitudKm = longitudKm;
        this.dificultad = dificultad;
    }

    public String getCodigo() { return estacion.getCodigo() + "-" + numeroCorrelativo; }
    public EstacionEsqui getEstacion() { return estacion; }
    public double getLongitudKm() { return longitudKm; }

    @Override
    public String toString() { return getCodigo(); }
}