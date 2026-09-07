import java.time.LocalDate;
import java.time.Period;

public class Esquiador implements ParticipanteEnPrueba {
    private String dni;
    private String nombre;
    private LocalDate fechaNacimiento;
    private Federacion federacion;

    public Esquiador(String dni, String nombre, LocalDate fechaNacimiento, Federacion federacion) {
        if (federacion == null) {
            throw new IllegalArgumentException("Todo esquiador debe pertenecer a una federacion.");
        }
        this.dni = dni;
        this.nombre = nombre;
        this.fechaNacimiento = fechaNacimiento;
        this.federacion = federacion;
    }

    public int getEdad() {
        return Period.between(fechaNacimiento, LocalDate.now()).getYears();
    }

    public String getNombre() { return nombre; }
    public Federacion getFederacion() { return federacion; }

    @Override
    public String getNombreParticipante() { return nombre; }

    @Override
    public String toString() { return nombre; }
}
