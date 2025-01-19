package org.msc;

public class CurrentAccount extends Account {
    private float overdraft;

    public CurrentAccount(float initialBalance, float annualRate) {
        super(initialBalance, annualRate);
        overdraft = 0;
    }

    @Override
    public void withdraw (float amount){
        balance -= amount;

        if (balance < 0){
            overdraft = -balance;
            balance = 0;
        }

        numWithdrawals++;
    }

    @Override
    public void record(float amount){
        super.record(amount);

        if (amount > overdraft){
            balance += overdraft;
            overdraft = 0;
        }

        overdraft -= amount;
        balance = 0;
    }

}
