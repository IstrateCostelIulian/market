package org.internship.market.dto;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@EqualsAndHashCode
public class OrdersDTO {

    private int commandNumber;
    private int amount;
    private  double price;
    private String customerName;
    private String productName;

}
