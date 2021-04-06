package org.internship.market.database.entity;

import javax.persistence.*;

@Entity
@Table(name = "materials_for_product")
public class MaterialsForProductEntity {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

   // private RawMaterialEntity rawMaterialEntity;
    @Column(name = "quantity")
    private int quantity;


}
