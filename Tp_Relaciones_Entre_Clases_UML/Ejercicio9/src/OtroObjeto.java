public class OtroObjeto extends ObjetoArte{
    private String tipoEspecifico;

    public OtroObjeto(int id, String titulo, String descripcion, Integer anioCreacion,
                      Artista artista, String paisOrigen, String culturaOrigen, String epocaOrigen,
                      Pertenencia pertenencia, String tipoEspecifico) {
        super(id, titulo, descripcion, anioCreacion, artista, paisOrigen, culturaOrigen, epocaOrigen, pertenencia);
        this.tipoEspecifico = tipoEspecifico;
    }

    @Override
    public void mostrarFichaTecnica() {
        System.out.println("[OTRO: " + tipoEspecifico + "] " + getTitulo());
        System.out.println("  Estado: " + getPertenencia().obtenerTipoPertenencia());
    }
}
