import java.time.LocalDate;

public class ComisionCalculator {
    public double calcularComision(Representante representante, double porcentaje, LocalDate desde) {
        double comision = representante.getMontoVentasDesde(desde) * porcentaje;
        if (representante instanceof Lider) {
            Lider lider = (Lider) representante;
            comision += lider.getMontoVentasEquipoDesde(desde) * porcentaje;
        }
        return comision;
    }
}