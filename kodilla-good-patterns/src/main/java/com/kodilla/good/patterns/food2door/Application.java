package com.kodilla.good.patterns.food2door;

public class Application {
    public static void main(String[] args) {
        System.out.println("Order 1");
        OrderRequest orderRequest1 = new OrderRequest("GlutenFreeShop", "GlutenFreePasta", 5);

        OrderProcess orderProcess1 = new OrderProcess(new OrderService());

        orderProcess1.process(orderRequest1);

        System.out.println("Order2");
        OrderRequest orderRequest2 = new OrderRequest("ExtraFoodShop", "Olive oil", 1);

        OrderProcess orderProcess2 = new OrderProcess(new OrderService());

        orderProcess2.process(orderRequest2);

        System.out.println("Order3");
        OrderRequest orderRequest3 = new OrderRequest("HealthyShop", "Apple", 2);

        OrderProcess orderProcess3 = new OrderProcess(new OrderService());

        orderProcess3.process(orderRequest3);
    }
}

