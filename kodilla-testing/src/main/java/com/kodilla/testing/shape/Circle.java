package com.kodilla.testing.shape;

public class Circle implements Shape {

    private double pi = 3.14;
    private double r;

    public Circle(double r) {
        this.r = r;
      }

    public String getShapeName() {
        return "circle";
    }

    public double getField() {
        return r*r*pi;
    }

    public String toString(){
        return "figure: " + getShapeName() + "; field: " + getField() + "\n";
    }
}
