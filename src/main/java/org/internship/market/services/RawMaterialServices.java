package org.internship.market.services;

import org.internship.market.database.entity.ProductEntity;
import org.internship.market.database.entity.RawMaterialEntity;
import org.internship.market.dto.ProductDTO;
import org.internship.market.dto.RawMaterialDTO;

import java.util.List;

public interface RawMaterialServices {

    List<RawMaterialDTO> getAllMaterials();

    void insertRawMaterials(RawMaterialDTO rawMaterialDTO);

    RawMaterialDTO findRawMaterialsByName(String name);

    void deleteRawMaterialsByName(String name);

    void updateRawMaterialsPrice(double price, String name);

    void updateRawMaterialStock(double quantity, String name);

    void updateCostFromPrice(double costs);

    void deleteAllProducts();

}
