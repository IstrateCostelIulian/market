package market.database.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import market.database.dao.CustomerDAO;
import market.database.entity.CustomerEntity;
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
    public void deleteByEmail(String emailAddress) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Query query = session.createQuery("delete CustomerEntity customerEntity where emailAddress =:emailAddress");
        query.setParameter("emailAddress", emailAddress);
        query.executeUpdate();
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

    @Override
    public void deleteALL() {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Query query = session.createQuery("delete CustomerEntity customerEntity");
        query.executeUpdate();
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public CustomerEntity findByEmail(String emailAddress) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Query<CustomerEntity> query = session.createQuery("from CustomerEntity where emailAddress=:emailAddress");
        query.setParameter("emailAddress", emailAddress);
        CustomerEntity responseEntity = query.uniqueResult();
        session.getTransaction().commit();
        session.close();
        return responseEntity;
    }

    @Override
    public CustomerEntity findByPhoneNumber(String phoneNumber) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Query<CustomerEntity> query = session.createQuery("from CustomerEntity where phoneNumber=:phoneNumber");
        query.setParameter("phoneNumber", phoneNumber);
        CustomerEntity responseEntity = query.uniqueResult();
        session.getTransaction().commit();
        session.close();
        return responseEntity;
    }

    @Override
    public void updateNameAndSurname(String name, String surname, String emailAddress) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Query update = session.createQuery(
                "update CustomerEntity customerEntity set name=:name , surname=:surname where emailAddress =:emailAddress"
        );
        update.setParameter("name", name);
        update.setParameter("surname", surname);
        update.setParameter("emailAddress", emailAddress);
        update.executeUpdate();
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void updatePhoneNumber(String phoneNumber, String emailAddress) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Query update = session.createQuery(
                "update CustomerEntity customerEntity set phoneNumber=:phoneNumber where emailAddress=:emailAddress"
        );
        update.setParameter("phoneNumber", phoneNumber);
        update.setParameter("emailAddress", emailAddress);
        update.executeUpdate();
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void updateAddress(String address, String emailAddress) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Query update = session.createQuery(
                "update CustomerEntity customerEntity set address=:address where emailAddress=:emailAddress"
        );
        update.setParameter("address", address);
        update.setParameter("emailAddress", emailAddress);
        update.executeUpdate();
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void updateEmail(String emailAddress, String phoneNumber) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Query update = session.createQuery(
                "update CustomerEntity customerEntity set emailAddress=:emailAddress where phoneNumber=:phoneNumber"
        );
        update.setParameter("emailAddress", emailAddress);
        update.setParameter("phoneNumber", phoneNumber);
        update.executeUpdate();
        session.getTransaction().commit();
        session.close();
    }
}
