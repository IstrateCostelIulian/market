package org.internship.market.database.dao;

import org.internship.market.database.entity.CustomerEntity;

import java.util.List;

public interface CustomerDAO {

    void createCustomer(CustomerEntity customerEntity);

    CustomerEntity findByName(String name);

    void deleteByName(String name);

    void deleteByEmail(String email);

    List<CustomerEntity> findAll();

    void deleteALL();

    CustomerEntity findByEmail(String email);

}
