package org.internship.market.services.impl;

import org.internship.market.database.dao.ProductDAO;
import org.internship.market.database.entity.ProductEntity;
import org.internship.market.database.entity.RawMaterialEntity;
import org.internship.market.dto.ProductDTO;
import org.internship.market.services.ProductServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServicesImpl implements ProductServices {

    @Autowired
    ProductDAO productDAO;

    @Override
    public void insertProduct(ProductDTO productDTO) {
        ProductEntity foundProduct = productDAO.findProductByName(productDTO.getName());
        if (foundProduct == null) {
            ProductEntity productEntity = new ProductEntity();
            RawMaterialEntity rawMaterialEntity = new RawMaterialEntity();
            rawMaterialEntity.setName(productDTO.getRawMaterialDTO().getName());
            rawMaterialEntity.setPrice(productDTO.getRawMaterialDTO().getPrice());
            productEntity.setName(productDTO.getName());
            productEntity.setCommercial_excess(productDTO.getCommercial_excess());
            productEntity.setPrice(productDTO.getPrice());
            productEntity.setRawMaterialEntity(rawMaterialEntity);
            productDAO.createProduct(productEntity);
        } else {
            productDAO.createProduct(foundProduct);
        }
    }

    @Override
    public ProductDTO findProductByName(String name) {
        ProductEntity productEntity = productDAO.findProductByName(name);
        if(productEntity == null){
            return null;
        }
        ProductDTO productDTO = new ProductDTO();
        productDTO.setName(productEntity.getName());
        productDTO.setCommercial_excess(productEntity.getCommercial_excess());
        productDTO.setPrice(productEntity.getPrice());
        return productDTO;
    }
}
