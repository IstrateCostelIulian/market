package org.internship.market.database.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "accounting")
@NamedQueries({
        @NamedQuery(name = "HQL_GET_BY_ID",
                query = "from AccountingEntity where id=:id"),
        @NamedQuery(name = "deleteAccountingById",
                query = "delete AccountingEntity accountingEntity  where id=:id"),
        @NamedQuery(name = "updateCosts",
                query = "update AccountingEntity accountEntity set costs=:costs where id=:id")
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

    public AccountingEntity(double income, double costs, double economic_balance, Date date) {
        this.income = income;
        this.costs = costs;
        this.economic_balance = economic_balance;
        this.date = date;
    }

    public AccountingEntity() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public double getIncome() {
        return income;
    }

    public void setIncome(double income) {
        this.income = income;
    }

    public double getCosts() {
        return costs;
    }

    public void setCosts(double costs) {
        this.costs = costs;
    }

    public double getEconomic_balance() {
        return economic_balance;
    }

    public void setEconomic_balance(double economic_balance) {
        this.economic_balance = economic_balance;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

}
