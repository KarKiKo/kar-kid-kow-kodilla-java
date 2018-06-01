package com.kodilla.patterns2.decorator.pizza;

import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class PizzaOrderTestSuite {

    @Test
    public void testBasicPizzaOrderGetCost() {
        //Given
        PizzaOrder theOrder = new BasicPizzaOrder();
        //When
        BigDecimal theCost = theOrder.getCost();
        //Then
        assertEquals(new BigDecimal(15), theCost);
    }

    @Test
    public void testBasicPizzaOrderGetOrderDescription() {
        //Given
        PizzaOrder theOrder = new BasicPizzaOrder();
        //When
        String description = theOrder.getOrderDescription();
        //Then
        assertEquals("Pizza with tomato sauce and cheese", description);
    }

    @Test
    public void testPizzaOrderTripleCheeseGetCost() {
        //Given
        PizzaOrder theOrder = new BasicPizzaOrder();
        theOrder = new CheeseDecorator(theOrder);
        theOrder = new CheeseDecorator(theOrder);
        //When
        BigDecimal theCost = theOrder.getCost();
        //Then
        assertEquals(new BigDecimal(21), theCost);
    }

    @Test
    public void testPizzaOrderTripleCheeseGetOrderDescription() {
        //Given
        PizzaOrder theOrder = new BasicPizzaOrder();
        theOrder = new CheeseDecorator(theOrder);
        theOrder = new CheeseDecorator(theOrder);
        //When
        String description = theOrder.getOrderDescription();
        //Then
        assertEquals("Pizza with tomato sauce and cheese + additional cheese + additional cheese", description);
    }

    @Test
    public void testPizzaOrderDoubleCheeseWithSalamiMushroomsAndOliveOilSetGetCost() {
        //Given
        PizzaOrder theOrder = new BasicPizzaOrder();
        theOrder = new CheeseDecorator(theOrder);
        theOrder = new AdditionalIngredientDecorator(theOrder);
        theOrder = new AdditionalIngredientDecorator(theOrder);
        theOrder = new OliveOilSetDecorator(theOrder);

        //When
        BigDecimal theCost = theOrder.getCost();
        //Then
        assertEquals(new BigDecimal(23), theCost);
    }

    @Test
    public void testPizzaOrderDoubleCheeseWithSalamiMushroomsAndOliveOilSetGetOrderDescription() {
        //Given
        PizzaOrder theOrder = new BasicPizzaOrder();
        theOrder = new CheeseDecorator(theOrder);
        theOrder = new AdditionalIngredientDecorator(theOrder);
        theOrder = new AdditionalIngredientDecorator(theOrder);
        theOrder = new OliveOilSetDecorator(theOrder);
        //When
        String description = theOrder.getOrderDescription();
        //Then
        assertEquals("Pizza with tomato sauce and cheese + additional cheese + additional ingredient + " +
                "additional ingredient + olive oil set", description);
    }
}
