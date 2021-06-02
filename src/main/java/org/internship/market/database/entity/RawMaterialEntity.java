package org.internship.market.database.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@NamedQueries({
        @NamedQuery(
                name = "findRawMaterialByName",
                query = "select rawMaterialEntity from  RawMaterialEntity rawMaterialEntity where name=:name"
        ),
        @NamedQuery(
                name = "getAllRawMaterials",
                query = "from RawMaterialEntity"
        ),
        @NamedQuery(
                name = "updateRawMaterialsPrice",
                query = "update RawMaterialEntity rawMaterialsEntity set price=:price where name=:name"
        ),
        @NamedQuery(
                name = "updateRawMaterialStock",
                query = "update RawMaterialEntity rawMaterialsEntity set stock=:stock where name=:name"
        ),
        @NamedQuery(
                name = "deleteRawMaterialByName",
                query = "delete RawMaterialEntity rawMaterialsEntity where name=:name"
        )
})
@Getter
@Setter
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

    @ManyToMany(mappedBy = "rawMaterialsList", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<ProductEntity> productEntities = new ArrayList<>();

    @Column(name = "price", nullable = false, precision = 2)
    private double price; // for 1 gram

    @Column(name = "quantity", nullable = false)
    private double quantity;

    @Column(name = "stock")
    private double stock;

}
