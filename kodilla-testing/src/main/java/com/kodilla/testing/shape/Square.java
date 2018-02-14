package com.kodilla.testing.shape;

public class Square implements Shape {

    private double sideLength;

    public Square(double sideLength) {
        this.sideLength = sideLength;
    }

    public String getShapeName() {
        return "square";
    }

    public double getField() {
        return sideLength*sideLength;
    }

    public String toString(){
        return "figure: " + getShapeName() + "; field: " + getField() + "\n";
    }
}
