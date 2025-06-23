

 class BankAccount {
    // Private fields to store account details
    private String accountHolder;
    private String accountNumber;
    private double balance;

    // Constructor to initialize account
    public BankAccount(String accountHolder, String accountNumber, double initialBalance) {
        this.accountHolder = accountHolder;
        this.accountNumber = accountNumber;
        this.balance = initialBalance;
    }

    // Method to deposit money
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("₹" + amount + " deposited successfully.");
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    // Method to withdraw money
    public void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Invalid withdrawal amount.");
        } else if (amount > balance) {
            System.out.println("Insufficient balance! Withdrawal failed.");
        } else {
            balance -= amount;
            System.out.println("₹" + amount + " withdrawn successfully.");
        }
    }

    // Method to display current balance and account details
    public void displayAccountDetails() {
        System.out.println("Account Holder : " + accountHolder);
        System.out.println("Account Number : " + accountNumber);
        System.out.println("Current Balance: ₹" + balance);
    }

    // Main method to test the BankAccount class
    public static void main(String[] args) {
        // Creating a BankAccount object
        BankAccount account1 = new BankAccount("Ravi Kumar", "1234567890", 5000.0);

        // Display initial account details
        account1.displayAccountDetails();
        System.out.println();

        // Deposit money
        account1.deposit(2000.0);
        account1.displayAccountDetails();
        System.out.println();

        // Withdraw money
        account1.withdraw(3000.0);
        account1.displayAccountDetails();
        System.out.println();

        // Attempt to withdraw more than balance
        account1.withdraw(6000.0);
        account1.displayAccountDetails();
    }
}
