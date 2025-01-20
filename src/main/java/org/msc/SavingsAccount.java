package org.msc;

public class SavingsAccount extends Account{
    public boolean active;

    public SavingsAccount(float initialBalance, float annualRate) {
        super(initialBalance, annualRate);
        active = initialBalance >= 10000;
    }

    @Override
    public void record(float amount){
        if (active){
            super.record(amount);
            active = balance >= 10000;
        }
        System.out.println("Cuenta inactiva. No se pueden realizar consignaciones.");
    }

    @Override
    public void withdraw(float amount){
        if (active){
            super.withdraw(amount);
            active = balance >= 10000;
        }
        System.out.println("Cuenta inactiva. No se pueden realizar retiros.");
    }

    @Override
    public void monthlyStatement(){
        super.monthlyStatement();
    }

    public void print() {
        super.print();
        System.out.println("Estado de la cuenta: " + (active ? "Activa" : "Inactiva"));
    }

}
