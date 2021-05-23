package org.internship.market.database.dao;

import org.internship.market.database.entity.CustomerEntity;

import java.util.List;

public interface CustomerDAO {

    void createCustomer(CustomerEntity customerEntity);

    void deleteByEmail(String email);

    List<CustomerEntity> findAll();

    void deleteALL();

    CustomerEntity findByEmail(String email);

    CustomerEntity findByPhoneNumber(String phoneNumber);

    void updateNameAndSurname(String name, String surname, String emailAddress);

    void updatePhoneNumber(String phoneNumber, String emailAddress);

    void updateAddress(String address, String emailAddress);

    void updateEmail(String emailAddress, String phoneNumber);

}
