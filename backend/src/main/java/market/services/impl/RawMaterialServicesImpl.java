package market.services.impl;

import market.database.dao.AccountingDAO;
import market.database.dao.RawMaterialDAO;
import market.database.entity.AccountingEntity;
import market.database.entity.RawMaterialEntity;
import market.dto.RawMaterialDTO;
import market.services.RawMaterialServices;
import market.services.mapper.RawMaterialMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
public class RawMaterialServicesImpl implements RawMaterialServices {

    private final RawMaterialDAO rawMaterialDAO;
    private final RawMaterialMapper rawMaterialMapper;
    private final AccountingDAO accountingDAO;

    @Autowired
    public RawMaterialServicesImpl(RawMaterialDAO rawMaterialDAO,
                                   RawMaterialMapper rawMaterialMapper,
                                   AccountingDAO accountingDAO) {
        this.rawMaterialDAO = rawMaterialDAO;
        this.rawMaterialMapper = rawMaterialMapper;
        this.accountingDAO = accountingDAO;
    }

    @Override
    @Transactional
    public void insertRawMaterials(RawMaterialDTO rawMaterialDTO) {
        RawMaterialEntity rawMaterialEntity = rawMaterialMapper.dtoToEntity(rawMaterialDTO);
        rawMaterialDAO.createRawMaterial(rawMaterialEntity);
        double costToAdd = rawMaterialDTO.getQuantity() * rawMaterialDTO.getPrice();
        updateCostFromPrice(costToAdd);
    }


    public void updateCostFromPrice(double costs) {
        AccountingEntity foundAccounting = accountingDAO.getAll().get(0);

        if (foundAccounting == null) {
            AccountingEntity accountingEntity = new AccountingEntity();
            accountingEntity.setCosts(costs);
            accountingEntity.setEconomicBalance(1000 - costs);
            accountingEntity.setIncome(0);
            accountingEntity.setDate(new Date());
            accountingDAO.save(accountingEntity);
        } else {
            double newCost = costs + foundAccounting.getCosts();
            accountingDAO.updateCosts(newCost);
            accountingDAO.updateEconomicBalanceByCosts(foundAccounting.getEconomicBalance());
        }
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
    @Transactional
    public void updateRawMaterialStock(double quantity, String name) {
        RawMaterialEntity foundRawMaterial = rawMaterialDAO.getRawMaterialByName(name);

        if (foundRawMaterial != null) {
            quantity += foundRawMaterial.getStock();
            rawMaterialDAO.updateRawMaterialsStock(quantity, name);

            double newPrice = quantity * foundRawMaterial.getPrice();
            updateCostFromPrice(newPrice);
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
