package com.kodilla.testing.shape;

import java.util.ArrayList;

public class ShapeCollector {

    private ArrayList<Shape> figures = new ArrayList<Shape>();

    public void addFigure(Shape shape){
        figures.add(shape);
     }
    public boolean removeFigure(Shape shape){
        boolean result = false;
        if (figures.contains(shape)){
            figures.remove(shape);
            result = true;
        }
        return result;
    }
    public Shape getFigure(int n){
        Shape shape = null;
        shape = figures.get(n);
        return shape;
    }
    public String showFigures(){
        String abc = "figure: " + figures.get(0).getShapeName() + "; field: " + figures.get(0).getField()
        + "\n";
        for(int i=1; i < figures.size(); i++){

            abc += "figure: " + figures.get(i).getShapeName() + "; field: " + figures.get(i).getField()
            + "\n";
        }
        System.out.println(abc);
        return abc;
    }
    public int size(){
        return figures.size();
    }
}
