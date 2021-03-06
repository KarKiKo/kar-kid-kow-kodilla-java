package com.kodilla.good.patterns.challenges;

public class OrderRequest {

    public String userLogin;
    public String product;
    public int quantity;

    public OrderRequest(String userLogin, String product, int quantity) {
        this.userLogin = userLogin;
        this.product = product;
        this.quantity = quantity;
    }

    public String getUserLogin() {
        return userLogin;
    }

    public String getProduct() {
        return product;
    }

    public int getQuantity() {
        return quantity;
    }
}
