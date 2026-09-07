public class Material {
    private String nombre;
    private int cantidad;


    //Constructor
    public Material(String nombre, int cantidad) {
        this.nombre = nombre;
        this.cantidad = cantidad;
    }


    //Getters
    public String getNombre() { return nombre; }
    public int getCantidad() { return cantidad; }
}
