package org.internship.market.services;

import org.internship.market.database.dao.CustomerDAO;
import org.internship.market.database.entity.CustomerEntity;
import org.internship.market.dto.CustomerDTO;
import org.internship.market.services.impl.CustomerServiceImpl;
import org.internship.market.services.mapper.CustomerMapper;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class CustomerServiceTest {
    private final String email = "test@gmail.com";
    private final String phoneNumber = "0747442033";

    @Mock
    CustomerMapper mapper;

    @Mock
    CustomerDAO dao;

    @InjectMocks
    CustomerServiceImpl service;

    @AfterEach
    void tearDown() {
        verifyNoMoreInteractions(mapper, dao);
    }

    @Test
    void shouldNotCreateACustomer() {
        CustomerDTO dto = new CustomerDTO();
        dto.setEmailAddress(email);
        CustomerEntity entity = new CustomerEntity();

        when(dao.findByEmail(email)).thenReturn(entity);

        service.createCustomer(dto);

        verify(dao).findByEmail(email);
        verify(mapper, times(0)).dtoToEntity(dto);
        verify(dao, times(0)).createCustomer(entity);
    }

    @Test
    void shouldCreateACustomer() {
        CustomerDTO dto = new CustomerDTO();
        dto.setEmailAddress(email);
        CustomerEntity entity = new CustomerEntity();

        when(dao.findByEmail(email)).thenReturn(null);
        when(mapper.dtoToEntity(dto)).thenReturn(entity);

        service.createCustomer(dto);

        verify(dao).findByEmail(email);
        verify(mapper).dtoToEntity(dto);
        verify(dao).createCustomer(entity);
    }

    @Test
    void shouldDeleteCustomerByEmail() {
        service.deleteByEmail(email);

        verify(dao).deleteByEmail(email);
    }

    @Test
    void shouldFindAll() {
        List<CustomerDTO> dtoList = Collections.singletonList(new CustomerDTO());
        List<CustomerEntity> entities = Collections.singletonList(new CustomerEntity());

        when(dao.findAll()).thenReturn(entities);
        when(mapper.entitiesToDtoS(entities)).thenReturn(dtoList);

        List<CustomerDTO> list = service.findAll();

        verify(dao).findAll();
        verify(mapper).entitiesToDtoS(entities);

        assertThat(list).isNotEmpty();
    }

    @Test
    void shouldDeleteAll() {
        service.deleteALL();

        verify(dao).deleteALL();
    }

    @Test
    void shouldFindByEmail() {
        CustomerDTO customerDTO = new CustomerDTO();
        customerDTO.setEmailAddress(email);
        CustomerEntity entity = new CustomerEntity();

        when(dao.findByEmail(email)).thenReturn(entity);
        when(mapper.entityToDto(entity)).thenReturn(customerDTO);

        CustomerDTO customer = service.findByEmail(email);

        verify(dao).findByEmail(email);
        verify(mapper).entityToDto(entity);

        assertThat(customer.getEmailAddress()).isEqualTo(email);
    }

    @Test
    void shouldFindByPhoneNumber() {
        CustomerEntity entity = new CustomerEntity();
        CustomerDTO customerDTO = new CustomerDTO();
        customerDTO.setPhoneNumber(phoneNumber);

        when(dao.findByPhoneNumber(phoneNumber)).thenReturn(entity);
        when(mapper.entityToDto(entity)).thenReturn(customerDTO);

        CustomerDTO customer = service.findByPhoneNumber(phoneNumber);

        verify(dao).findByPhoneNumber(phoneNumber);
        verify(mapper).entityToDto(entity);

        assertThat(customer.getPhoneNumber()).isEqualTo(phoneNumber);
    }

    @Test
    void shouldUpdateNameAndSurname() {
        String name = "Snow";
        String surname = "John";

        dao.updateNameAndSurname(name, surname, email);

        verify(dao).updateNameAndSurname(name, surname, email);
    }

    @Test
    void shouldUpdatePhoneNUmber() {
        dao.updatePhoneNumber(phoneNumber, email);

        verify(dao).updatePhoneNumber(phoneNumber, email);
    }

    @Test
    void shouldUpdateAddress() {
        String address = "Bucharest";

        dao.updateAddress(address, email);

        verify(dao).updateAddress(address, email);
    }

    @Test
    void shouldUpdateEmail() {
        dao.updateEmail(email, phoneNumber);

        verify(dao).updateEmail(email, phoneNumber);
    }

}
