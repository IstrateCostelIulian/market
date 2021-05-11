package org.internship.market.database.dao;

import org.internship.market.database.entity.ProductEntity;

import java.util.List;

public interface ProductDAO {

    ProductEntity findProductByName(String name);

    void createProduct(ProductEntity productEntity);

    List<ProductEntity> getAllProducts();

    void deleteProductByName(String name);

    void updateProductPrice(double price, String name);

    void updateStock(int stock, String name);

}
