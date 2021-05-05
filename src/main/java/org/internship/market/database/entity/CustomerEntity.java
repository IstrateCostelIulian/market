package org.internship.market.database.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@Entity
@Table(name = "customers")
public class CustomerEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private long id;
    @Column(name = "name", length = 50, nullable = false)
    private String name;
    @Column(name = "surname", length = 50, nullable = false)
    private String surname;
    @Column(name = "address", length = 50, nullable = false)
    private String address;
    @Column(name = "phone_number", unique = true,length = 50, nullable = false)
    private String phone_number;
    @Column(name = "email_address", unique = true, nullable = false, length = 50)
    private String email_address;
    @OneToMany(mappedBy = "customerEntity")
    private List<OrdersEntity> ordersEntityList;

}
