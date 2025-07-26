package Collections.BankingSystem;

import java.util.Objects;

public class Account implements Comparable<Account> {
    private String accountNumber;
    private String customerName;
    private double balance;

    public Account(String accountNumber, String customerName, double balance) {
        this.accountNumber = accountNumber;
        this.customerName = customerName;
        this.balance = balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getCustomerName() {
        return customerName;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            this.balance += amount;
            System.out.println("Deposited $" + String.format("%.2f", amount) + " to account " + accountNumber + ". New balance: $" + String.format("%.2f", this.balance));
        } else {
            System.out.println("Deposit amount must be positive.");
        }
    }

    public boolean withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Withdrawal amount must be positive.");
            return false;
        }
        if (this.balance >= amount) {
            this.balance -= amount;
            System.out.println("Withdrew $" + String.format("%.2f", amount) + " from account " + accountNumber + ". New balance: $" + String.format("%.2f", this.balance));
            return true;
        } else {
            System.out.println("Insufficient funds in account " + accountNumber + ". Current balance: $" + String.format("%.2f", this.balance));
            return false;
        }
    }

    @Override
    public String toString() {
        return "Account{accountNumber='" + accountNumber + "', customerName='" + customerName + "', balance=" + String.format("%.2f", balance) + "}";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        return Objects.equals(accountNumber, account.accountNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountNumber);
    }

    @Override
    public int compareTo(Account other) {
        // Sort accounts by balance for TreeMap
        return Double.compare(this.balance, other.balance);
    }
}