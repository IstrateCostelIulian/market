package org.internship.market.database.entity;

import javax.persistence.*;

@Entity
@Table(name = "raw_materials")
public class RawMaterialEntity {

    @Id
    @Column(name = "id")
    @GeneratedValue
    int id;

    @Column(name = "name", length = 50, nullable = false)
    String name;

    @Column(name = "price", nullable = false, precision = 2)
    double price;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
