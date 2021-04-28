package org.internship.market.services.impl;

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
    RawMaterialMapper mapper;


    @Override
    public void insertRawMaterials(RawMaterialDTO rawMaterialDTO) {
        RawMaterialEntity foundRawMaterialEntity = rawMaterialDAO.getRawMaterialByName(rawMaterialDTO.getName());
        if (foundRawMaterialEntity == null) {
            RawMaterialEntity rawMaterialEntity = mapper.dtoToEntity(rawMaterialDTO);
            rawMaterialDAO.createRawMaterial(rawMaterialEntity);
        } else {
            rawMaterialDAO.createRawMaterial(foundRawMaterialEntity);
        }
    }

    @Override
    public RawMaterialDTO findRawMaterialsByName(String name) {
        RawMaterialEntity rawMaterialEntity = rawMaterialDAO.getRawMaterialByName(name);
        return mapper.entityToDto(rawMaterialEntity);
    }


    @Override
    public List<RawMaterialDTO> listOfMaterials() {
        List<RawMaterialEntity> rawMaterialEntities = rawMaterialDAO.getAllMaterial();
        return mapper.entityToDtoS(rawMaterialEntities);
    }

    @Override
    public void deleteRawMaterialByName(String name) {

    }

    @Override
    public void updatePrice(double price, String name) {

    }
}
