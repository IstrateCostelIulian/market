package org.internship.market.services.impl;

import org.internship.market.database.dao.RawMaterialDAO;
import org.internship.market.database.entity.RawMaterialEntity;
import org.internship.market.dto.RawMaterialDTO;
import org.internship.market.services.RawMaterialServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RawMaterialServicesImpl implements RawMaterialServices {

    @Autowired
    RawMaterialDAO rawMaterialDAO;

    @Override
    public List<RawMaterialEntity> listOfMaterials() {
        return null;
    }

    @Override
    public void insertRawMaterials(RawMaterialDTO rawMaterialDTO) {
        RawMaterialEntity foundRawMaterialEntity = rawMaterialDAO.getRawMaterialByName(rawMaterialDTO.getName());
        if(foundRawMaterialEntity == null){
            RawMaterialEntity rawMaterialEntity = new RawMaterialEntity();
            rawMaterialEntity.setName(rawMaterialDTO.getName());
            rawMaterialEntity.setPrice(rawMaterialDTO.getPrice());
            rawMaterialDAO.createRawMaterial(rawMaterialEntity);
        }else{
            rawMaterialDAO.createRawMaterial(foundRawMaterialEntity);
        }
    }

    @Override
    public RawMaterialDTO findRawMaterialsByName(String name) {
        RawMaterialEntity rawMaterialEntity = rawMaterialDAO.getRawMaterialByName(name);
        RawMaterialDTO rawMaterialDTO = new RawMaterialDTO();
        rawMaterialDTO.setName(rawMaterialEntity.getName());
        rawMaterialDTO.setPrice(rawMaterialEntity.getPrice());
        return rawMaterialDTO;
    }
}
