package market.services;

import market.dto.AccountingDTO;

import java.util.List;

public interface AccountingServices {

    void insert(AccountingDTO accountingDTO);

    List<AccountingDTO> getAllAccounting();

    void deleteAccounting();

    void updateCosts(double costs);

    void updateIncome(double income);

}
