package com.kodilla.testing.shape;

public class Triangle implements Shape {

    private double base;
    private double height;

    public Triangle(double base, double height) {
        this.base = base;
        this.height = height;
    }

    public String getShapeName(){
        return "triangle";
    }

    public double getField(){
        return 0.5*base*height;
    }
    public String toString(){
        return "figure: " + getShapeName() + "; field: " + getField() + "\n";
    }
}
