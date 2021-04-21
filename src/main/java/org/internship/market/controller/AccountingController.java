package org.internship.market.controller;

import org.internship.market.dto.AccountingDTO;
import org.internship.market.services.impl.AccountingServicesImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountingController {


    private final AccountingServicesImpl accountingServicesImpl;

    @Autowired
    public AccountingController(AccountingServicesImpl accountingServicesImpl) {
        this.accountingServicesImpl = accountingServicesImpl;
    }


    @PostMapping(path = "/insertAccounting")
    public void insertAccounting(@RequestBody AccountingDTO accountingDTO) {
        accountingServicesImpl.insert(accountingDTO);
    }
}
