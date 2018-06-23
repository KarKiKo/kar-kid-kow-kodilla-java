package com.kodilla.good.patterns.challenges;

public class AgdRtvRepository implements OrderRepository {

    public void createOrder(String userLogin, String product, int quantity){
        System.out.println("Order data are recorded in repository. Order details: " + "User login: " + userLogin +
                " " + "Product: " + product + " " + "Quantity: " + quantity);
    }


}
