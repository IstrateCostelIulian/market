package java.market.services;

import market.database.dao.AccountingDAO;
import market.database.dao.CustomerDAO;
import market.database.dao.OrdersDAO;
import market.database.dao.ProductDAO;
import market.database.entity.AccountingEntity;
import market.database.entity.CustomerEntity;
import market.database.entity.OrdersEntity;
import market.database.entity.ProductEntity;
import market.dto.CustomerDTO;
import market.dto.OrdersDTO;
import market.dto.ProductDTO;
import market.services.impl.OrdersServicesImpl;
import market.services.mapper.CustomerMapper;
import market.services.mapper.OrderMapper;
import market.services.mapper.ProductMapper;
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
        verify(productDAO).updateStock(1, productFound.getName());
        verify(accountingDAO).updateIncome(22);
        verify(accountingDAO).updateEconomicBalanceByIncome(accountingFound.getEconomicBalance());
    }

    @Test
    void shouldReturnOrderByNumber() {
        long orderNumber = 12563l;
        String productName = "chocolate";

        OrdersDTO dto = new OrdersDTO();
        dto.setOrderNumber(orderNumber);

        ProductEntity productEntity = new ProductEntity();
        productEntity.setName(productName);

        OrdersEntity entity = new OrdersEntity();
        entity.setProduct(productEntity);

        when(ordersDAO.findOrderByNumber(orderNumber)).thenReturn(entity);
        when(orderMapper.orderEntityToOrderDTO(entity)).thenReturn(dto);

        OrdersDTO ordersDTO = services.findOrderByNumber(orderNumber);

        verify(ordersDAO).findOrderByNumber(orderNumber);
        verify(orderMapper).orderEntityToOrderDTO(entity);

        assertThat(ordersDTO.getOrderNumber()).isEqualTo(orderNumber);
    }

    @Test
    void shouldReturnAllOrders() {
        String productName = "chocolate";

        List<OrdersEntity> entities = Collections.singletonList(new OrdersEntity());
        List<OrdersDTO> dtoS = Collections.singletonList(new OrdersDTO());

        OrdersEntity ordersEntity = new OrdersEntity();
        ProductEntity productEntity = new ProductEntity();
        ProductDTO productDTO = new ProductDTO();
        CustomerEntity customerEntity = new CustomerEntity();
        CustomerDTO customerDTO = new CustomerDTO();

        ordersEntity.setProduct(productEntity);
        ordersEntity.setCustomer(customerEntity);



        when(ordersDAO.getAll()).thenReturn(entities);
        when(productMapper.entityToDTO(ordersEntity.getProduct())).thenReturn(productDTO);
        when(customerMapper.entityToDto(ordersEntity.getCustomer())).thenReturn(customerDTO);
        when(orderMapper.ordersToOderDtoS(entities)).thenReturn(dtoS);

        List<OrdersDTO> list = services.getAll();

        verify(ordersDAO).getAll();
        verify(orderMapper).ordersToOderDtoS(entities);

        assertThat(list).isNotEmpty();

    }

}
