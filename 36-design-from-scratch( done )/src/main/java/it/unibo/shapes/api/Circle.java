package it.unibo.shapes.api;

public class Circle implements Shape{

    private double radius;
    
    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    @Override
    public double getPerimeter() {
        return (2 * Math.PI * getRadius());
    }

    @Override
    public double getArea() {
        return (Math.PI * Math.PI * getRadius());
    }

}