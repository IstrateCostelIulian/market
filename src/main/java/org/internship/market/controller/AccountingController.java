package org.internship.market.controller;

import lombok.extern.slf4j.Slf4j;
import org.internship.market.dto.AccountingDTO;
import org.internship.market.services.AccountingServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/accounting")
@Slf4j
public class AccountingController {

    private final AccountingServices accountingServices;

    @Autowired
    public AccountingController(AccountingServices accountingServices) {
        this.accountingServices = accountingServices;
    }


    @PostMapping
    public ResponseEntity insertAccounting(@RequestBody AccountingDTO accountingDTO) {
        log.info("insert accounting : {} ", accountingDTO.toString());
        accountingServices.insert(accountingDTO);
        return ResponseEntity.ok("Entity inserted with success !");
    }

    @GetMapping
    public List<AccountingDTO> geAll() {
        log.info("accounting get all");
        return accountingServices.getAllAccounting();
    }

    @GetMapping(path = "/{id}")
    public AccountingDTO getById(@PathVariable long id) {
        log.info("find accounting by id : {} ", id);
        return accountingServices.getAccountingById(id);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity deleteAccountingById(@PathVariable long id) {
        log.info("delete accounting by id : {} ", id);
        if (accountingServices.getAccountingById(id) == null) {
            return ResponseEntity.ok("Entity not found !");
        } else {
            accountingServices.deleteAccountingById(id);
            return ResponseEntity.ok("Entity deleted with success !");
        }
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity updateCosts(@RequestParam double costs, @PathVariable long id) {
        log.info("update cost accounting by id : {}  , costs : {}", id, costs);
        if (accountingServices.getAccountingById(id) == null) {
            return ResponseEntity.ok("The entity not found");
        } else {
            accountingServices.updateCosts(costs, id);
            return ResponseEntity.ok("Updated with success !");
        }
    }
}
