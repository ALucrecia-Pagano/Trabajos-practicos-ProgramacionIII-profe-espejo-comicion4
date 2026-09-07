import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public abstract class Representante {
    private String nombre;
    private String direccion;
    private String telefono;
    private LocalDate fechaNacimiento;
    private String cuitCuil;
    private LocalDate fechaIncorporacion;
    private List<Cliente> clientes = new ArrayList<>();
    private List<Ticket> tickets = new ArrayList<>();

    public Representante(String nombre, String direccion, String telefono,
                          LocalDate fechaNacimiento, String cuitCuil, LocalDate fechaIncorporacion) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.fechaNacimiento = fechaNacimiento;
        this.cuitCuil = cuitCuil;
        this.fechaIncorporacion = fechaIncorporacion;
    }

    public void agregarCliente(Cliente cliente) { clientes.add(cliente); }
    public void agregarTicket(Ticket ticket) { tickets.add(ticket); }
    public String getNombre() { return nombre; }

    public double getMontoVentasDesde(LocalDate desde) {
        double total = 0;
        for (Ticket t : tickets) {
            if (t.esVentaConcretada() && !t.getFecha().isBefore(desde)) {
                total += t.getPrecio();
            }
        }
        return total;
    }

    @Override
    public String toString() { return nombre; }
}