package it.unibo.shapes.test;
import it.unibo.shapes.impl.Square;
public class WorkWithShapes {
    public static void main(String[] args) {
        Square square = new Square(10, 15);

        System.out.println("il perimetro del quadrato è : " + square.getPerimeter());
        System.out.println("la area del quadrato è : " + square.getArea());

    }
}
