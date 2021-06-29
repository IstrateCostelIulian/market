package market.services;

import market.dto.CustomerDTO;

import java.util.List;

public interface CustomerService {

    void createCustomer(CustomerDTO customerDTO);

    void deleteByEmail(String email);

    List<CustomerDTO> findAll();

    void deleteALL();

    CustomerDTO findByEmail(String email);

    CustomerDTO findByPhoneNumber(String phoneNumber);

    void updateNameAndSurname(String name, String surname, String emailAddress);

    void updatePhoneNumber(String phoneNumber, String emailAddress);

    void updateAddress(String address, String emailAddress);

    void updateEmail(String emailAddress, String phoneNumber);


}
