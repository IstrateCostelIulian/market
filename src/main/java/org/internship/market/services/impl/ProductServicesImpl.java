package org.internship.market.services.impl;

import org.internship.market.database.dao.ProductDAO;
import org.internship.market.database.dao.RawMaterialDAO;
import org.internship.market.database.entity.ProductEntity;
import org.internship.market.database.entity.RawMaterialEntity;
import org.internship.market.dto.ProductDTO;
import org.internship.market.dto.RawMaterialDTO;
import org.internship.market.services.ProductServices;
import org.internship.market.services.mapper.ProductMapper;
import org.internship.market.services.mapper.RawMaterialMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServicesImpl implements ProductServices {

    @Autowired
    ProductDAO productDAO;

    @Autowired
    ProductMapper productMapper;

    @Autowired
    RawMaterialMapper materialMapper;

    @Autowired
    RawMaterialDAO rawMaterialDAO;

    @Override
    public void insertProduct(ProductDTO productDTO) {
        ProductEntity foundProduct = productDAO.findProductByName(productDTO.getName());
        if (foundProduct == null) {
            ProductEntity productEntity = productMapper.dtoToEntity(productDTO);
            for(RawMaterialEntity rawMaterialEntity : productEntity.getRawMaterialsList()){
                rawMaterialEntity.getProductEntities().add(productEntity);
            }
            productDAO.createProduct(productEntity);

            /*
            for (RawMaterialEntity rawMaterialEntity : rawMaterialDAO.getAllMaterial()) {
                for (RawMaterialDTO rawMaterialDTO : productDTO.getRawMaterialsList()) {
                    if (rawMaterialDTO.getName().equals(rawMaterialEntity.getName())) {
                        rawMaterialDAO.updateRawMaterialsStock(rawMaterialEntity.getStock() - rawMaterialDTO.getStock(),
                                rawMaterialDTO.getName());
                    }
                }
            }
             */
        }
    }

    @Override
    public ProductDTO findProductByName(String name) {
        ProductEntity productEntity = productDAO.findProductByName(name);
        return productMapper.entityToDTO(productEntity);
    }

    @Override
    public List<ProductDTO> getAllProducts() {
        List<ProductEntity> productEntityList = productDAO.getAllProducts();
        return productMapper.entitiesToDtoS(productEntityList);
    }

    @Override
    public void deleteProductByName(String name) {
        productDAO.deleteProductByName(name);
    }


    @Override
    public void updatePrice(double price, String name) {
        productDAO.updateProductPrice(price, name);
    }

    @Override
    public void updateStock(ProductDTO productDTO) {
        ProductEntity productEntity = productDAO.findProductByName(productDTO.getName());
        int stock = productEntity.getStock() + 1;
        productDAO.updateStock(stock, productDTO.getName());
    }

    private boolean compareListsOfRawMaterials(ProductDTO productDTO) {
        List<RawMaterialDTO> materialDTOS = productDTO.getRawMaterialsList();
        for (RawMaterialDTO rawMaterialDTO : materialDTOS) {
            //caching is enabled
            if (rawMaterialDAO.getRawMaterialByName(rawMaterialDTO.getName()) == null)
                return false;
        }
        return true;
    }

    public boolean checkAvailableStock(ProductDTO productDTO) {
        //boolean available = true;
        if (compareListsOfRawMaterials(productDTO)) {

            List<RawMaterialEntity> materials = rawMaterialDAO.getAllMaterial();
            for (RawMaterialEntity rawMaterialEntity : materials) {
                if (rawMaterialEntity.getStock() == 0) {
                    return false;
                }
            }

        }
        return true;
    }
}
