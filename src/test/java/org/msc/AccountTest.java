package org.msc;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AccountTest {

    @Test
    public void testRecordUpdateBalance() {
        Account account = new Account(1000, 0);
        account.record(500);
        assertEquals(1500, account.getBalance());
    }

    @Test
    public void testRecordUpdateNumConsignments() {
        Account account = new Account(1000, 0);
        account.record(500);
        assertEquals(1, account.getNumConsignments());
    }

    @Test
    public void testRecordIfAmountNegativeOnlyUpdateConsignments() {
        Account account = new Account(1000, 0);
        account.record(-500);
        assertEquals(1000, account.getBalance());
        assertEquals(1, account.getNumConsignments());
    }


}