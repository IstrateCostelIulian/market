package org.internship.market.database.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@NamedQueries(
        @NamedQuery(
                name = "findRawMaterialByName",
                query = "select rawMaterialEntity from  RawMaterialEntity rawMaterialEntity where name=:name"
        )
)
@Getter
@Setter
@ToString
@EqualsAndHashCode
@Entity
@Table(name = "raw_materials")
public class RawMaterialEntity {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "name", length = 50, nullable = false)
    private String name;

    @ManyToMany(mappedBy = "rawMaterialsList", fetch = FetchType.LAZY)
    private List<ProductEntity> productEntities;

    @Column(name = "price", nullable = false, precision = 2)
    private double price; // for 1 gram

    @Column(name = "quantity")
    private double quantity;

    @Column(name = "stock")
    private  int stock;

}
