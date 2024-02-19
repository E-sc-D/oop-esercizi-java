package it.unibo.shapes.impl;
import it.unibo.shapes.api.Polygon;

public class Square implements Polygon{

    private static final int EDGES_NUMBER = 4;
    private double face1;
    private double face2;

    public Square( double face1,double face2){
        this.face1 = face1;
        this.face2 = face2;
    }

    public double getFace1() {
        return face1;
    }

    public void setFace1(double face1) {
        this.face1 = face1;
    }

    public double getFace2() {
        return face2;
    }

    public void setFace2(double face2) {
        this.face2 = face2;
    }


    @Override
    public double getPerimeter() {
        return (face1*2 + face2*2);
    }

    @Override
    public double getArea() {
        return ( face1 * face2 );
    }

    @Override
    public int getEdgeCount() {
        return EDGES_NUMBER;
    }

}