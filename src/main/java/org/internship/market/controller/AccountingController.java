package org.internship.market.controller;

import org.internship.market.dto.AccountingDTO;
import org.internship.market.services.AccountingServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class AccountingController {

    private final AccountingServices accountingServices;

    @Autowired
    public AccountingController(AccountingServices accountingServices) {
        this.accountingServices = accountingServices;
    }

    @GetMapping("/accounting/ping")
    public String ping() {
        return "Ping";
    }

    @PostMapping("/accounting")
    public void insertAccounting(@RequestBody AccountingDTO accountingDTO) {
        accountingServices.insert(accountingDTO);
    }

    @GetMapping("/accounting/{id}")
    public AccountingDTO getById(@PathVariable long id) {
        return accountingServices.getAccountingById(id);
    }


}
