package org.internship.market.database.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.internship.market.database.dao.ProductDAO;
import org.internship.market.database.entity.ProductEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class ProductDAOImpl implements ProductDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public ProductEntity findProductByName(String name) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Query<ProductEntity> query = session.createNamedQuery("findProductByName");
        query.setParameter("name", name);
        ProductEntity productEntity = query.uniqueResult();
        session.getTransaction().commit();
        session.close();
        return productEntity;
    }

    @Override
    public void createProduct(ProductEntity productEntity) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(productEntity);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void deleteProductByName(String name) {

    }

    @Override
    public void updateProduct(double price, double commercial_excess) {

    }
}
