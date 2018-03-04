package com.kodilla.good.patterns.challenges;

public class OrderRequestRetriever {

    public OrderRequest retrieve(){

        String userLogin = "Jan Kowalski";
        String product = "Telewizor";
        int quantity = 1;

        return new OrderRequest(userLogin, product, quantity);
    }
}
