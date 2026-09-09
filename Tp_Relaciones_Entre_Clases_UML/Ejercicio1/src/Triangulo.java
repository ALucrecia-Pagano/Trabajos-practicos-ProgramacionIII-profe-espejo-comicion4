import java.util.List;

public class Triangulo extends Poligono{
    private double base;
    private double altura;


    public Triangulo(List<Lado> lados, double blase, double altura) {
        super(3, lados);
        this.base = blase;
        this.altura = altura;
    }



    @Override
    public double calcularArea() {
        return (base * altura) / 2;
    }



}
