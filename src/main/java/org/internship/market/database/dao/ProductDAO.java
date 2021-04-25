package org.internship.market.database.dao;

import org.internship.market.database.entity.ProductEntity;

public interface ProductDAO {

    ProductEntity findProductByName(String name);

    void createProduct(ProductEntity productEntity);

    void deleteProductByName(String name);

    void updateProduct(double price, double commercial_excess);

}
