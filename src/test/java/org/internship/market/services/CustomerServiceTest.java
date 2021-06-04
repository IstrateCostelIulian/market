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

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class CustomerServiceTest {
    private final String email = "test@gmail.com";

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
}
