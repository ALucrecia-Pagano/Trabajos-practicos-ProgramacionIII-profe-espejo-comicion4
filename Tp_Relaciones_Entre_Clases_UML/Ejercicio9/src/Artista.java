import java.time.LocalDate;

public class Artista {
    private String nombre;
    private LocalDate fechaNacimiento;
    private LocalDate fechaDeFuncion; // Puede ser null si está vivo - Y sino, ya saben por qué fue XD
    private String paisOrigen;
    private String epoca;
    private String estiloPrincipal;
    private String descripcion;

    //Constructor

    public Artista(String nombre, LocalDate fechaNacimiento, LocalDate fechaDeFuncion,
                   String paisOrigen, String epoca, String estiloPrincipal, String descripcion) {
        this.nombre = nombre;
        this.fechaNacimiento = fechaNacimiento;
        this.fechaDeFuncion = fechaDeFuncion;
        this.paisOrigen = paisOrigen;
        this.epoca = epoca;
        this.estiloPrincipal = estiloPrincipal;
        this.descripcion = descripcion;
    }

    //Getter

    public String getNombre() {
        return nombre;
    }


}
