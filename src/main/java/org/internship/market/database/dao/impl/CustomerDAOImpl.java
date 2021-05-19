package org.internship.market.database.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.internship.market.database.dao.CustomerDAO;
import org.internship.market.database.entity.CustomerEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class CustomerDAOImpl implements CustomerDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void createCustomer(CustomerEntity customerEntity) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(customerEntity);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public CustomerEntity findByName(String name) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Query<CustomerEntity> query = session.createQuery("from CustomerEntity where name=:name");
        query.setParameter("name", name);
        CustomerEntity responseEntity = query.uniqueResult();
        session.getTransaction().commit();
        session.close();
        return responseEntity;
    }

    @Override
    public void deleteByName(String name) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Query query = session.createQuery("delete CustomerEntity customerEntity where name =:name");
        query.setParameter("name", name);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public List<CustomerEntity> findAll() {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Query<CustomerEntity> query = session.createQuery("from CustomerEntity");
        List<CustomerEntity> responseEntity = query.getResultList();
        session.getTransaction().commit();
        session.close();
        return responseEntity;
    }
}
