package org.internship.market.services.impl;

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
import org.internship.market.dto.ProductDTO;
import org.internship.market.services.OrdersServices;
import org.internship.market.services.mapper.CustomerMapper;
import org.internship.market.services.mapper.OrderMapper;
import org.internship.market.services.mapper.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

@Service
public class OrdersServicesImpl implements OrdersServices {


    private final OrdersDAO ordersDAO;
    private final ProductDAO productDAO;
    private final OrderMapper orderMapper;
    private final AccountingDAO accountingDAO;
    private final CustomerDAO customerDAO;
    private final CustomerMapper customerMapper;
    private final ProductMapper productMapper;

    @Autowired
    public OrdersServicesImpl(OrdersDAO ordersDAO, ProductDAO productDAO, OrderMapper orderMapper,
                              AccountingDAO accountingDAO, CustomerDAO customerDAO, CustomerMapper customerMapper,
                              ProductMapper productMapper) {
        this.ordersDAO = ordersDAO;
        this.productDAO = productDAO;
        this.orderMapper = orderMapper;
        this.accountingDAO = accountingDAO;
        this.customerDAO = customerDAO;
        this.customerMapper = customerMapper;
        this.productMapper = productMapper;
    }


    @Override
    public void insertOrder(OrdersDTO ordersDTO) {

        OrdersEntity ordersEntity = new OrdersEntity();
        ordersEntity.setDate(ordersDTO.getDate());
        ordersEntity.setQuantity(ordersDTO.getQuantity());

        ordersEntity.setOrderNumber(orderNumberGenerator());

        setCustomerOnOrder(ordersDTO, ordersEntity);

        ProductEntity productEntity = productDAO.findProductByName(ordersDTO.getProductName());
        ordersEntity.setProduct(productEntity);
        ordersEntity.setPrice(orderPrice(ordersDTO, productEntity));
        ordersDAO.createOrder(ordersEntity);

        int newStock = productEntity.getStock() - ordersDTO.getQuantity();
        productDAO.updateStock(newStock, productEntity.getName());

        updateIncomeByOrder(ordersEntity);
    }

    private int orderNumberGenerator() {
        Random random = new Random();
        return random.nextInt(Integer.MAX_VALUE);
    }

    private void updateIncomeByOrder(OrdersEntity ordersEntity) {
        AccountingEntity accountingEntity = accountingDAO.getAll().get(0);
        double newIncome = accountingEntity.getIncome() + ordersEntity.getPrice();
        accountingDAO.updateIncome(newIncome);
        accountingDAO.updateEconomicBalanceByIncome(accountingEntity.getEconomicBalance());
    }

    private void setCustomerOnOrder(OrdersDTO ordersDTO, OrdersEntity ordersEntity) {
        CustomerEntity customerFound = customerDAO.findByEmail(ordersDTO.getCustomer().getEmailAddress());
        if (customerFound == null) {
            CustomerEntity customerEntity = new CustomerEntity();
            customerEntity.setName(ordersDTO.getCustomer().getName());
            customerEntity.setSurname(ordersDTO.getCustomer().getSurname());
            customerEntity.setAddress(ordersDTO.getCustomer().getAddress());
            customerEntity.setEmailAddress(ordersDTO.getCustomer().getEmailAddress());
            customerEntity.setPhoneNumber(ordersDTO.getCustomer().getPhoneNumber());
            ordersEntity.setCustomer(customerEntity);
        } else {
            ordersEntity.setCustomer(customerFound);
        }
    }

    private double orderPrice(OrdersDTO ordersDTO, ProductEntity product) {
        double price = ordersDTO.getQuantity() + product.getPrice();
        return price;
    }

    @Override
    public OrdersDTO findOrderByNumber(long orderNUmber) {
        OrdersEntity entity = ordersDAO.findOrderByNumber(orderNUmber);
        OrdersDTO ordersDTO = orderMapper.orderEntityToOrderDTO(entity);
        ordersDTO.setProductName(entity.getProduct().getName());
        return ordersDTO;
    }

    // in progress
    @Override
    public List<OrdersDTO> getAll() {
        List<OrdersEntity> ordersEntities = ordersDAO.getAll();
        List<OrdersDTO> ordersDTOS = new LinkedList<>();
        for (OrdersEntity ordersEntity : ordersEntities) {
            OrdersDTO ordersDTO = new OrdersDTO();
            CustomerDTO customerDTO = customerMapper.entityToDto(ordersEntity.getCustomer());
            ProductDTO productDTO = productMapper.entityToDTO(ordersEntity.getProduct());
            ordersDTO.setProductName(productDTO.getName());
            ordersDTO.setCustomer(customerDTO);
            ordersDTO.setDate(ordersEntity.getDate());
            ordersDTO.setPrice(ordersEntity.getPrice());
            ordersDTO.setQuantity(ordersEntity.getQuantity());
            ordersDTO.setOrderNumber(ordersEntity.getOrderNumber());
            ordersDTOS.add(ordersDTO);
        }
        return ordersDTOS;
    }

    @Override
    public void deleteOrderByNumber(long orderNUmber) {
        ordersDAO.deleteOrderByNumber(orderNUmber);
    }

    @Override
    public void deleteAllOrders() {
        ordersDAO.deleteAllOrders();
    }

    @Override
    public void updateOrderPrice(double price, long orderNumber) {
        ordersDAO.updateOrderPrice(price, orderNumber);
    }

    @Override
    public void updateOrderStatus(String status, long orderNumber) {
        ordersDAO.updateOrderStatus(status, orderNumber);
    }

    @Override
    public void updateOrderQuantity(int quantity, long orderNumber) {
        ordersDAO.updateOrderQuantity(quantity, orderNumber);
    }
}


