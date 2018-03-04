package com.kodilla.good.patterns.food2door;

import java.util.List;
import java.util.stream.Collectors;

public class OrderService {
    public boolean order(final String supplier, final String product, final int quantity){
        SuppliersDirectory suppliersDirectory = new SuppliersDirectory();
        List<String> suppliersList = suppliersDirectory.getList().stream()
                .map(Supplier::getName)
                .collect(Collectors.toList());
        List<String> productList = suppliersDirectory.getList().stream()
                .filter(s->s.getName().equals(supplier))
                .flatMap(sup-> sup.getInventory().entrySet().stream())
                .map(entry -> entry. getKey())
                .collect(Collectors.toList());
        int quantityOfProduct = suppliersDirectory.getList().stream()
                .filter(s->s.getName().equals(supplier))
                .flatMap(sup-> sup.getInventory().entrySet().stream())
                .filter(entry->entry.getKey().equals(product))
                .map(e -> e.getValue())
                .reduce(0,(sum,current)-> sum = sum + current);

        if(suppliersList.contains(supplier)&&productList.contains(product)&&quantityOfProduct >= quantity) {
            return true;
        } else {
            return false;
        }
    }
}
