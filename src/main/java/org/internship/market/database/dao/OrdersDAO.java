package org.internship.market.database.dao;

import org.internship.market.database.entity.OrdersEntity;

import java.util.List;

public interface OrdersDAO {

    void createOrder(OrdersEntity ordersEntity);

    OrdersEntity findOrderByNumber(long orderNumber);

    List<OrdersEntity> getAll();

    void deleteOrderByNumber(long orderNumber);

    void  deleteAllOrders();

    void updateOrderPrice(double price, long orderNumber);

    void updateOrderStatus(String status, long orderNumber);

    void updateOrderQuantity(int quantity, long orderNumber);

}
