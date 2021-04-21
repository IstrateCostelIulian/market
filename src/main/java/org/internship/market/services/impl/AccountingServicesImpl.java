package org.internship.market.services.impl;

import org.internship.market.database.dao.AccountingDAO;
import org.internship.market.database.entity.AccountingEntity;
import org.internship.market.dto.AccountingDTO;
import org.internship.market.services.AccountingServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountingServicesImpl implements AccountingServices {


    @Autowired
    AccountingDAO accountingDAO;

    @Override
    public void insert(AccountingDTO accountingDTO) {
        AccountingEntity accountingEntity = new AccountingEntity();
        accountingEntity.setCosts(accountingDTO.getCosts());
        accountingEntity.setEconomic_balance(accountingDTO.getEconomic_balance());
        accountingEntity.setIncome(accountingDTO.getIncome());
        accountingEntity.setDate(accountingDTO.getDate());
        accountingDAO.save(accountingEntity);
    }
}
