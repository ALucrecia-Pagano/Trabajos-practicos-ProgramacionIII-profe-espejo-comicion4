public class Elipse extends Figura{

    private double radioMayor;
    private double radioMenor;



    //Constructor


    public Elipse(double radioMayor, double radioMenor) {
        this.radioMayor = radioMayor;
        this.radioMenor = radioMenor;
    }



    //Getter


    public double getRadioMayor() {
        return radioMayor;
    }
    public double getRadioMenor() {
        return radioMenor;
    }



    @Override
    public double calcularArea() {
        return Math.PI * radioMayor * radioMenor;
    }
}
