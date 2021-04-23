package org.internship.market.database.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.internship.market.database.dao.AccountingDAO;
import org.internship.market.database.entity.AccountingEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


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
        Transaction tx = session.beginTransaction();

        //HQL Named Query Example
        Query<AccountingEntity> query = session.createNamedQuery("HQL_GET_BY_ID");
        query.setParameter("id", id);
        AccountingEntity accountingEntity = query.uniqueResult();
        tx.commit();
        session.close();
        return accountingEntity;
    }


}
