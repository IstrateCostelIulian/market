package org.internship.market.database.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.internship.market.database.dao.OrdersDAO;
import org.internship.market.database.entity.OrdersEntity;
import org.springframework.beans.factory.annotation.Autowired;

public class OrdersDAOImpl implements OrdersDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void createOrder(OrdersEntity ordersEntity) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(ordersEntity);
        session.getTransaction().commit();
        session.close();

    }

    @Override
    public OrdersEntity findOrderByName(String name) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Query<OrdersEntity> query = session.createQuery("from OrdersEntity where name= :name");
        query.setParameter("name", name);
        OrdersEntity ordersEntity= query.uniqueResult();
        session.getTransaction().commit();
        session.close();
        return ordersEntity;
    }

    @Override
    public void deleteOrderByName(String name) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Query query = session.createQuery("delete OrdersEntity ordersEntity where name =:name");
        query.setParameter("name", name);
        session.getTransaction().commit();
        session.close();

    }

    @Override
    public void deleteAllOrders() {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Query<OrdersEntity> query = session.createQuery("delete OrdersEntity ordersEntity");
        query.executeUpdate();
        session.getTransaction().commit();
        session.close();

    }
}
