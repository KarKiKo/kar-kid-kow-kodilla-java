package com.kodilla.good.patterns.challenges;

public class AgdRtvService implements OrderService {
    public boolean order(final String userLogin, final String product, final int quantity ) {
        System.out.println("Order for: " + userLogin + "\nProduct: " + product + "\nQuantity: " + quantity);
        return true;
    }
}
