package org.internship.market.database.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.internship.market.database.dao.OrdersDAO;
import org.internship.market.database.entity.OrdersEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
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
    public OrdersEntity findOrderByNumber(long orderNUmber) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Query<OrdersEntity> query = session.createQuery("from OrdersEntity where orderNumber=:orderNumber");
        query.setParameter("orderNUmber", orderNUmber);
        OrdersEntity ordersEntity = query.uniqueResult();
        session.getTransaction().commit();
        session.close();
        return ordersEntity;
    }

    @Override
    public List<OrdersEntity> getAll() {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Query<OrdersEntity> query = session.createQuery("from OrdersEntity");
        List<OrdersEntity> list = query.getResultList();
        session.getTransaction().commit();
        session.close();
        return list;
    }

    @Override
    public void deleteOrderByNumber(long orderNumber) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Query query = session.createQuery("delete OrdersEntity ordersEntity where orderNumber=:orderNumber");
        query.setParameter("orderNumber", orderNumber);
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

    @Override
    public void updateOrderPrice(double price, long orderNumber) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Query update = session.createQuery(
                "update OrderEntity orderEntity set price=:price where orderNumber=:orderNumber"
        );
        update.setParameter("price", price);
        update.setParameter("orderNumber", orderNumber);
        update.executeUpdate();
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void updateOrderStatus(String status, long orderNumber) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Query update = session.createQuery(
                "update OrderEntity orderEntity set status=:status where orderNumber=:orderNumber"
        );
        update.setParameter("status", status);
        update.setParameter("orderNumber", orderNumber);
        update.executeUpdate();
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void updateOrderQuantity(int quantity, long orderNumber) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Query update = session.createQuery(
                "update OrderEntity orderEntity set quantity=:quantity where orderNumber=:orderNumber"
        );
        update.setParameter("quantity", quantity);
        update.setParameter("orderNumber", orderNumber);
        update.executeUpdate();
        session.getTransaction().commit();
        session.close();
    }
}
