package org.internship.market.services;

import org.internship.market.dto.ProductDTO;

public interface ProductServices {

    void insertProduct(ProductDTO productDTO);

    ProductDTO findProductByName(String name);

}
