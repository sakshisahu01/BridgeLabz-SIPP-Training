package JavaConstructor;

class BankAccountAccess {
    public String accountNumber;
    protected String accountHolder;
    private double balance;

    public BankAccountAccess(String accountNumber, String accountHolder, double balance) {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.balance = balance;
    }

    // Public method to access balance
    public double getBalance() {
        return balance;
    }

    // Public method to modify balance (deposit)
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited: $" + amount + ". New balance: $" + balance);
        } else {
            System.out.println("Deposit amount must be positive.");
        }
    }

    // Public method to modify balance (withdraw)
    public void withdraw(double amount) {
        if (amount > 0 && balance >= amount) {
            balance -= amount;
            System.out.println("Withdrew: $" + amount + ". New balance: $" + balance);
        } else if (amount <= 0) {
            System.out.println("Withdrawal amount must be positive.");
        } else {
            System.out.println("Insufficient balance.");
        }
    }

    public void displayAccountDetails() {
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Account Holder: " + accountHolder);
        System.out.println("Balance: $" + balance);
    }
}

class SavingsAccount extends BankAccountAccess {
    public SavingsAccount(String accountNumber, String accountHolder, double balance) {
        super(accountNumber, accountHolder, balance);
    }

    public void displayAccessDetails() {
        System.out.println("Accessing public accountNumber from subclass: " + accountNumber);
        System.out.println("Accessing protected accountHolder from subclass: " + accountHolder);
        // Cannot access private balance directly: System.out.println(balance);
    }

    public static void main(String[] args) {
        BankAccountAccess account1 = new BankAccountAccess("12345", "John Doe", 1000.00);
        account1.displayAccountDetails();

        account1.deposit(200.00);
        account1.withdraw(50.00);
        System.out.println("Current Balance: $" + account1.getBalance());

        System.out.println();

        SavingsAccount savings1 = new SavingsAccount("67890", "Jane Smith", 5000.00);
        savings1.displayAccountDetails();
        savings1.displayAccessDetails();
    }
}