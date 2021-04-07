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

    private CustomerEntity customerEntity;

}
