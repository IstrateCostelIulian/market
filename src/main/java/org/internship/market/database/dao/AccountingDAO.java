package org.internship.market.database.dao;

import org.internship.market.database.entity.AccountingEntity;

import java.util.List;

public interface AccountingDAO {

    void save(AccountingEntity accountingEntity);

    AccountingEntity getAccountingById(long id);

    List<AccountingEntity> getAll();

    void deleteAccountingById(long id);

    void updateCosts(double costs, long id);
}
