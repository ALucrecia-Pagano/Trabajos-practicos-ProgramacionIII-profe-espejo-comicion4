public class Visitante {
    private String dni;
    private String nombre;
    private String direccion;
    private String profesion;

    public Visitante(String dni, String nombre, String direccion, String profesion) {
        this.dni = dni;
        this.nombre = nombre;
        this.direccion = direccion;
        this.profesion = profesion;
    }

    public String getDni() { return dni; }
    public String getNombre() { return nombre; }
}
