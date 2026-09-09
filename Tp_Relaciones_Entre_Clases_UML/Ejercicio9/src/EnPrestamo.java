import java.time.LocalDate;

public class EnPrestamo extends Pertenencia{
    private LocalDate fechaRecepcion;
    private LocalDate fechaDevolucion;
    private ColeccionExterna coleccionOrigen;

    //Getter
    public EnPrestamo(LocalDate fechaRecepcion, LocalDate fechaDevolucion, ColeccionExterna coleccionOrigen) {
        this.fechaRecepcion = fechaRecepcion;
        this.fechaDevolucion = fechaDevolucion;
        this.coleccionOrigen = coleccionOrigen;
    }

    //Getter
    public ColeccionExterna getColeccionOrigen() { return coleccionOrigen; }

    @Override
    public String obtenerTipoPertenencia() {
        return "En Préstamo de: " + coleccionOrigen.getNombre() + " (Hasta: " + fechaDevolucion + ")";
    }
}
