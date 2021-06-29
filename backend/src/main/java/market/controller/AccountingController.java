package market.controller;

import lombok.extern.slf4j.Slf4j;
import market.dto.AccountingDTO;
import market.services.AccountingServices;
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
        if(accountingServices.getAllAccounting().isEmpty()){
            log.info("insert accounting : {} ", accountingDTO.toString());
            accountingServices.insert(accountingDTO);
            return ResponseEntity.ok("Entity inserted with success !");
        }
        return ResponseEntity.ok("Accounting already exits!");
    }

    @GetMapping
    public List<AccountingDTO> getAll() {
        log.info("accounting get all");
        return accountingServices.getAllAccounting();
    }


    @DeleteMapping
    public ResponseEntity delete(){
        log.info("delete accounting");
        accountingServices.deleteAccounting();
        return ResponseEntity.ok("Accounting deleted!");
    }

    @PutMapping(path = "/{costs}")
    public ResponseEntity updateCosts(@RequestParam double costs) {
        log.info("update cost accounting  costs : {}",  costs);
        if (accountingServices.getAllAccounting() == null) {
            return ResponseEntity.ok("The entity not found");
        } else {
            accountingServices.updateCosts(costs);
            return ResponseEntity.ok("Updated with success !");
        }
    }

    @PutMapping()
    public ResponseEntity updateIncome(@RequestParam double income) {
        log.info("update income accounting income : {}",  income);
        if (accountingServices.getAllAccounting() == null) {
            return ResponseEntity.ok("The entity not found");
        } else {
            accountingServices.updateIncome(income);
            return ResponseEntity.ok("Updated with success !");
        }
    }
}
