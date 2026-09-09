import java.time.LocalDate;

public class ColeccionPermanente extends Pertenencia{
    private LocalDate fechaAdquisicion;
    private double coste;
    private boolean enExposicion; // true = exposición, false = almacén

    //Constructor
    public ColeccionPermanente(LocalDate fechaAdquisicion, double coste, boolean enExposicion) {
        this.fechaAdquisicion = fechaAdquisicion;
        this.coste = coste;
        setEnExposicion(enExposicion);
    }

    //Getter
    public boolean isEnExposicion() { return enExposicion; }
    public void setEnExposicion(boolean enExposicion) { this.enExposicion = enExposicion; }

    @Override
    public String obtenerTipoPertenencia() {
        return "Colección Permanente (" + (enExposicion ? "En Exposición" : "En Almacén") + ")"; //Eso es un operador ternario para ahorrar logica en una sola lina de codigo
    }


}
