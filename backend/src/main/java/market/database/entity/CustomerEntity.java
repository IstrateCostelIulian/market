package market.database.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@EqualsAndHashCode
@Entity
@Table(name = "customers")
public class CustomerEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private long id;

    @Column(name = "name", length = 50, nullable = false)
    private String name;

    @Column(name = "surname", length = 50, nullable = false)
    private String surname;

    @Column(name = "address", length = 50, nullable = false)
    private String address;

    @Column(name = "phone_number", unique = true, length = 50, nullable = false)
    private String phoneNumber;

    @Column(name = "email_address", unique = true, nullable = false, length = 50)
    private String emailAddress;

    @OneToMany(mappedBy = "customer")
    private List<OrdersEntity> ordersEntityList;

}
