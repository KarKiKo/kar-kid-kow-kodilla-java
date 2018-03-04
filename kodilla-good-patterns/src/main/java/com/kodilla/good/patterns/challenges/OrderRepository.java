package com.kodilla.good.patterns.challenges;

public interface OrderRepository {

    void createOrder(String userLogin, String product, int quantity);
}
