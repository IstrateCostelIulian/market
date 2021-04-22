package org.internship.market.controller;

import org.internship.market.dto.AccountingDTO;
import org.internship.market.services.AccountingServices;
import org.internship.market.services.impl.AccountingServicesImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(name = "/accounting")
public class AccountingController {

    private final AccountingServices accountingServices;

    @Autowired
    public AccountingController(AccountingServices accountingServices) {
        this.accountingServices = accountingServices;
    }


    @PostMapping
    public void insertAccounting(@RequestBody AccountingDTO accountingDTO) {
        accountingServices.insert(accountingDTO);
    }


}
