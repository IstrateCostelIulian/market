package org.internship.market.services;

import org.internship.market.dto.CustomerDTO;

import java.util.List;

public interface CustomerService {

    void createCustomer(CustomerDTO customerDTO);

    CustomerDTO findByName(String name);

    void deleteByName(String name);

    void deleteByEmail(String email);

    List<CustomerDTO> findAll();

    void deleteALL();

    CustomerDTO findByEmail(String email);


}
