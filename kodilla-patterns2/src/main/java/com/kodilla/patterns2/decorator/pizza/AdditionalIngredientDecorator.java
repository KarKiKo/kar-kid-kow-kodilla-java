package com.kodilla.patterns2.decorator.pizza;

import java.math.BigDecimal;

public class AdditionalIngredientDecorator extends AbstractPizzaOrderDecorator {

    public AdditionalIngredientDecorator (PizzaOrder pizzaOrder) {
        super(pizzaOrder);
    }

    @Override
    public BigDecimal getCost(){
        return super.getCost().add(new BigDecimal(2));
    }

    @Override
    public String getOrderDescription(){
        return super.getOrderDescription() + " + additional ingredient";
    }
}
