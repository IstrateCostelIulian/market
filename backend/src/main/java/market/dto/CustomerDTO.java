package market.dto;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode
public class CustomerDTO {

    private String name;
    private String surname;
    private String address;
    private String phoneNumber;
    private String emailAddress;

}
