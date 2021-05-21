package org.internship.market.controller;

import org.internship.market.dto.CustomerDTO;
import org.internship.market.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping(name = "/customer")
@Controller
public class CustomerController {

    public final CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping
    public ResponseEntity createCustomer(@RequestBody CustomerDTO customerDTO) {
        if (customerService.findByName(customerDTO.getAddress()) == null) {
            customerService.createCustomer(customerDTO);
            return ResponseEntity.ok("Customer created");
        } else {
            return ResponseEntity.ok("Customer already exists");
        }
    }

}
