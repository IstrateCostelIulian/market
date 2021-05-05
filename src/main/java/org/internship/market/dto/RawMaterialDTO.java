package org.internship.market.dto;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@EqualsAndHashCode
public class RawMaterialDTO {

    private String name;
    private double price; // for 1 gram
    private double quantity;
    private int stock;

}
