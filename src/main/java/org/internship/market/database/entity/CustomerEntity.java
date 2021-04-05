package org.internship.market.database.entity;

import javax.persistence.*;

@Entity
@Table(name = "customer")
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

    public CustomerEntity(String name, String surname, String address, String phone_number, String email_address) {
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.phone_number = phone_number;
        this.email_address = email_address;
    }

    public CustomerEntity() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public String getEmail_address() {
        return email_address;
    }

    public void setEmail_address(String email_address) {
        this.email_address = email_address;
    }
}
