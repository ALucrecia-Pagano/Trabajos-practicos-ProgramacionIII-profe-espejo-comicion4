import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Lider extends Representante {
    private LocalDate fechaPromocion;
    private List<Vendedor> equipoDeVendedores = new ArrayList<>();

    public Lider(String nombre, String direccion, String telefono,
                 LocalDate fechaNacimiento, String cuitCuil, LocalDate fechaIncorporacion,
                 LocalDate fechaPromocion) {
        super(nombre, direccion, telefono, fechaNacimiento, cuitCuil, fechaIncorporacion);
        this.fechaPromocion = fechaPromocion;
    }

    public void agregarVendedor(Vendedor vendedor) { equipoDeVendedores.add(vendedor); }

    public double getMontoVentasEquipoDesde(LocalDate desde) {
        double total = 0;
        for (Vendedor v : equipoDeVendedores) {
            total += v.getMontoVentasDesde(desde);
        }
        return total;
    }
}