package com.kodilla.testing;

import com.kodilla.testing.calculator.Calculator;
import com.kodilla.testing.shape.Circle;
import com.kodilla.testing.shape.ShapeCollector;
import com.kodilla.testing.shape.Square;
import com.kodilla.testing.shape.Triangle;
import com.kodilla.testing.user.SimpleUser;

public class TestingMain {
    public static void main (String[] args){
        ShapeCollector test = new ShapeCollector();
        Circle circle1 = new Circle(5);
        Triangle triangle1 = new Triangle(4, 5);
        Square square1 = new Square(30);
        test.addFigure(circle1);
        test.removeFigure(circle1);
        test.addFigure(triangle1);
        test.addFigure(square1);
        test.addFigure(circle1);
        test.showFigures();

    }
}
