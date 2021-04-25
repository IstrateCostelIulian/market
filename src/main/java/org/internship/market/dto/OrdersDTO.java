package org.internship.market.dto;

import org.internship.market.database.entity.CustomerEntity;
import org.internship.market.database.entity.ProductEntity;

public class OrdersDTO {

    private int command_number;
    private int amount;
    private  double price;
    private String status;
    private CustomerEntity customerEntity;
    private ProductEntity productEntity;

    public int getCommand_number() {
        return command_number;
    }

    public void setCommand_number(int command_number) {
        this.command_number = command_number;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public CustomerEntity getCustomerEntity() {
        return customerEntity;
    }

    public void setCustomerEntity(CustomerEntity customerEntity) {
        this.customerEntity = customerEntity;
    }

    public ProductEntity getProductEntity() {
        return productEntity;
    }

    public void setProductEntity(ProductEntity productEntity) {
        this.productEntity = productEntity;
    }
}
