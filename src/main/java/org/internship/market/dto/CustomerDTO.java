package org.internship.market.dto;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@EqualsAndHashCode
public class CustomerDTO {

    private String name;
    private String surname;
    private String address;
    private String phone_number;
    private String email_address;

}
