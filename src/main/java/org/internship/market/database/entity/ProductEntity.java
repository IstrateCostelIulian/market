package org.internship.market.database.entity;

import com.sun.xml.bind.v2.TODO;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "products")
public class ProductEntity {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @OneToMany(mappedBy = "productEntity", cascade = CascadeType.ALL)
    private List<RawMaterialEntity> rawMaterialEntities;
    @Column(name = "commercial_excess")
    private double commercial_excess;
    @Column(name = "price")
    private double price;
    @OneToMany(mappedBy = "productEntity", cascade = CascadeType.ALL)
    private List<OrdersEntity> ordersEntityList;


    public ProductEntity(double commercial_excess, double price) {
        this.commercial_excess = commercial_excess;
        this.price = price;
    }

    public ProductEntity() {
    }

    public List<OrdersEntity> getOrdersEntityList() {
        return ordersEntityList;
    }

    public void setOrdersEntityList(List<OrdersEntity> ordersEntityList) {
        this.ordersEntityList = ordersEntityList;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public List<RawMaterialEntity> getRawMaterialEntities() {
        return rawMaterialEntities;
    }

    public void setRawMaterialEntities(List<RawMaterialEntity> rawMaterialEntities) {
        this.rawMaterialEntities = rawMaterialEntities;
    }

    public double getCommercial_excess() {
        return commercial_excess;
    }

    public void setCommercial_excess(double commercial_excess) {
        this.commercial_excess = commercial_excess;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
