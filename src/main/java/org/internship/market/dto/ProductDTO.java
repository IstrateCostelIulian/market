package org.internship.market.dto;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
@EqualsAndHashCode
public class ProductDTO {

    private String name;
    private List<RawMaterialDTO> rawMaterialsList;
    private double commercial_excess;
    private double price;
    private int stock;
}
