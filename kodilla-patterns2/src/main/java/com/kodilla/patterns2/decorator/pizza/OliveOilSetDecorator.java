package com.kodilla.patterns2.decorator.pizza;

import java.math.BigDecimal;

public class OliveOilSetDecorator extends AbstractPizzaOrderDecorator {

    public OliveOilSetDecorator(PizzaOrder pizzaOrder) {
        super(pizzaOrder);
    }

    @Override
    public BigDecimal getCost(){
        return super.getCost().add(new BigDecimal(1));
    }

    @Override
    public String getOrderDescription(){
        return super.getOrderDescription() + " + olive oil set";
    }
}
