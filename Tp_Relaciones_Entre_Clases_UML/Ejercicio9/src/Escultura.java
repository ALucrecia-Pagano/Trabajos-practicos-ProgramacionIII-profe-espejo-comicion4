public class Escultura extends ObjetoArte{
    private String material; // Mármol, bronce, etc.
    private double altura;
    private double peso;
    private String estilo;
    //Constructor
    public Escultura(int id, String titulo, String descripcion, Integer anioCreacion,
                     Artista artista, String paisOrigen, String culturaOrigen, String epocaOrigen,
                     Pertenencia pertenencia, String material, double altura, double peso, String estilo) {
        super(id, titulo, descripcion, anioCreacion, artista, paisOrigen, culturaOrigen, epocaOrigen, pertenencia);
        this.material = material;
        this.altura = altura;
        this.peso = peso;
        this.estilo = estilo;
    }




    @Override
    public void mostrarFichaTecnica() {
        System.out.println("[ESCULTURA] " + getTitulo() + " | Artista: " + (getArtista() != null ? getArtista().getNombre() : "Anónimo")); //Operador ternario para mostarar la informacion
        System.out.println("  Material: " + material + " | Medidas: " + altura + "m, " + peso + "kg | Estilo: " + estilo);
        System.out.println("  Estado: " + getPertenencia().obtenerTipoPertenencia());
    }
}
