package org.internship.market.services;


import org.internship.market.dto.OrdersDTO;
import org.springframework.stereotype.Service;

@Service
public interface OrdersServices {


    void insertOrder(OrdersDTO ordersDTO);

    OrdersDTO findOrderByName(String name);


}

