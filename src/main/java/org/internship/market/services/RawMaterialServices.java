package org.internship.market.services;

import org.internship.market.database.entity.ProductEntity;
import org.internship.market.database.entity.RawMaterialEntity;
import org.internship.market.dto.ProductDTO;
import org.internship.market.dto.RawMaterialDTO;

import java.util.List;

public interface RawMaterialServices {

    List<RawMaterialDTO> listOfMaterials();

    void insertRawMaterials(RawMaterialDTO rawMaterialDTO);

    RawMaterialDTO findRawMaterialsByName(String name);

    void deleteRawMaterialByName(String name);

    void updatePrice(double price, String name);
}
