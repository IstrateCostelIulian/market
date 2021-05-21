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

    @Autowired
    CustomerMapper customerMapper;

    @Autowired
    CustomerDAO customerDAO;

    @Override
    public void createCustomer(CustomerDTO customerDTO) {
        CustomerEntity foundCustomer = customerDAO.findByEmail(customerDTO.getEmailAddress());
        if (foundCustomer == null) {
            CustomerEntity customerEntity = customerMapper.dtoToEntity(customerDTO);
            customerDAO.createCustomer(customerEntity);
        }
    }

    @Override
    public CustomerDTO findByName(String name) {
        CustomerEntity customerEntity = customerDAO.findByName(name);
        return customerMapper.entityToDto(customerEntity);
    }


    @Override
    public void deleteByName(String name) {
        customerDAO.deleteByName(name);
    }

    @Override
    public void deleteByEmail(String email) {
        customerDAO.deleteByEmail(email);
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
    public CustomerDTO findByEmail(String email) {
        CustomerEntity customerEntity = customerDAO.findByName(email);
        return customerMapper.entityToDto(customerEntity);
    }
}
