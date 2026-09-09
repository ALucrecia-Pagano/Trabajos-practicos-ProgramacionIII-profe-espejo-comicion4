import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Punto p1 = new Punto(0, 0);
        Punto p2 = new Punto(4, 0);
        Punto p3 = new Punto(2, 3);


        Lado l1 = new Lado(p1, p2);
        Lado l2 = new Lado(p2, p3);
        Lado l3 = new Lado(p3, p1);

        List<Lado> ladosTriangulo = new ArrayList<>();
        ladosTriangulo.add(l1);
        ladosTriangulo.add(l2);
        ladosTriangulo.add(l3);


        Figura triangulo = new Triangulo(ladosTriangulo, 4.0, 3.0);
        Figura circulo = new Circulo(5.0);
        Figura elipse = new Elipse(6.0, 2.0);
        Figura rectangulo = new Rectangulo(new ArrayList<>(), 10.0, 5.0);
        Figura cuadrado = new Cuadrado(new ArrayList<>(), 4.0);


        System.out.println("Área Triángulo: " + triangulo.calcularArea());
        System.out.println("Área Círculo: " + circulo.calcularArea());
        System.out.println("Área Elipse: " + elipse.calcularArea());
        System.out.println("Área Rectángulo: " + rectangulo.calcularArea());
        System.out.println("Área Cuadrado: " + cuadrado.calcularArea());

        System.out.println("------------------------------------------");


        FiguraCompuesta dibujo = new FiguraCompuesta();
        dibujo.agregarFigura(triangulo);
        dibujo.agregarFigura(circulo);
        dibujo.agregarFigura(cuadrado);


        System.out.println("Área Total de la Figura Compuesta: " + dibujo.calcularArea());
    }
}
