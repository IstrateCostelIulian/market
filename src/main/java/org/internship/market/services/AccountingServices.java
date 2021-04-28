package org.internship.market.services;

import org.internship.market.dto.AccountingDTO;

import java.util.List;

public interface AccountingServices {

    void insert(AccountingDTO accountingDTO);

    AccountingDTO getAccountingById(long id);

    List<AccountingDTO> getAllAccounting();

    void deleteAccountingById(long id);

    void updateCosts(double costs, long id);
}
