package org.msc;

public class Account {
    private float balance;
    private int numConsignments;
    private int numWithdrawals;
    private float annualRate;
    private float monthlyCommission;

    public void account(float initialBalance, float annualRate){
        this.balance = initialBalance;
        this.annualRate = annualRate;
        numConsignments = 0;
        numWithdrawals = 0;
        monthlyCommission = 0;
    }

}
