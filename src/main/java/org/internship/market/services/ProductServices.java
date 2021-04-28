package org.internship.market.services;

import org.internship.market.dto.ProductDTO;

import java.util.List;

public interface ProductServices {

    void insertProduct(ProductDTO productDTO);

    ProductDTO findProductByName(String name);

    List<ProductDTO> getAllProducts();

    void deleteProductByName(String name);

    void updatePrice(double price, String name);

}
