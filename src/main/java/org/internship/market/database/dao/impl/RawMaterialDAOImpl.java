package org.internship.market.database.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.internship.market.database.dao.RawMaterialDAO;
import org.internship.market.database.entity.RawMaterialEntity;
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
        return null;
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
        return  responseEntity;
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
    public void updateRawMaterial(String name, double newPriceValue) {

    }
}
