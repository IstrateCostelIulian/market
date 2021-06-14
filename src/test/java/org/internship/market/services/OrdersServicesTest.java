package org.internship.market.services;

import org.internship.market.database.dao.AccountingDAO;
import org.internship.market.database.dao.CustomerDAO;
import org.internship.market.database.dao.OrdersDAO;
import org.internship.market.database.dao.ProductDAO;
import org.internship.market.database.entity.AccountingEntity;
import org.internship.market.database.entity.CustomerEntity;
import org.internship.market.database.entity.OrdersEntity;
import org.internship.market.database.entity.ProductEntity;
import org.internship.market.dto.CustomerDTO;
import org.internship.market.dto.OrdersDTO;
import org.internship.market.services.impl.OrdersServicesImpl;
import org.internship.market.services.mapper.CustomerMapper;
import org.internship.market.services.mapper.OrderMapper;
import org.internship.market.services.mapper.ProductMapper;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class OrdersServicesTest {

    @Mock
    OrdersDAO ordersDAO;
    @Mock
    ProductDAO productDAO;
    @Mock
    OrderMapper orderMapper;
    @Mock
    AccountingDAO accountingDAO;
    @Mock
    CustomerDAO customerDAO;
    @Mock
    CustomerMapper customerMapper;
    @Mock
    ProductMapper productMapper;

    @InjectMocks
    OrdersServicesImpl services;

   @AfterEach
   void tearDown() {
        verifyNoMoreInteractions(ordersDAO, productDAO, orderMapper,
                accountingDAO, customerDAO, customerMapper, productMapper);
    }

    @Test
    void shouldInsertOrder() {
        CustomerEntity customerFound = new CustomerEntity();
        ProductEntity productFound = new ProductEntity();
        productFound.setStock(2);
        productFound.setPrice(10);
        productFound.setName("cds");
        OrdersDTO ordersDTO = new OrdersDTO();
        CustomerDTO customerDTO = new CustomerDTO();
        customerDTO.setEmailAddress("abc");
        ordersDTO.setCustomer(customerDTO);
        ordersDTO.setProductName("cde");
        ordersDTO.setQuantity(1);
        AccountingEntity accountingFound = new AccountingEntity();
        accountingFound.setEconomicBalance(12.2);
        accountingFound.setIncome(12);

        when(customerDAO.findByEmail("abc")).thenReturn(customerFound);
        when(productDAO.findProductByName("cde")).thenReturn(productFound);
        when(accountingDAO.getAll()).thenReturn(Collections.singletonList(accountingFound));

        services.insertOrder(ordersDTO);

        verify(productDAO).findProductByName("cde");
        verify(customerDAO).findByEmail("abc");
        verify(accountingDAO).getAll();
        verify(ordersDAO).createOrder(any());
        verify(productDAO).updateStock(1,productFound.getName());
        verify(accountingDAO).updateIncome(22);
        verify(accountingDAO).updateEconomicBalanceByIncome(accountingFound.getEconomicBalance());
    }
}
