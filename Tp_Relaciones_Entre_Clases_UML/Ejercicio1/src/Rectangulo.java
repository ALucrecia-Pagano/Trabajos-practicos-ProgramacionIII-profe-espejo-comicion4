import java.util.List;

public class Rectangulo extends Cuadrilatero {
    private double base;
    private double altura;


    //Constructor
    public Rectangulo(List<Lado> lados, double base, double altura) {
        super(lados);
        this.base = base;
        this.altura = altura;
    }

    @Override
    public  double calcularArea(){
        return base*altura;
    }



}
