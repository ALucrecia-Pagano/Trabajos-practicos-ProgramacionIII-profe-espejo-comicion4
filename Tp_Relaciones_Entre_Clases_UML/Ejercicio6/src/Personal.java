import java.util.ArrayList;
import java.util.List;

public class Personal {
    private String dni;
    private String nombre;
    private String direccion;
    private String telefono;
    private double sueldo;
    private String numeroSeguridadSocial;
    private List<Cargo> cargos; // Composición: permite desempeñar múltiples roles simultáneamente

    public Personal(String dni, String nombre, String direccion, String telefono, double sueldo, String numeroSeguridadSocial) {
        this.dni = dni;
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.sueldo = sueldo;
        this.numeroSeguridadSocial = numeroSeguridadSocial;
        this.cargos = new ArrayList<>();
    }

    public void asignarCargo(Cargo cargo) {
        cargos.add(cargo);
    }

    public void mostrarPerfil() {
        System.out.println("Empleado: " + nombre + " (DNI: " + dni + ") - Sueldo: $" + sueldo);
        System.out.println("  Cargos asignados:");
        for (Cargo c : cargos) {
            System.out.println("    - " + c.getDescripcionCargo());
        }
    }
}
