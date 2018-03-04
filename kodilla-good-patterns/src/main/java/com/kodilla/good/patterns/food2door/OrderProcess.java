package com.kodilla.good.patterns.food2door;

public class OrderProcess {

    private OrderService orderService;

    public OrderProcess(final OrderService orderService) {
        this.orderService = orderService;
    }

    public void process(final OrderRequest orderRequest) {
        boolean isOrdered = orderService.order(orderRequest.getSupplier(), orderRequest.getProduct(),
                orderRequest.getQuantity());

        if (isOrdered) {
            System.out.println("Zamowienie zostanie zrealizowane");
        } else {
            System.out.println("Brak dostepnosci towaru");
        }
    }
}
