package org.internship.market.database.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
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
        return this.sessionFactory.getCurrentSession().createQuery("from RawMaterialEntity r").list();
    }

    @Override
    public RawMaterialEntity getRawMaterialByName(String name) {
        return null;
    }

    @Override
    public void createRawMaterial(RawMaterialEntity rawMaterialEntity) {
        Session session = this.sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.persist(rawMaterialEntity);
        tx.commit();
        session.close();
    }

    @Override
    public void updateRawMaterial(String name, double newPriceValue) {

    }
}
