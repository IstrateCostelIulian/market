package org.internship.market.services.impl;

import org.internship.market.database.dao.CustomerDAO;
import org.internship.market.database.entity.CustomerEntity;
import org.internship.market.dto.CustomerDTO;
import org.internship.market.services.CustomerService;
import org.internship.market.services.mapper.CustomerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    private final CustomerMapper customerMapper;
    private final CustomerDAO customerDAO;

    @Autowired
    public CustomerServiceImpl(CustomerMapper customerMapper, CustomerDAO customerDAO) {
        this.customerMapper = customerMapper;
        this.customerDAO = customerDAO;
    }

    @Override
    public void createCustomer(CustomerDTO customerDTO) {
        CustomerEntity foundCustomer = customerDAO.findByEmail(customerDTO.getEmailAddress());
        if (foundCustomer == null) {
            CustomerEntity customerEntity = customerMapper.dtoToEntity(customerDTO);
            customerDAO.createCustomer(customerEntity);
        }
    }

    @Override
    public void deleteByEmail(String emailAddress) {
        customerDAO.deleteByEmail(emailAddress);
    }

    @Override
    public List<CustomerDTO> findAll() {
        List<CustomerEntity> customerEntityList = customerDAO.findAll();
        return customerMapper.entitiesToDtoS(customerEntityList);
    }

    @Override
    public void deleteALL() {
        customerDAO.deleteALL();
    }

    @Override
    public CustomerDTO findByEmail(String emailAddress) {
        CustomerEntity customerEntity = customerDAO.findByEmail(emailAddress);
        return customerMapper.entityToDto(customerEntity);
    }

    @Override
    public CustomerDTO findByPhoneNumber(String phoneNumber) {
        CustomerEntity customerEntity = customerDAO.findByPhoneNumber(phoneNumber);
        return customerMapper.entityToDto(customerEntity);
    }

    @Override
    public void updateNameAndSurname(String name, String surname, String emailAddress) {
        customerDAO.updateNameAndSurname(name, surname, emailAddress);
    }

    @Override
    public void updatePhoneNumber(String phoneNumber, String emailAddress) {
        customerDAO.updatePhoneNumber(phoneNumber, emailAddress);
    }

    @Override
    public void updateAddress(String address, String emailAddress) {
        customerDAO.updateAddress(address, emailAddress);
    }

    @Override
    public void updateEmail(String emailAddress, String phoneNumber) {
        customerDAO.updateEmail(emailAddress, phoneNumber);
    }
}
