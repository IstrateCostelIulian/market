package org.internship.market.services.impl;

import lombok.extern.slf4j.Slf4j;
import org.internship.market.database.dao.AccountingDAO;
import org.internship.market.database.entity.AccountingEntity;
import org.internship.market.dto.AccountingDTO;
import org.internship.market.services.AccountingServices;
import org.internship.market.services.mapper.AccountingMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class AccountingServicesImpl implements AccountingServices {


    @Autowired
    AccountingDAO accountingDAO;

    @Autowired
    AccountingMapper mapper;

    @Override
    @CacheEvict("accounting")
    public void insert(AccountingDTO accountingDTO) {
        AccountingEntity accountingEntity = mapper.dtoToEntity(accountingDTO);
        log.info("insert : {} ", accountingEntity.toString());
        accountingDAO.save(accountingEntity);
    }

    @Override
    @Cacheable("accounting")
    public AccountingDTO getAccountingById(long id) {
        AccountingEntity accountingEntity = accountingDAO.getAccountingById(id);
        log.info("getAccountingById : {} , = {} ", id, accountingEntity);
        return mapper.entityToDto(accountingEntity);
    }

    @Override
    @Cacheable("accounting")
    public List<AccountingDTO> getAllAccounting() {
        List<AccountingEntity> allEntities = accountingDAO.getAll();
        log.info("getAllAccounting size : {} ", allEntities.size());
        return mapper.entitiesToDtoS(allEntities);
    }

    @Override
    @CacheEvict("accounting")
    public void deleteAccountingById(long id) {
        log.info("Service delete by id: {} ", id);
        accountingDAO.deleteAccountingById(id);
    }

    @Override
    @CacheEvict("accounting")
    public void updateCosts(double costs, long id) {
        log.info("Service update cost for id : {} , cost : {} ", id, costs);
        accountingDAO.updateCosts(costs, id);
    }


}
