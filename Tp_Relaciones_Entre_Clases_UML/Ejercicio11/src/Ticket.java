import java.time.LocalDate;

public class Ticket {
    private LocalDate fecha;
    private Producto producto;
    private double precio;
    private Representante representante;
    private Cliente cliente;

    public Ticket(LocalDate fecha, Producto producto, double precio, Representante representante) {
        this.fecha = fecha;
        this.producto = producto;
        this.precio = precio;
        this.representante = representante;
    }

    public LocalDate getFecha() { return fecha; }
    public double getPrecio() { return precio; }

    public void registrarVentaFinal(Cliente cliente) { this.cliente = cliente; }
    public boolean esVentaConcretada() { return cliente != null; }
}
