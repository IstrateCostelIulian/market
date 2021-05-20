package org.internship.market.database.dao;

import org.internship.market.database.entity.OrdersEntity;

public interface OrdersDAO {

    void createOrder(OrdersEntity ordersEntity);

    OrdersEntity findOrderByName(String name);

    void deleteOrderByName(String name);

    void  deleteAllOrders();

}
