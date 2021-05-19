package org.internship.market.database.dao;

import org.internship.market.database.entity.CustomerEntity;

import java.util.List;

public interface CustomerDAO {

    void createCustomer(CustomerEntity customerEntity);

    CustomerEntity findByName(String name);

    void deleteByName(String name);

    List<CustomerEntity> findAll();
}
