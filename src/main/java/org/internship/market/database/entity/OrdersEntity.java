package org.internship.market.database.entity;


import javax.persistence.*;

@Entity
@Table(name = "orders")
public class OrdersEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name = "command_number")
    private int command_number;
    @Column(name = "amount")
    private int amount;
    @Column(name = "price")
    private  double price;
    @Column(name = "status")
    private String status;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "customer_id")
    private CustomerEntity customerEntity;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "product_id")
    private ProductEntity productEntity;

    public OrdersEntity(int command_number, int amount, double price, String status, CustomerEntity customerEntity, ProductEntity productEntity) {
        this.command_number = command_number;
        this.amount = amount;
        this.price = price;
        this.status = status;
        this.customerEntity = customerEntity;
        this.productEntity = productEntity;
    }

    public OrdersEntity() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

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
