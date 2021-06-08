package org.internship.market.services;

import org.internship.market.database.dao.AccountingDAO;
import org.internship.market.database.dao.CustomerDAO;
import org.internship.market.database.dao.OrdersDAO;
import org.internship.market.database.dao.ProductDAO;
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

import static org.mockito.Mockito.verifyNoMoreInteractions;

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

    }
}
