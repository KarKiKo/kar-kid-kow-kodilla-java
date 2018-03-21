package com.kodilla.patterns.builder.bigmac;

import java.util.ArrayList;
import java.util.List;

public final class Bigmac {

    private final String roll;
    private final int burgers;
    private final String sauce;
    private final List<String> ingredients;

    public static class BigMacBuilder{
        private String roll;
        private int burgers;
        private String sauce;
        private List<String> ingredients = new ArrayList<>();
        private AvailableProducts availableProducts = new AvailableProducts();

        public BigMacBuilder roll(String roll){
            if (availableProducts.getRolls().contains(roll)) {
                this.roll = roll;
                return this;
            } else {
                throw new IllegalStateException("There is no such roll");
            }
        }

        public BigMacBuilder burgers(int burgers){
            this.burgers = burgers;
            return this;
        }

        public BigMacBuilder sauce(String sauce){
            if (availableProducts.getSauces().contains(sauce)) {
                this.sauce = sauce;
                return this;
            } else {
                throw new IllegalStateException("There is no such sauce");
            }
        }

        public BigMacBuilder ingredients (String ingredient){
            if (availableProducts.getIngredients().contains(ingredient)) {
                this.ingredients.add(ingredient);
                return this;
            } else {
                throw new IllegalStateException("There is no such ingredient");
            }
        }

        public Bigmac build(){
            return new Bigmac(roll, burgers, sauce, ingredients);
        }
    }

    private Bigmac(final String roll, final int burgers, final String sauce, List<String> ingredients){
        this.roll = roll;
        this.burgers = burgers;
        this.sauce = sauce;
        this.ingredients = new ArrayList<>(ingredients);
    }

    public List<String> getIngredients() {
        return ingredients;
    }

    @Override
    public String toString() {
        return "Bigmac{" +
                "roll='" + roll + '\'' +
                ", burgers=" + burgers +
                ", sauce='" + sauce + '\'' +
                ", ingredients=" + ingredients +
                '}';
    }
}
