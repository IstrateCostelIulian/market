package org.internship.market.controller;

import org.internship.market.services.OrdersServices;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrdersController {

    private final OrdersServices ordersServices;

    public OrdersController(OrdersServices ordersServices) {
        this.ordersServices = ordersServices;
    }
}
