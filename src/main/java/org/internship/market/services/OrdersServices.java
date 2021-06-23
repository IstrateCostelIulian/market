package org.internship.market.services;


import org.internship.market.database.entity.OrdersEntity;
import org.internship.market.dto.OrdersDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface OrdersServices {


    void insertOrder(OrdersDTO ordersDTO);

    OrdersDTO findOrderByNumber(long orderNumber);

    List<OrdersDTO> getAll();

    void deleteOrderByNumber(long orderNumber);

    void  deleteAllOrders();

    void updateOrderPrice(double price, long orderNumber);

    void updateOrderStatus(String status, long orderNumber);

    void updateOrderQuantity(int quantity, long orderNumber);


}

