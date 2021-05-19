package org.internship.market.services.impl;

import org.internship.market.dto.OrdersDTO;
import org.internship.market.services.OrdersServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrdersServicesImpl implements OrdersServices {

    @Autowired
    OrdersServices ordersServices;

    @Override
    public void insertOrder(OrdersDTO ordersDTO){

    }

    @Override
    public OrdersDTO findOrderByName(String name) {
        return null;
    }
}


