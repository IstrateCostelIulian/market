package org.internship.market.dto;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.internship.market.database.entity.CustomerEntity;
import org.internship.market.database.entity.ProductEntity;
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class OrdersDTO {

    private int command_number;
    private int amount;
    private  double price;
    private String status;
    private CustomerEntity customerEntity;
    private ProductEntity productEntity;

}
