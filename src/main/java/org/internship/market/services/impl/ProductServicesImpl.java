package org.internship.market.services.impl;

import org.internship.market.database.dao.ProductDAO;
import org.internship.market.database.entity.ProductEntity;
import org.internship.market.dto.ProductDTO;
import org.internship.market.services.ProductServices;
import org.internship.market.services.mapper.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServicesImpl implements ProductServices {

    @Autowired
    ProductDAO productDAO;

    @Autowired
    ProductMapper mapper;

    @Override
    public void insertProduct(ProductDTO productDTO) {
        ProductEntity foundProduct = productDAO.findProductByName(productDTO.getName());
        if (foundProduct == null) {
            ProductEntity productEntity = mapper.dtoToEntity(productDTO);
            productDAO.createProduct(productEntity);
        } else {
            productDAO.createProduct(foundProduct);
        }
    }

    @Override
    public ProductDTO findProductByName(String name) {
        ProductEntity productEntity = productDAO.findProductByName(name);
        return mapper.entityToDTO(productEntity);

    }

    @Override
    public List<ProductDTO> getAllProducts() {
        return null;
    }

    @Override
    public void deleteProductByName(String name) {

    }


    @Override
    public void updatePrice(double price, String name) {

    }
}
