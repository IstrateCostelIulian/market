package org.internship.market.database.entity;


import javax.persistence.*;
import java.util.List;

@NamedQueries({
        @NamedQuery(
                name = "findProductByName",
                query = "from ProductEntity where name=:name"
        ),

        @NamedQuery(
                name = "getAllProducts",
                query = "from ProductEntity"
        ),

        @NamedQuery(
                name = "deleteProductByName",
                query = "delete ProductEntity productEntity where name=:name"
        ),

        @NamedQuery(
                name = "updateProductPrice",
                query = "update ProductEntity productEntity set price=:price where name=:name"
        )
})
@Entity
@Table(name = "products")
public class ProductEntity {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "name")
    private String name;

    @ManyToOne(targetEntity = RawMaterialEntity.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "materials_for_product_id", referencedColumnName = "id", nullable = false)
    private RawMaterialEntity rawMaterialEntity;

    @Column(name = "commercial_excess")
    private double commercial_excess;

    @Column(name = "price")
    private double price;

    @OneToMany(mappedBy = "productEntity")
    private List<OrdersEntity> ordersEntityList;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setRawMaterialEntity(RawMaterialEntity rawMaterialEntity) {
        this.rawMaterialEntity = rawMaterialEntity;
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

    public RawMaterialEntity getRawMaterialEntity() {
        return rawMaterialEntity;
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
