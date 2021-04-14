package org.internship.market.database.entity;

import javax.persistence.*;

@Entity
@Table(name =  "inventories")
public class InventoriesEntity {


    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private ProductEntity product;

    private RawMaterialEntity rawMaterialEntity;

    @Column(name = "quantity", nullable = false)
    private int quantity;

    public InventoriesEntity(ProductEntity product, RawMaterialEntity rawMaterialEntity, int quantity) {
        this.product = product;
        this.rawMaterialEntity = rawMaterialEntity;
        this.quantity = quantity;
    }

    public InventoriesEntity() {
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

    public ProductEntity getProduct() {
        return product;
    }

    public void setProduct(ProductEntity product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }


}
