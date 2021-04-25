package org.internship.market.database.entity;

import javax.persistence.*;
import java.util.List;

@NamedQueries(
        @NamedQuery(
                name = "findRawMaterialByName",
                query = "select rawMaterialEntity from  RawMaterialEntity rawMaterialEntity where name=:name"
        )
)

@Entity
@Table(name = "raw_materials")
public class RawMaterialEntity {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "name", length = 50, nullable = false)
    private String name;

    @OneToMany(mappedBy = "rawMaterialEntity", fetch = FetchType.LAZY)
    private List<ProductEntity> productEntities;

    @Column(name = "price", nullable = false, precision = 2)
    private double price;


    public RawMaterialEntity(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public RawMaterialEntity() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<ProductEntity> getProductEntities() {
        return productEntities;
    }

    public void setProductEntities(List<ProductEntity> productEntities) {
        this.productEntities = productEntities;
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
