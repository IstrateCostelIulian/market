package market.database.dao;

import market.database.entity.RawMaterialEntity;

import java.util.List;

public interface RawMaterialDAO {

    List<RawMaterialEntity> getAllMaterial();

    RawMaterialEntity getRawMaterialByName(String name);

    void createRawMaterial(RawMaterialEntity rawMaterialEntity);

    void updateRawMaterialPrice(String name, double newPriceValue);

    void updateRawMaterialsStock(double stock, String name);

    void deleteRawMaterialsByName(String name);

    void deleteAllMaterials();


}
