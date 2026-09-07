import java.util.List;

public class Cuadrado extends Rectangulo{
    //El fokin cuadradp es un rectangulo con la base y altura iguales
    public Cuadrado(List<Lado> lados, double lado) {
        super(lados, lado, lado);
    }
}
