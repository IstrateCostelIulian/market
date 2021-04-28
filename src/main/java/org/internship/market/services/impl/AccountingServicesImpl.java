package org.internship.market.services.impl;

import org.internship.market.database.dao.AccountingDAO;
import org.internship.market.database.entity.AccountingEntity;
import org.internship.market.dto.AccountingDTO;
import org.internship.market.services.AccountingServices;
import org.internship.market.services.mapper.AccountingMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountingServicesImpl implements AccountingServices {


    @Autowired
    AccountingDAO accountingDAO;

    @Autowired
    AccountingMapper mapper;

    @Override
    public void insert(AccountingDTO accountingDTO) {
        AccountingEntity accountingEntity = mapper.dtoToEntity(accountingDTO);
        accountingDAO.save(accountingEntity);
    }

    @Override
    public AccountingDTO getAccountingById(long id) {
        AccountingEntity accountingEntity = accountingDAO.getAccountingById(id);
        return mapper.entityToDto(accountingEntity);
    }

    @Override
    public List<AccountingDTO> getAllAccounting() {
        List<AccountingEntity> allEntities = accountingDAO.getAll();
        return mapper.entitiesToDtoS(allEntities);
    }

    @Override
    public void deleteAccountingById(long id) {
        accountingDAO.deleteAccountingById(id);
    }

    @Override
    public void updateCosts(double costs, long id) {
        accountingDAO.updateCosts(costs, id);
    }


}
