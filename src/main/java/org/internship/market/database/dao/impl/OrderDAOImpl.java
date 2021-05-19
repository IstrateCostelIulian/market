package org.internship.market.database.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.internship.market.database.dao.OrderDAO;
import org.internship.market.database.entity.OrdersEntity;
import org.springframework.beans.factory.annotation.Autowired;

public class OrderDAOImpl implements OrderDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public OrdersEntity findOrderByName(String name) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Query<OrdersEntity> query = session.createNamedQuery("findOrderByName");
        query.setParameter("name", name);
        OrdersEntity ordersEntity= query.uniqueResult();
        session.getTransaction().commit();
        session.close();
        return ordersEntity;
    }
}
