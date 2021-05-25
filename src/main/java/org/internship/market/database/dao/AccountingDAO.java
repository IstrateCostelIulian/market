package org.internship.market.database.dao;

import org.internship.market.database.entity.AccountingEntity;

import java.util.List;

public interface AccountingDAO {

    void save(AccountingEntity accountingEntity);

    List<AccountingEntity> getAll();

    void deleteAccounting();

    void updateCosts(double costs);

    void updateIncome(double income);

    public void updateEconomicBalanceByCosts(double economicBalance);

    public void updateEconomicBalanceByIncome();

}
