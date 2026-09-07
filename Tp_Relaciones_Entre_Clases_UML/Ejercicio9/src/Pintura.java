public class Pintura extends ObjetoArte{
    private String tipoPintura; // Óleo, acuarela, etc.
    private String soporte;     // Lienzo, papel, etc.
    private String estilo;      // Impresionista, abstracto, etc.

        //Constructor
    public Pintura(int id, String titulo, String descripcion, Integer anioCreacion,
                   Artista artista, String paisOrigen, String culturaOrigen, String epocaOrigen,
                   Pertenencia pertenencia, String tipoPintura, String soporte, String estilo) {
        super(id, titulo, descripcion, anioCreacion, artista, paisOrigen, culturaOrigen, epocaOrigen, pertenencia);
        this.tipoPintura = tipoPintura;
        this.soporte = soporte;
        this.estilo = estilo;
    }

    @Override
    public void mostrarFichaTecnica() {
        System.out.println("[PINTURA] " + getTitulo() + " | Artista: " + (getArtista() != null ? getArtista().getNombre() : "Anónimo"));
        System.out.println("  Técnica: " + tipoPintura + " sobre " + soporte + " | Estilo: " + estilo);
        System.out.println("  Estado: " + getPertenencia().obtenerTipoPertenencia());
    }
}
