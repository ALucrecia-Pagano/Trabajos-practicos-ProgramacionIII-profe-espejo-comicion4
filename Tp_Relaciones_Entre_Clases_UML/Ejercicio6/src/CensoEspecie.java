public class CensoEspecie {
    private Especie especie;
    private int numeroIndividuos;

    //Constructor
    public CensoEspecie(Especie especie, int numeroIndividuos) {
        this.especie = especie;
        this.numeroIndividuos = numeroIndividuos;
    }

    public Especie getEspecie() { return especie; }
    public int getNumeroIndividuos() { return numeroIndividuos; }
}
