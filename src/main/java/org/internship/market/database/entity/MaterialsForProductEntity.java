package org.internship.market.database.entity;

import javax.persistence.*;

@Entity
@Table(name = "materials_for_product")
public class MaterialsForProductEntity {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @OneToMany
    private RawMaterialEntity rawMaterialEntity;
    @Column(name = "quantity")
    private int quantity;

    public MaterialsForProductEntity(RawMaterialEntity rawMaterialEntity, int quantity) {
        this.rawMaterialEntity = rawMaterialEntity;
        this.quantity = quantity;
    }

    public MaterialsForProductEntity() {
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

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
