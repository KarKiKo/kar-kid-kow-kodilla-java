package com.kodilla.good.patterns.food2door;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class GlutenFreeShop extends Supplier{

    String name;
    private final Map<String, Integer> inventoryList = new HashMap<>();

    public GlutenFreeShop() {
        this.name = "GlutenFreeShop";
        inventoryList.put("GlutenFreePasta", 5);
        inventoryList.put("GlutenFreeBread", 3);
        inventoryList.put("GlutenFreeFlour", 1);
    }

    public Map<String, Integer> getInventory() {
        return new HashMap<>(inventoryList);
    }

    @Override
    public String getName() {
        return name;
    }
}
