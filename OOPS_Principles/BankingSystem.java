import java.util.*;

// Interface: Loanable
interface Loanable {
    void applyForLoan(double amount);
    double calculateLoanEligibility();
}

// Abstract Class: BankAccount
abstract class BankAccount {
    private String accountNumber;
    private String holderName;
    private double balance;

    public BankAccount(String accountNumber, String holderName, double balance) {
        this.accountNumber = accountNumber;
        this.holderName = holderName;
        this.balance = balance;
    }

    // Getters and Setters
    public String getAccountNumber() {
        return accountNumber;
    }
    public String getHolderName() {
        return holderName;
    }
    public double getBalance() {
        return balance;
    }
    public void setBalance(double balance) {
        this.balance = balance;
    }

    // Concrete methods
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited: ₹" + amount);
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawn: ₹" + amount);
        } else {
            System.out.println("Insufficient balance or invalid amount.");
        }
    }

    public void displayDetails() {
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Holder Name: " + holderName);
        System.out.println("Balance: ₹" + balance);
    }

    // Abstract method
    public abstract double calculateInterest();
}

// Subclass: SavingsAccount
class SavingsAccount extends BankAccount implements Loanable {
    private double interestRate = 0.04; // 4%

    public SavingsAccount(String accNo, String name, double bal) {
        super(accNo, name, bal);
    }

    @Override
    public double calculateInterest() {
        return getBalance() * interestRate;
    }

    @Override
    public void applyForLoan(double amount) {
        System.out.println("Savings Account loan applied: ₹" + amount);
    }

    @Override
    public double calculateLoanEligibility() {
        return getBalance() * 5; // Eligible up to 5 times balance
    }
}

// Subclass: CurrentAccount
class CurrentAccount extends BankAccount implements Loanable {
    private double interestRate = 0.01; // 1%

    public CurrentAccount(String accNo, String name, double bal) {
        super(accNo, name, bal);
    }

    @Override
    public double calculateInterest() {
        return getBalance() * interestRate;
    }

    @Override
    public void applyForLoan(double amount) {
        System.out.println("Current Account loan applied: ₹" + amount);
    }

    @Override
    public double calculateLoanEligibility() {
        return getBalance() * 2; // Less eligibility
    }
}

// Main class
public class BankingSystem {
    public static void main(String[] args) {
        List<BankAccount> accounts = new ArrayList<>();

        BankAccount acc1 = new SavingsAccount("S101", "Alice", 10000);
        BankAccount acc2 = new CurrentAccount("C202", "Bob", 50000);

        accounts.add(acc1);
        accounts.add(acc2);

        System.out.println("=== Account Details and Interest ===\n");

        for (BankAccount acc : accounts) {
            acc.displayDetails();
            System.out.println("Interest: ₹" + acc.calculateInterest());

            // Loanable actions
            if (acc instanceof Loanable) {
                Loanable loanAcc = (Loanable) acc;
                System.out.println("Loan Eligibility: ₹" + loanAcc.calculateLoanEligibility());
                loanAcc.applyForLoan(10000);
            }

            System.out.println("-----------------------------\n");
        }
    }
}
