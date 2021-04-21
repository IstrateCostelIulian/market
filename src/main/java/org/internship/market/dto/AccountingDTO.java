package org.internship.market.dto;

import java.util.Date;

public class AccountingDTO {

    private double income;
    private double costs;
    private double economic_balance;
    private Date date;

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
