package org.internship.market.controller;

import org.internship.market.dto.AccountingDTO;
import org.internship.market.services.AccountingServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AccountingController {

    private final AccountingServices accountingServices;

    @Autowired
    public AccountingController(AccountingServices accountingServices) {
        this.accountingServices = accountingServices;
    }


    @PostMapping("/accounting")
    public ResponseEntity insertAccounting(@RequestBody AccountingDTO accountingDTO) {
        accountingServices.insert(accountingDTO);
        return ResponseEntity.ok("Entity inserted with success !");
    }

    @GetMapping(path = "/accounting")
    public List<AccountingDTO> geAll() {
        return accountingServices.getAllAccounting();
    }

    @GetMapping(path = "/accounting/{id}")
    public AccountingDTO getById(@PathVariable long id) {
        return accountingServices.getAccountingById(id);
    }

    @DeleteMapping(path = "/accounting/{id}")
    public ResponseEntity deleteAccountingById(@PathVariable long id) {
        if (accountingServices.getAccountingById(id) == null) {
            return ResponseEntity.ok("Entity not found !");
        } else {
            accountingServices.deleteAccountingById(id);
            return ResponseEntity.ok("Entity deleted with success !");
        }
    }

    @PutMapping(path = "/accounting/{id}")
    public ResponseEntity updateCosts(@RequestParam double costs, @PathVariable long id) {
        if (accountingServices.getAccountingById(id) == null) {
            return ResponseEntity.ok("The entity not found");
        } else {
            accountingServices.updateCosts(costs, id);
            return ResponseEntity.ok("Updated with success !");
        }
    }
}
