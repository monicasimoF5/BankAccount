package org.msc;

public class CurrentAccount extends Account {
    protected float overdraft;

    public CurrentAccount(float initialBalance, float annualRate) {
        super(initialBalance, annualRate);
        this.overdraft = 0;
    }

    @Override
    public void withdraw(float amount) {
        if (balance >= amount) {
            balance -= amount;
        } else {
            overdraft += (amount - balance);
            balance = 0;
        }
        numWithdrawals++;
    }

    @Override
    public void record(float amount) {
        super.record(amount);

        if (overdraft > 0 && amount >= overdraft) {
            balance += overdraft;
            amount -= overdraft;
            overdraft = 0;
        } else if (overdraft > 0) {
            overdraft -= amount;
            amount = 0;
        }

        if (amount > 0) {
            balance += amount;
        }
    }

    @Override
    protected void monthlyStatement() {
        super.monthlyStatement();
    }

    public String imprimir() {
        int totalTransactions = numConsignments + numWithdrawals;
        return "Saldo: " + balance +
                "\nComisión mensual: " + monthlyCommission +
                "\nNúmero de transacciones: " + totalTransactions +
                "\nSobregiro: " + overdraft;
    }

    public float getOverdraft() {
        return overdraft;
    }

    public void setOverdraft(float overdraft) {
        this.overdraft = overdraft;
    }
}