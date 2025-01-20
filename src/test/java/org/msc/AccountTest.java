package org.msc;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AccountTest {

    @Test
    public void testRecordUpdateBalance() {
        Account account = new Account(1000, 0, 0);
        account.record(500);
        assertEquals(1500, account.getBalance());
    }

    @Test
    public void testRecordUpdateNumConsignments() {
        Account account = new Account(1000, 0, 0);
        account.record(500);
        assertEquals(1, account.getNumConsignments());
    }

    @Test
    public void testRecordIfAmountNegativeOnlyUpdateConsignments() {
        Account account = new Account(1000, 0, 0);
        account.record(-500);
        assertEquals(1000, account.getBalance());
        assertEquals(1, account.getNumConsignments());
    }

    @Test
    public void testSuccessfulWithdrawal() {
        Account account = new Account(1000, 0, 0);
        account.withdraw(500);
        assertEquals(500, account.getBalance());
        assertEquals(1, account.getNumWithdrawals());
    }

    @Test
    public void testInsufficientFundsWithdrawal() {
        Account account = new Account(500, 0, 0);
        account.withdraw(1000);
        assertEquals(500, account.getBalance(), "Saldo insuficiente, tu saldo actual es " + account.getBalance());
        assertEquals(0, account.getNumWithdrawals());
    }

    @Test
    public void testZeroWithdrawal() {
        Account account = new Account(0, 0, 0);
        account.withdraw(1000);
        assertEquals(0, account.getBalance(), "Saldo insuficiente, tu saldo actual es " + account.getBalance());
        assertEquals(0, account.getNumWithdrawals());
    }

    @Test
    public void testPositiveBalanceAndPositiveRate() {
        Account account = new Account(1000, 5, 5f);
        account.monthlyInterest();

        float expectedInterest = 1000 * (5f / 12) / 100;
        assertEquals(1000 + expectedInterest, account.getBalance(), 0.05);
    }

    @Test
    public void givenAccountWhenAnnualRateThenMonthlyInterest() {
        Account account = new Account(1000, 0, 2.5f);
        account.monthlyInterest();

        float expectedInterest = 1000 * (2.5f / 12) / 100;
        Assertions.assertEquals(1000 + expectedInterest, account.getBalance(), 0.01);
    }

    @Test
    public void testConstructorActive() {
        SavingsAccount account = new SavingsAccount(15000, 5.0f);
        assertTrue(account.active);
    }

    @Test
    public void testConstructorInactive() {
        SavingsAccount account = new SavingsAccount(5000, 5.0f);
        assertFalse(account.active);
    }

    @Test
    public void testRecordInactive() {
        SavingsAccount account = new SavingsAccount(5000, 5.0f);
        account.record(500);
        assertFalse(account.active);
    }

    @Test
    public void testWithdrawInactive() {
        SavingsAccount account = new SavingsAccount(5000, 5.0f);
        account.withdraw(500);
        assertFalse(account.active);
    }

    @Test
    public void testRecordAfterWithdrawalMakingInactive() {
        SavingsAccount account = new SavingsAccount(15000, 5.0f);
        account.withdraw(12000); // Balance now below 10000
        account.record(500);
        assertFalse(account.active);
    }

    @Test
    public void testRecordIncreaseOverdraft() {
        CurrentAccount account = new CurrentAccount(0, 5.0f);
        account.record(200);
        assertEquals(0, account.getBalance());
        assertEquals(-200, account.overdraft);
        assertEquals(1, account.getNumConsignments());
    }

}