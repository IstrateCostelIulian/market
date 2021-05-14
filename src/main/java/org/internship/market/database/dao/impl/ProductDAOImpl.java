package org.internship.market.database.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.internship.market.database.dao.ProductDAO;
import org.internship.market.database.entity.ProductEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class ProductDAOImpl implements ProductDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public ProductEntity findProductByName(String name) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        //Query<ProductEntity> query = session.createNamedQuery("findProductByName");
        //use HQL instead of NamedQueries
        Query<ProductEntity> query = session.createQuery("from ProductEntity where name= :name");
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
    public List<ProductEntity> getAllProducts() {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Query<ProductEntity> getList = session.createNamedQuery("getAllProducts");
        List<ProductEntity> productList = getList.list();
        session.getTransaction().commit();
        session.close();
        return productList;
    }


    @Override
    public void deleteProductByName(String name) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Query<ProductEntity> query = session.createNamedQuery("deleteProductByName");
        query.setParameter("name", name);
        query.executeUpdate();
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void updateProductPrice(double price, String name) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Query<ProductEntity> query = session.createNamedQuery("updateProductPrice");
        query.setParameter("name", name);
        query.setParameter("price", price);
        query.executeUpdate();
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void updateStock(int stock, String name) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Query<ProductEntity> query = session.createNamedQuery("updateStock");
        query.setParameter("stock", stock);
        query.setParameter("name", name);
        query.executeUpdate();
        session.getTransaction().commit();
        session.close();
    }
}
