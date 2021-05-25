package org.internship.market.database.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@NamedQueries({
        @NamedQuery(

                name = "findOrderByName",
                query = "from OrdersEntity where name=:name"
        ),
        @NamedQuery(
                name = "getAllOrders",
                query = "from OrdersEntity"
        ),

        @NamedQuery(
                name = "deleteAllOrders",
                query = "delete OrdersEntity ordersEntity where name=:name"
        ),
        @NamedQuery(
                name = "updateOrderPrice",
                query = "update OrdersEntity ordersEntity set price=:price where name=:name"
        )
})

@Getter
@Setter
@EqualsAndHashCode
@Entity
@Table(name = "orders")
public class OrdersEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "command_number")
    private int commandNumber;

    @Column(name = "quantity")
    private int quantity;

    @Column(name = "price")
    private double price;

    @Column(name = "status")
    private String status;

    @Column(name = "date", nullable = false)
    private Date date;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "customer_id")
    private CustomerEntity customer;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "product_id")
    private ProductEntity product;

}
