package com.kodilla.good.patterns.food2door;

import java.util.HashMap;
import java.util.Map;

public final class HealthyShop extends Supplier {

    String name;
    private final Map<String, Integer> inventoryList = new HashMap<>();

    public HealthyShop() {
        this.name = "HealthyShop";
        inventoryList.put("Olive oil", 3);
        inventoryList.put("Fair trade coffee", 1);
        inventoryList.put("Hummus", 3);
        inventoryList.put("Coconut milk", 1);
    }

    public Map<String, Integer> getInventory() {
        return new HashMap<>(inventoryList);
    }

    @Override
    public String getName() {
        return name;
    }
}
