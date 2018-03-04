package com.kodilla.good.patterns.challenges;

public class ProductOrderServiceRunner {

    public static void main(String[] args){
        OrderRequestRetriever orderRequestRetriever = new OrderRequestRetriever();
        OrderRequest orderRequest = orderRequestRetriever.retrieve();

        ProductOrderService productOrderService = new ProductOrderService(
                new SmsService(), new AgdRtvService(), new AgdRtvRepository()
        );
        productOrderService.process(orderRequest);
    }
}
