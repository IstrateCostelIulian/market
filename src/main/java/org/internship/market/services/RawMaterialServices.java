package org.internship.market.services;

import org.internship.market.database.entity.ProductEntity;
import org.internship.market.database.entity.RawMaterialEntity;
import org.internship.market.dto.RawMaterialDTO;

import java.util.List;

public interface RawMaterialServices {

    List<RawMaterialEntity> listOfMaterials();

    void insertRawMaterials(RawMaterialDTO rawMaterialDTO);

    RawMaterialDTO findRawMaterialsByName(String name);
}
