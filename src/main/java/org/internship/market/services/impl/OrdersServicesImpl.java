package org.internship.market.services.impl;

import org.internship.market.database.dao.AccountingDAO;
import org.internship.market.database.dao.OrdersDAO;
import org.internship.market.database.dao.ProductDAO;
import org.internship.market.database.entity.AccountingEntity;
import org.internship.market.database.entity.CustomerEntity;
import org.internship.market.database.entity.OrdersEntity;
import org.internship.market.database.entity.ProductEntity;
import org.internship.market.dto.OrdersDTO;
import org.internship.market.services.OrdersServices;
import org.internship.market.services.mapper.OrderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class OrdersServicesImpl implements OrdersServices {


    private final OrdersDAO ordersDAO;
    private final ProductDAO productDAO;
    private final OrderMapper orderMapper;
    private final AccountingDAO accountingDAO;

    @Autowired
    public OrdersServicesImpl(OrdersDAO ordersDAO, ProductDAO productDAO, OrderMapper orderMapper,
                              AccountingDAO accountingDAO) {
        this.ordersDAO = ordersDAO;
        this.productDAO = productDAO;
        this.orderMapper = orderMapper;
        this.accountingDAO = accountingDAO;
    }


    @Override
    @Transactional
    public void insertOrder(OrdersDTO ordersDTO) {
        OrdersEntity ordersEntity = new OrdersEntity();
        CustomerEntity customerEntity = new CustomerEntity();
        ordersEntity.setDate(ordersDTO.getDate());
        ordersEntity.setPrice(ordersDTO.getPrice());
        ordersEntity.setQuantity(ordersDTO.getQuantity());
        customerEntity.setName(ordersDTO.getCustomer().getName());
        customerEntity.setSurname(ordersDTO.getCustomer().getSurname());
        customerEntity.setAddress(ordersDTO.getCustomer().getAddress());
        customerEntity.setEmailAddress(ordersDTO.getCustomer().getEmailAddress());
        customerEntity.setPhoneNumber(ordersDTO.getCustomer().getPhoneNumber());
        ordersEntity.setCustomer(customerEntity);

        ProductEntity productEntity = productDAO.findProductByName(ordersDTO.getProductName());

        ordersDAO.createOrder(ordersEntity);

        int newStock = productEntity.getStock() - ordersDTO.getQuantity();
        productDAO.updateStock(newStock, productEntity.getName());

        AccountingEntity accountingEntity = accountingDAO.getAll().get(0);
        double newIncome = accountingEntity.getIncome() + ordersDTO.getPrice();

        accountingDAO.updateIncome(newIncome);

    }

    @Override
    public OrdersDTO findOrderByNumber(long orderNUmber) {
        OrdersEntity entity = ordersDAO.findOrderByNumber(orderNUmber);
        return orderMapper.orderEntityToOrderDTO(entity);
    }

    @Override
    public List<OrdersDTO> getAll() {
        List<OrdersEntity> ordersEntities = ordersDAO.getAll();
        return orderMapper.ordersToOderDtoS(ordersEntities);
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


