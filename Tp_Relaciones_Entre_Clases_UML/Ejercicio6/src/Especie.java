public abstract class Especie {
    private String nombreCientifico;
    private String nombreVulgar;


    //Constructor
    public Especie(String nombreCientifico, String nombreVulgar) {
        this.nombreCientifico = nombreCientifico;
        this.nombreVulgar = nombreVulgar;
    }

    public String getNombreCientifico() { return nombreCientifico; }
    public String getNombreVulgar() { return nombreVulgar; }
    public abstract String getDetalleBiologico();
}


