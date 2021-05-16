package org.internship.market.services.impl;

import org.internship.market.database.dao.AccountingDAO;
import org.internship.market.database.dao.RawMaterialDAO;
import org.internship.market.database.entity.RawMaterialEntity;
import org.internship.market.dto.RawMaterialDTO;
import org.internship.market.services.RawMaterialServices;
import org.internship.market.services.mapper.RawMaterialMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RawMaterialServicesImpl implements RawMaterialServices {

    @Autowired
    RawMaterialDAO rawMaterialDAO;

    @Autowired
    RawMaterialMapper rawMaterialMapper;

    @Autowired
    AccountingDAO accountingDAO;


    @Override
    public void insertRawMaterials(RawMaterialDTO rawMaterialDTO) {
        RawMaterialEntity foundRawMaterialEntity = rawMaterialDAO.getRawMaterialByName(rawMaterialDTO.getName());
        if (foundRawMaterialEntity == null) {
            RawMaterialEntity rawMaterialEntity = rawMaterialMapper.dtoToEntity(rawMaterialDTO);
            rawMaterialDAO.createRawMaterial(rawMaterialEntity);
        } else {
            double stock = rawMaterialDTO.getQuantity() + foundRawMaterialEntity.getStock();
            rawMaterialDAO.updateRawMaterialsStock(stock, rawMaterialDTO.getName());
        }
        //accountingDAO.updateCosts();

    }

    @Override
    public RawMaterialDTO findRawMaterialsByName(String name) {
        RawMaterialEntity rawMaterialEntity = rawMaterialDAO.getRawMaterialByName(name);
        return rawMaterialMapper.entityToDto(rawMaterialEntity);
    }

    @Override
    public void deleteRawMaterialsByName(String name) {
        rawMaterialDAO.deleteRawMaterialsByName(name);
    }

    @Override
    public void updateRawMaterialsPrice(double price, String name) {
        rawMaterialDAO.updateRawMaterialPrice(name, price);
    }

    @Override
    public void updateRawMaterialStock(double quantity, String name) {
        RawMaterialEntity foundRawMaterial = rawMaterialDAO.getRawMaterialByName(name);
        if (foundRawMaterial != null) {
            quantity += foundRawMaterial.getStock();
            rawMaterialDAO.updateRawMaterialsStock(quantity, name);
        }
    }

    @Override
    public void deleteAllProducts() {
        rawMaterialDAO.deleteAllMaterials();
    }


    @Override
    public List<RawMaterialDTO> getAllMaterials() {
        List<RawMaterialEntity> rawMaterialEntities = rawMaterialDAO.getAllMaterial();
        return rawMaterialMapper.entityToDtoS(rawMaterialEntities);
    }

}
