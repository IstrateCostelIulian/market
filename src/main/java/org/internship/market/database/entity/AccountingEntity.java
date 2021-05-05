package org.internship.market.database.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@Entity
@Table(name = "accounting")
@NamedQueries({
        @NamedQuery(name = "HQL_GET_BY_ID",
                query = "from AccountingEntity where id=:id"),
        @NamedQuery(name = "deleteAccountingById",
                query = "delete AccountingEntity accountingEntity  where id=:id"),
        @NamedQuery(name = "updateCosts",
                query = "update AccountingEntity accountEntity set costs=:costs where id=:id"),
        @NamedQuery(name="getAll",
                query = "from AccountingEntity")
})
public class AccountingEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private long id;
    @Column(name = "incomme", nullable = false, precision = 2)
    private double income;
    @Column(name = "costs", nullable = false, precision = 2)
    private double costs;
    @Column(name = "economic_balance", nullable = false, precision = 2)
    private double economic_balance;
    @Column(name = "date", nullable = false)
    private Date date;

}
