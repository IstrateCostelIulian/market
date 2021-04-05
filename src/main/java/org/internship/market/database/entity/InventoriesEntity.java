package org.internship.market.database.entity;

import javax.persistence.*;

@Entity
@Table(name =  "inventories")
public class InventoriesEntity {

    @Column(name = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @OneToMany(mappedBy = "inventories")
    private ProductEntity product;

    @Column(name = "quantity", nullable = false)
    private int quantity;

    public InventoriesEntity(ProductEntity product, int quantity) {
        this.product = product;
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
