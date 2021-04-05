package org.internship.market.database.entity;

import javax.persistence.*;

@Entity
@Table(name = "products")
public class ProductEntity {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "raw_material_id")
    private RawMaterialEntity rawMaterialEntity;
    @Column(name = "commercial_excess")
    private double commercial_excess;
    @Column(name = "price")
    private double price;

    public ProductEntity(RawMaterialEntity rawMaterialEntity, double commercial_excess, double price) {
        this.rawMaterialEntity = rawMaterialEntity;
        this.commercial_excess = commercial_excess;
        this.price = price;
    }

    public ProductEntity() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public RawMaterialEntity getRawMaterialEntity() {
        return rawMaterialEntity;
    }

    public void setRawMaterialEntity(RawMaterialEntity rawMaterialEntity) {
        this.rawMaterialEntity = rawMaterialEntity;
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
