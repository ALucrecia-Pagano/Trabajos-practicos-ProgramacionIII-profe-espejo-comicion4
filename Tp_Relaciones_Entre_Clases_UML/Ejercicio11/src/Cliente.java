import java.time.LocalDate;

public class Cliente {
    private String nombre;
    private String direccion;
    private String telefono;
    private LocalDate fechaNacimiento;
    private LocalDate fechaIngreso;

    public Cliente(String nombre, String direccion, String telefono,
                    LocalDate fechaNacimiento, LocalDate fechaIngreso) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.fechaNacimiento = fechaNacimiento;
        this.fechaIngreso = fechaIngreso;
    }

    public String getNombre() { return nombre; }

    @Override
    public String toString() { return nombre; }
}
