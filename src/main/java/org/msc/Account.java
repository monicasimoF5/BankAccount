package org.msc;

public class Account {
    private float balance;
    private int numConsignments;
    private int numWithdrawals;
    private float annualRate;
    private float monthlyCommission;

    public Account(float initialBalance, int numConsignments) {
        this.balance = initialBalance;
        this.numConsignments = numConsignments;
        this.numWithdrawals = 0;
        this.annualRate = 0;
        this.monthlyCommission = 0;
    }

    public void record(float amount){
        if (amount > 0) {
            balance += amount;
            numConsignments++;
        } else{
        numConsignments++;}
    }

    public float getBalance() {
        return balance;
    }

    public void setBalance(float balance) {
        this.balance = balance;
    }

    public int getNumConsignments() {
        return numConsignments;
    }

    public void setNumConsignments(int numConsignments) {
        this.numConsignments = numConsignments;
    }

    public int getNumWithdrawals() {
        return numWithdrawals;
    }

    public void setNumWithdrawals(int numWithdrawals) {
        this.numWithdrawals = numWithdrawals;
    }

    public float getAnnualRate() {
        return annualRate;
    }

    public void setAnnualRate(float annualRate) {
        this.annualRate = annualRate;
    }

    public float getMonthlyCommission() {
        return monthlyCommission;
    }

    public void setMonthlyCommission(float monthlyCommission) {
        this.monthlyCommission = monthlyCommission;
    }
}
