import java.time.LocalDate;

public class Vendedor extends Representante {
    public Vendedor(String nombre, String direccion, String telefono,
                     LocalDate fechaNacimiento, String cuitCuil, LocalDate fechaIncorporacion) {
        super(nombre, direccion, telefono, fechaNacimiento, cuitCuil, fechaIncorporacion);
    }
}
