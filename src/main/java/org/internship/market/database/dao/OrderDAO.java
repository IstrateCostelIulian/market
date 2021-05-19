package org.internship.market.database.dao;

import org.internship.market.database.entity.OrdersEntity;

public interface OrderDAO {


    OrdersEntity findOrderByName(String name);

}
