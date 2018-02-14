package com.kodilla.testing.shape;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

public class ShapeCollectorTestSuite {

    @Test
    public void testAddFigure(){
        //Given
            ShapeCollector shapeCollector = new ShapeCollector();
        //When
            shapeCollector.addFigure(new Circle(10));
            shapeCollector.addFigure(new Square(5));
            shapeCollector.addFigure(new Triangle(4,5));
        //Then
             Assert.assertEquals(3, shapeCollector.size());
    }

    @Test

    public void testRemoveFigure(){
        //Given
            ShapeCollector shapeCollector = new ShapeCollector();
            Circle circle1 = new Circle(5);
            shapeCollector.addFigure(circle1);
        //When
            shapeCollector.removeFigure(circle1);
        //Then
             Assert.assertEquals(0, shapeCollector.size());
    }

    @Test

    public void testGetFigure(){
            //Given
            ShapeCollector shapeCollector = new ShapeCollector();
            Circle circle1 = new Circle(5);
            shapeCollector.addFigure(circle1);
            //When
            Shape retrievedShape;
            retrievedShape = shapeCollector.getFigure(0);
            //Then
            Assert.assertEquals(circle1, retrievedShape);
    }

    @Test

    public void testShowFigures(){
            //Given
            ShapeCollector shapeCollector = new ShapeCollector();
            Circle circle1 = new Circle(2);
            shapeCollector.addFigure(circle1);
            Square square1 = new Square(5);
            shapeCollector.addFigure(square1);
            Triangle triangle1 = new Triangle(12,3);
            shapeCollector.addFigure(triangle1);
            //When
            String showFigures = shapeCollector.showFigures();
            //Then
            Assert.assertEquals(circle1.toString() + square1.toString() + triangle1.toString(), showFigures);
    }


}
