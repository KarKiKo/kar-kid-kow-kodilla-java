package com.kodilla.good.patterns.food2door;

import java.util.List;
import java.util.Map;

abstract class Supplier {

    public String name;
    public Map<String, Integer> inventory;

     public String getName() {
        return name;
    }

    public Map<String, Integer> getInventory() {
        return inventory;
    }
}
