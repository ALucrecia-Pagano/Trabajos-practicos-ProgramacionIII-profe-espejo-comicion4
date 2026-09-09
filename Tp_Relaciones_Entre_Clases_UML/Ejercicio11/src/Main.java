import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Producto crema = new Producto("Crema Hidratante", 1500);

        Lider lider = new Lider("Maria Lopez", "Calle 1", "111", LocalDate.of(1985, 1, 1),
                "20-11111111-1", LocalDate.of(2020, 1, 1), LocalDate.of(2021, 6, 1));

        Vendedor vendedor1 = new Vendedor("Pedro Ruiz", "Calle 2", "222", LocalDate.of(1990, 2, 2),
                "20-22222222-2", LocalDate.of(2022, 1, 1));
        lider.agregarVendedor(vendedor1);

        ReunionGeneral reunion = new ReunionGeneral(LocalDate.of(2026, 7, 1), LocalDate.of(2026, 8, 1));
        Cliente clienteA = new Cliente("Sofia Diaz", "Calle 3", "333",
                LocalDate.of(1995, 5, 5), LocalDate.of(2023, 1, 1));

        Ticket t1 = new Ticket(LocalDate.of(2026, 7, 10), crema, crema.getPrecioVentaPublico(), lider);
        t1.registrarVentaFinal(clienteA);
        lider.agregarTicket(t1);

        Ticket t2 = new Ticket(LocalDate.of(2026, 7, 15), crema, crema.getPrecioVentaPublico(), vendedor1);
        t2.registrarVentaFinal(clienteA);
        vendedor1.agregarTicket(t2);

        ComisionCalculator calc = new ComisionCalculator();
        double porcentaje = 0.10;

        System.out.println("Comision vendedor: " + calc.calcularComision(vendedor1, porcentaje, reunion.getFechaUltimaReunion()));
        System.out.println("Comision lider: " + calc.calcularComision(lider, porcentaje, reunion.getFechaUltimaReunion()));
    }
}