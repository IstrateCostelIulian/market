package org.internship.market.services.impl;

import org.internship.market.database.dao.AccountingDAO;
import org.internship.market.database.dao.ProductDAO;
import org.internship.market.database.dao.RawMaterialDAO;
import org.internship.market.database.entity.ProductEntity;
import org.internship.market.database.entity.RawMaterialEntity;
import org.internship.market.dto.ProductDTO;
import org.internship.market.dto.RawMaterialDTO;
import org.internship.market.services.ProductServices;
import org.internship.market.services.mapper.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.LinkedList;
import java.util.List;

@Service
public class ProductServicesImpl implements ProductServices {

    private final ProductDAO productDAO;
    private final ProductMapper productMapper;
    private final RawMaterialDAO rawMaterialDAO;
    private final AccountingDAO accountingDAO;

    @Autowired
    public ProductServicesImpl(ProductDAO productDAO, ProductMapper productMapper, RawMaterialDAO rawMaterialDAO,
                               AccountingDAO accountingDAO) {
        this.productDAO = productDAO;
        this.productMapper = productMapper;
        this.rawMaterialDAO = rawMaterialDAO;
        this.accountingDAO = accountingDAO;
    }


    @Override
    @Transactional
    public void insertProduct(ProductDTO productDTO) {
        ProductEntity foundProduct = productDAO.findProductByName(productDTO.getName());
        if (foundProduct == null) {
            ProductEntity productEntity = new ProductEntity();
            productEntity.setPrice(productDTO.getPrice());
            productEntity.setCommercial_excess(productDTO.getCommercial_excess());
            productEntity.setName(productDTO.getName());
            if (productDTO.getStock() == 0) {
                productEntity.setStock(1);
            } else {
                productEntity.setStock(productDTO.getStock());
            }
            List<RawMaterialEntity> rawMaterialEntities = new LinkedList<>();
            for (RawMaterialDTO rawMaterialDTO : productDTO.getRawMaterialsList()) {
                rawMaterialEntities.add(rawMaterialDAO.getRawMaterialByName(rawMaterialDTO.getName()));
            }
            productEntity.setRawMaterialsList(rawMaterialEntities);
            for (RawMaterialEntity rawMaterialEntity : productEntity.getRawMaterialsList()) {
                rawMaterialEntity.getProductEntities().add(productEntity);
            }
            productDAO.createProduct(productEntity);

            List<RawMaterialDTO> materialDTOS = productDTO.getRawMaterialsList();

            for (RawMaterialDTO rawMaterialDTO : materialDTOS) {

                rawMaterialDAO.updateRawMaterialsStock((rawMaterialDAO.getRawMaterialByName(rawMaterialDTO.getName()).
                                getStock() - rawMaterialDTO.getQuantity()),
                        rawMaterialDTO.getName()
                );
            }
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
    public void deleteAllProducts() {
        productDAO.deleteAllProducts();
    }


    @Override
    public void updatePrice(double price, String name) {
        productDAO.updateProductPrice(price, name);
    }

    @Override
    @Transactional
    public void updateStock(ProductDTO productDTO) {
        ProductEntity productEntity = productDAO.findProductByName(productDTO.getName());
        int stock = productEntity.getStock() + 1;
        productDAO.updateStock(stock, productDTO.getName());
        List<RawMaterialDTO> materialDTOS = productDTO.getRawMaterialsList();
        for (RawMaterialDTO rawMaterialDTO : materialDTOS) {
            RawMaterialEntity rawMaterialFound = rawMaterialDAO.getRawMaterialByName(rawMaterialDTO.getName());
            if (rawMaterialFound.getStock() > 0) {
                rawMaterialDAO.updateRawMaterialsStock((rawMaterialFound.
                                getStock() - rawMaterialDTO.getQuantity()),
                        rawMaterialDTO.getName()

                );
            }
        }
    }

    public boolean checkAvailableStock(ProductDTO productDTO) {
        List<RawMaterialDTO> materialDTOS = productDTO.getRawMaterialsList();
        for (RawMaterialDTO rawMaterialDTO : materialDTOS) {
            RawMaterialEntity rawMaterialByName = rawMaterialDAO.getRawMaterialByName(rawMaterialDTO.getName());
            if (rawMaterialByName == null) {
                return false;
            }
        }
        return true;
    }


}
