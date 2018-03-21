package com.kodilla.patterns.builder.bigmac;

import java.util.ArrayList;
import java.util.List;

public class AvailableProducts {

    public List<String> getIngredients() {
        ArrayList<String> availableIngredients = new ArrayList<>();
        availableIngredients.add("onion");
        availableIngredients.add("cheese");
        availableIngredients.add("bacon");
        availableIngredients.add("salad");
        availableIngredients.add("cucumber");
        availableIngredients.add("chili pepper");
        availableIngredients.add("mushrooms");
        availableIngredients.add("prawns");
        return availableIngredients;
    }

    public List<String> getRolls() {
        ArrayList<String> availableRolls = new ArrayList<>();
        availableRolls.add("normal");
        availableRolls.add("sesame");
        return availableRolls;
    }

    public List<String> getSauces() {
        ArrayList<String> availableSauces = new ArrayList<>();
        availableSauces.add("standard");
        availableSauces.add("1000 islands");
        availableSauces.add("barbecue");
        return availableSauces;
    }
}

