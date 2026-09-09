public class Lado {
    private Punto inicio;
    private Punto fin;



    //Constructor

    public Lado(Punto inicio, Punto fin) {
        this.inicio = inicio;
        this.fin = fin;
    }


    //Getter
    public Punto getInicio() {
        return inicio;
    }

    public Punto getFin() {
        return fin;
    }


}
