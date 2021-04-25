package org.internship.market.dto;

import org.internship.market.database.entity.RawMaterialEntity;

public class ProductDTO {

    private String name;
    private RawMaterialDTO rawMaterialDTO;
    private double commercial_excess;
    private double price;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public RawMaterialDTO getRawMaterialDTO() {
        return rawMaterialDTO;
    }

    public void setRawMaterialDTO(RawMaterialDTO rawMaterialDTO) {
        this.rawMaterialDTO = rawMaterialDTO;
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
