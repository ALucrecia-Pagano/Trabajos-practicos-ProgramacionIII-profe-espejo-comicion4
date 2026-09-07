public abstract class ObjetoArte {
    private int id;
    private String titulo;
    private String descripcion;
    private Integer anioCreacion; // Wrapper Integer para permitir null si se desconoce
    private Artista artista;       // Puede ser null si es anónimo
    private String paisOrigen;
    private String culturaOrigen;
    private String epocaOrigen;
    private Pertenencia pertenencia; // Composición


    //Constructor
    public ObjetoArte(int id, String titulo, String descripcion, Integer anioCreacion,
                      Artista artista, String paisOrigen, String culturaOrigen,
                      String epocaOrigen, Pertenencia pertenencia) {
        this.id = id;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.anioCreacion = anioCreacion;
        this.artista = artista;
        this.paisOrigen = paisOrigen;
        this.culturaOrigen = culturaOrigen;
        this.epocaOrigen = epocaOrigen;
        setPertenencia(pertenencia);
    }

    //Getter

    public int getId() { return id; }
    public String getTitulo() { return titulo; }
    public Artista getArtista() { return artista; }
    public Pertenencia getPertenencia() { return pertenencia; }

    //Setter
    public void setPertenencia(Pertenencia pertenencia) { this.pertenencia = pertenencia; }


    //Metodo que aparece en Pintura
    public abstract void mostrarFichaTecnica();

}
