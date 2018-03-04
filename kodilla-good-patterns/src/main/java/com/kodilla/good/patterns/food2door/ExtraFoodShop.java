package com.kodilla.good.patterns.food2door;

import java.util.HashMap;
import java.util.Map;

public final class ExtraFoodShop extends Supplier {

    String name;
    private final Map<String, Integer> inventoryList = new HashMap<>();

    public ExtraFoodShop() {
        this.name = "ExtraFoodShop";
        inventoryList.put("Olive oil", 2);
        inventoryList.put("Fair trade coffee", 4);
        inventoryList.put("Hummus", 1);
        inventoryList.put("Coconut milk", 10);
    }

    public Map<String, Integer> getInventory() {
        return new HashMap<>(inventoryList);
    }

    @Override
    public String getName() {
        return name;
    }
}
