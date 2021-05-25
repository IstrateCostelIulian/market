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

        @NamedQuery(
                name = "deleteAccounting",
                query = "delete AccountingEntity accountingEntity"),
        @NamedQuery(
                name = "updateCosts",
                query = "update AccountingEntity accountEntity set costs=:costs where costs >= 0"),
        @NamedQuery(
                name = "getAll",
                query = "from AccountingEntity"),
        @NamedQuery(
                name = "updateIncome",
                query = "update AccountingEntity accountEntity set income=:income where income >= 0"
        ),
        @NamedQuery(
                name = "updateEconomicBalanceByCosts",
                query = "update AccountingEntity accountEntity set economicBalance=:economicBalance - costs " +
                        "where economicBalance >= 0"
        ),
        @NamedQuery(
                name = "updateEconomicBalanceByIncome",
                query = "update AccountingEntity accountEntity set economicBalance=:economicBalance + income " +
                        "where economicBalance >= 0"
        )
})
public class AccountingEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private long id;

    @Column(name = "income", nullable = false, precision = 2)
    private double income;

    @Column(name = "costs", nullable = false, precision = 2)
    private double costs;

    @Column(name = "economic_balance", nullable = false, precision = 2)
    private double economicBalance;

    @Column(name = "date", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date date;

}
