package org.internship.market.controller;

import org.internship.market.dto.AccountingDTO;
import org.internship.market.services.AccountingServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping(path = "/getById")
    public AccountingDTO getById(@RequestParam long id) {
        return accountingServices.getAccountingById(id);
    }

    @DeleteMapping(path = "/deleteById")
    public ResponseEntity deleteAccountingById(@RequestParam long id){
        if(accountingServices.getAccountingById(id) == null){
            return ResponseEntity.ok("Entity not found !");
        }else {
            accountingServices.deleteAccountingById(id);
            return ResponseEntity.ok("Entity deleted with success !");
        }
    }

    @PutMapping(path = "/updateCosts")
    public ResponseEntity updateCosts(@RequestParam double costs , @RequestParam long id){
        if(accountingServices.getAccountingById(id) == null){
            return ResponseEntity.ok("The entity not found");
        }else{
            accountingServices.updateCosts(costs,id);
            return ResponseEntity.ok("Updated with success !");
        }
    }
}
