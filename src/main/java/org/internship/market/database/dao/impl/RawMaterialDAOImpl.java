package org.internship.market.database.dao.impl;

import org.hibernate.SessionFactory;
import org.internship.market.database.dao.RawMaterialDAO;
import org.internship.market.database.entity.RawMaterialEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RawMaterialDAOImpl implements RawMaterialDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<RawMaterialEntity> getAllMaterial() {
        return this.sessionFactory.getCurrentSession().createQuery("select r from RawMaterialEntity r").list();
    }

    @Override
    public RawMaterialEntity getRawMaterialByName(String name) {
        return null;
    }

    @Override
    public RawMaterialEntity createRawMaterial(RawMaterialEntity rawMaterialEntity) {
        return null;
    }

    @Override
    public void updateRawMaterial(String name, double newPriceValue) {

    }
}
