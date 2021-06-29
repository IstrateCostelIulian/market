package market.database.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import market.database.dao.RawMaterialDAO;
import market.database.entity.RawMaterialEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Repository
@Transactional
public class RawMaterialDAOImpl implements RawMaterialDAO {

    @Autowired
    private SessionFactory sessionFactory;


    @Override
    public List<RawMaterialEntity> getAllMaterial() {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Query<RawMaterialEntity> query = session.createNamedQuery("getAllRawMaterials");
        List<RawMaterialEntity> list = query.getResultList();
        return list;
    }

    @Override
    public RawMaterialEntity getRawMaterialByName(String name) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Query<RawMaterialEntity> query = session.createNamedQuery("findRawMaterialByName");
        query.setParameter("name", name);
        RawMaterialEntity responseEntity = query.uniqueResult();
        session.getTransaction().commit();
        session.close();
        return responseEntity;
    }

    @Override
    public void createRawMaterial(RawMaterialEntity rawMaterialEntity) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(rawMaterialEntity);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void updateRawMaterialPrice(String name, double newPriceValue) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Query<RawMaterialEntity> query = session.createNamedQuery("updateRawMaterialsPrice");
        query.setParameter("name", name);
        query.setParameter("price", newPriceValue);
        query.executeUpdate();
        session.getTransaction().commit();
        session.close();
    }


    @Override
    public void updateRawMaterialsStock(double stock, String name) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Query<RawMaterialEntity> query = session.createNamedQuery("updateRawMaterialStock");
        query.setParameter("name", name);
        query.setParameter("stock", stock);
        query.executeUpdate();
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void deleteRawMaterialsByName(String name) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Query<RawMaterialEntity> query = session.createNamedQuery("deleteRawMaterialByName");
        query.setParameter("name", name);
        query.executeUpdate();
        session.getTransaction().commit();
        session.close();
    }

    public void deleteAllMaterials() {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Query<RawMaterialEntity> query = session.createQuery("delete RawMaterialEntity rawMaterialsEntity ");
        query.executeUpdate();
        session.getTransaction().commit();
        session.close();
    }

}
