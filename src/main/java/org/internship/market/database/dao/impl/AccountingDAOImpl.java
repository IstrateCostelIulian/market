package org.internship.market.database.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.internship.market.database.dao.AccountingDAO;
import org.internship.market.database.entity.AccountingEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class AccountingDAOImpl implements AccountingDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void save(AccountingEntity accountingEntity) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(accountingEntity);
        session.getTransaction().commit();
        session.close();
    }

    public AccountingEntity getAccountingById(long id) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        //HQL Named Query Example
        Query<AccountingEntity> query = session.createNamedQuery("HQL_GET_BY_ID");
        query.setParameter("id", id);
        AccountingEntity accountingEntity = query.uniqueResult();
        session.getTransaction().commit();
        session.close();
        return accountingEntity;
    }

    public List<AccountingEntity> getAll() {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Query<AccountingEntity> query = session.createNamedQuery("getAll");
        List<AccountingEntity> allEntities = query.list();
        session.getTransaction().commit();
        session.close();
        return allEntities;
    }

    @Override
    public void deleteAccountingById(long id) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Query<AccountingEntity> query = session.createNamedQuery("deleteAccountingById");
        query.setParameter("id", id);
        query.executeUpdate();
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void updateCosts(double costs, long id) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Query<AccountingEntity> query = session.createNamedQuery("updateCosts");
        query.setParameter("costs", costs);
        query.setParameter("id", id);
        query.executeUpdate();
        session.getTransaction().commit();
        session.close();
    }


}
