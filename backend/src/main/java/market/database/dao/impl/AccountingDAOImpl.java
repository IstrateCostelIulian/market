package market.database.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import market.database.dao.AccountingDAO;
import market.database.entity.AccountingEntity;
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
    public void deleteAccounting() {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Query<AccountingEntity> query = session.createNamedQuery("deleteAccounting");
        query.executeUpdate();
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void updateCosts(double costs) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Query<AccountingEntity> query = session.createNamedQuery("updateCosts");
        query.setParameter("costs", costs);
        query.executeUpdate();
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void updateIncome(double income) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Query<AccountingEntity> query = session.createNamedQuery("updateIncome");
        query.setParameter("income", income);
        query.executeUpdate();
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void updateEconomicBalanceByCosts(double economicBalance) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Query<AccountingEntity> query = session.createNamedQuery("updateEconomicBalanceByCosts");
        query.setParameter("economicBalance", economicBalance);
        query.executeUpdate();
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void updateEconomicBalanceByIncome(double economicBalance) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Query<AccountingEntity> query = session.createNamedQuery("updateEconomicBalanceByIncome");
        query.setParameter("economicBalance", economicBalance);
        query.executeUpdate();
        session.getTransaction().commit();
        session.close();
    }

}
