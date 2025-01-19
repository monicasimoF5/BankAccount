package org.msc;

public class Account {
    protected float balance;
    protected int numConsignments;
    protected int numWithdrawals;
    protected float annualRate;
    protected float monthlyCommission;

    public Account(float initialBalance, int numConsignments, float annualRate) {
        this.balance = initialBalance;
        this.numConsignments = numConsignments;
        this.numWithdrawals = 0;
        this.annualRate = annualRate;
        this.monthlyCommission = 0;
    }

    public Account(float initialBalance, float annualRate) {
    }

    public void record(float amount){
        if (amount > 0) {
            balance += amount;
            numConsignments++;
        } else{
        numConsignments++;}
    }

    public void withdraw(float amount){
        if (balance >= amount){
            balance -= amount;
            numWithdrawals++;
        }
        System.out.println("Saldo insuficiente, tu saldo actual es " + balance);
    }

    public void monthlyInterest(){
        balance += balance * (annualRate/12)/100;
    }

    protected void monthlyStatement() {
        balance -= monthlyCommission;
        monthlyInterest();
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
