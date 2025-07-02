public class BankAccount {
    String accountNumber;
    double balance;

    public BankAccount(String accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public static void main(String[] args) {
        SavingsAccount savings = new SavingsAccount("SA123", 5000.0, 3.5);
        CheckingAccount checking = new CheckingAccount("CA456", 2000.0, 1000.0);
        FixedDepositAccount fixed = new FixedDepositAccount("FD789", 10000.0, 12);

        savings.displayAccountType();
        checking.displayAccountType();
        fixed.displayAccountType();
    }
}

class SavingsAccount extends BankAccount {
    double interestRate;

    public SavingsAccount(String accountNumber, double balance, double interestRate) {
        super(accountNumber, balance);
        this.interestRate = interestRate;
    }

    public void displayAccountType() {
        System.out.println("Account Type: Savings Account");
    }
}

class CheckingAccount extends BankAccount {
    double withdrawalLimit;

    public CheckingAccount(String accountNumber, double balance, double withdrawalLimit) {
        super(accountNumber, balance);
        this.withdrawalLimit = withdrawalLimit;
    }

    public void displayAccountType() {
        System.out.println("Account Type: Checking Account");
    }
}

class FixedDepositAccount extends BankAccount {
    int depositPeriod; // in months

    public FixedDepositAccount(String accountNumber, double balance, int depositPeriod) {
        super(accountNumber, balance);
        this.depositPeriod = depositPeriod;
    }

    public void displayAccountType() {
        System.out.println("Account Type: Fixed Deposit Account");
    }
}