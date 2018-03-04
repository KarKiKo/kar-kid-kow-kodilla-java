package com.kodilla.good.patterns.challenges;

public class ProductOrderService {

    private InformationService informationService;
    private OrderService orderService;
    private OrderRepository orderRepository;

    public ProductOrderService(final InformationService informationService,
                           final OrderService orderService,
                           final OrderRepository orderRepository) {
        this.informationService = informationService;
        this.orderService = orderService;
        this.orderRepository = orderRepository;
    }

    public OrderDto process(final OrderRequest orderRequest) {
        boolean isOrdered = orderService.order(orderRequest.getUserLogin(), orderRequest.getProduct(),
                orderRequest.getQuantity());

        if(isOrdered) {
            informationService.inform(orderRequest.getUserLogin());
            orderRepository.createOrder(orderRequest.getUserLogin(), orderRequest.getProduct(), orderRequest.getQuantity());
            return new OrderDto(orderRequest.getUserLogin(), true);
        } else {
            return new OrderDto(orderRequest.getUserLogin(), false);
        }
    }
}
