package market.services.impl;

import lombok.extern.slf4j.Slf4j;
import market.database.dao.AccountingDAO;
import market.database.entity.AccountingEntity;
import market.dto.AccountingDTO;
import market.services.AccountingServices;
import market.services.mapper.AccountingMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class AccountingServicesImpl implements AccountingServices {

    private final AccountingDAO accountingDAO;
    private final AccountingMapper mapper;

    @Autowired
    public AccountingServicesImpl(AccountingDAO accountingDAO,
                                  AccountingMapper mapper) {
        this.accountingDAO = accountingDAO;
        this.mapper = mapper;
    }

    @Override
    public void insert(AccountingDTO accountingDTO) {
        AccountingEntity accountingEntity = mapper.dtoToEntity(accountingDTO);
        log.info("insert : {} ", accountingEntity.toString());
        accountingDAO.save(accountingEntity);
    }

    @Override
    public List<AccountingDTO> getAllAccounting() {
        List<AccountingEntity> allEntities = accountingDAO.getAll();
        log.info("getAllAccounting size : {} ", allEntities.size());
        return mapper.entitiesToDtoS(allEntities);
    }

    @Override
    public void deleteAccounting() {
        log.info("Service delete");
        accountingDAO.deleteAccounting();
    }

    @Override
    public void updateCosts(double costs) {
        log.info("Service update cost for  cost : {} ", costs);
        accountingDAO.updateCosts(costs);
    }

    @Override
    public void updateIncome(double income) {
        log.info("Service update income for  income : {} ", income);
        accountingDAO.updateIncome(income);
    }

}
