public class EspecieVegetal extends Especie{
    private boolean tieneFloracion;
    private String periodoFloracion;


    //Constructor
    public EspecieVegetal(String nombreCientifico, String nombreVulgar, boolean tieneFloracion, String periodoFloracion) {
        super(nombreCientifico, nombreVulgar);
        this.tieneFloracion = tieneFloracion;
        this.periodoFloracion = periodoFloracion;
    }

    @Override
    public String getDetalleBiologico() {
        return "Vegetal [Floración: " + (tieneFloracion ? "Sí (" + periodoFloracion + ")" : "No") + "]";
    }
}
