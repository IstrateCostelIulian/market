package org.internship.market.database.entity;


import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

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
@Getter
@Setter
@ToString
@EqualsAndHashCode
@Entity
@Table(name = "products")
public class ProductEntity {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "name")
    private String name;

    @ManyToMany(cascade = { CascadeType.ALL }, fetch = FetchType.EAGER)
    @JoinTable(
            name = "products_raw_materials",
            joinColumns = { @JoinColumn(name = "product_id") },
            inverseJoinColumns = { @JoinColumn(name = "raw_materials_id") }
    )
    private List<RawMaterialEntity> rawMaterialsList;

    @Column(name = "commercial_excess")
    private double commercial_excess;

    @Column(name = "price")
    private double price;

    @OneToMany(mappedBy = "productEntity")
    private List<OrdersEntity> ordersEntityList;
}
