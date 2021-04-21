package org.internship.market.database.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
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
       Session session =  sessionFactory.openSession();
       session.beginTransaction();
       session.save(accountingEntity);
       session.getTransaction().commit();
       session.close();
    }


}
