package market.controller;

import market.dto.CustomerDTO;
import market.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping(value = "/customer")
@RestController
public class CustomerController {

    public final CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping
    public ResponseEntity createCustomer(@RequestBody CustomerDTO customerDTO) {
        if (customerService.findByEmail(customerDTO.getEmailAddress()) == null ||
                customerService.findByPhoneNumber(customerDTO.getPhoneNumber()) == null) {

            customerService.createCustomer(customerDTO);
            return ResponseEntity.ok("Customer created");
        } else {
            return ResponseEntity.ok("Customer already exists");
        }
    }

    @GetMapping(path = "/{email}")
    public CustomerDTO findCustomerByEmail(@RequestParam String emailAddress) {
        return customerService.findByEmail(emailAddress);
    }

    @GetMapping
    public List<CustomerDTO> getAllCustomers() {
        return customerService.findAll();
    }

    @DeleteMapping(path = "/{email}")
    public ResponseEntity deleteByEmail(@RequestParam String emailAddress) {
        if (customerService.findByEmail(emailAddress) == null) {
            return ResponseEntity.ok("Customer with the e-mail address " + emailAddress + " doesn't exists !");
        } else {
            customerService.deleteByEmail(emailAddress);
            return ResponseEntity.ok("Customer deleted !");
        }
    }

    @DeleteMapping
    public ResponseEntity deleteAll() {
        if (customerService.findAll().isEmpty()) {
            return ResponseEntity.ok("No customers found");
        } else {
            customerService.deleteALL();
            return ResponseEntity.ok("All customers deleted!");
        }
    }

    @PutMapping
    public ResponseEntity updateNameAndSurname(@RequestParam String name, @RequestParam String surname, @RequestParam String emailAddress) {
        if (customerService.findByEmail(emailAddress) == null) {
            return ResponseEntity.ok("Customer with the e-mail address " + emailAddress + " doesn't exists !");
        } else {
            customerService.updateNameAndSurname(name, surname, emailAddress);
            return ResponseEntity.ok("Customer name and surname updated !");
        }
    }

    @PutMapping(path = "/updateEmail/{newEmailAddress}")
    public ResponseEntity updateEmail(@RequestParam String newEmailAddress, @RequestParam String phoneNumber) {
        if (customerService.findByPhoneNumber(phoneNumber) == null) {
            return ResponseEntity.ok("Customer with the phoneNumber " + phoneNumber + " doesn't exists !");
        } else {
            customerService.updateEmail(newEmailAddress, phoneNumber);
            return ResponseEntity.ok("Customer e-mail address updated !");
        }
    }

    @PutMapping(path = "/updateAddress/{address}")
    public ResponseEntity updateAddress(@RequestParam String address, @RequestParam String emailAddress) {
        if (customerService.findByEmail(emailAddress) == null) {
            return ResponseEntity.ok("Customer with the e-mail address " + emailAddress + " doesn't exists !");
        } else {
            customerService.updateAddress(address, emailAddress);
            return ResponseEntity.ok("Customer address updated !");
        }
    }

    @PutMapping(path = "updatePhoneNumber/{phoneNumber}")
    public ResponseEntity updatePhoneNumber(@RequestParam String newPhoneNumber, @RequestParam String emailAddress) {
        if (customerService.findByEmail(emailAddress) == null) {
            return ResponseEntity.ok("Customer with the phone number " + newPhoneNumber + " doesn't exists !");
        } else {
            customerService.updatePhoneNumber(newPhoneNumber, emailAddress);
            return ResponseEntity.ok("Customer phone number updated !");
        }
    }

}
