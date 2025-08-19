package com.junit.examples;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;

public class BankAccountTest {
    
    private BankAccount account;
    
    @BeforeEach
    public void setUp() {
        account = new BankAccount("123456789", 1000.0);
    }
    
    @Test
    @DisplayName("Test deposit increases balance")
    public void testDeposit() {
        account.deposit(500.0);
        assertEquals(1500.0, account.getBalance(), 0.001);
    }
    
    @Test
    @DisplayName("Test withdrawal decreases balance")
    public void testWithdrawal() {
        boolean result = account.withdraw(300.0);
        assertTrue(result);
        assertEquals(700.0, account.getBalance(), 0.001);
    }
    
    @Test
    @DisplayName("Test withdrawal fails with insufficient funds")
    public void testWithdrawalInsufficientFunds() {
        boolean result = account.withdraw(1500.0);
        assertFalse(result);
        assertEquals(1000.0, account.getBalance(), 0.001);
    }
    
    @Test
    @DisplayName("Test deposit with negative amount throws exception")
    public void testDepositNegativeAmount() {
        assertThrows(IllegalArgumentException.class, () -> {
            account.deposit(-100.0);
        });
    }
    
    @Test
    @DisplayName("Test withdrawal with negative amount throws exception")
    public void testWithdrawalNegativeAmount() {
        assertThrows(IllegalArgumentException.class, () -> {
            account.withdraw(-100.0);
        });
    }
    
    @Test
    @DisplayName("Test initial balance")
    public void testInitialBalance() {
        assertEquals(1000.0, account.getBalance(), 0.001);
        assertEquals("123456789", account.getAccountNumber());
    }
}