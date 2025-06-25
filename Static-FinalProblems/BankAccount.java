class BankAccount {
    // Static variable shared by all objects
    static String bankName = "ABC Bank";
    static int totalAccounts = 0;

    // Final variable (cannot be changed once initialized)
    private final int accountNumber;

    // Instance variable
    private String accountHolderName;

    // Constructor using 'this' to resolve ambiguity
    public BankAccount(String accountHolderName, int accountNumber) {
        this.accountHolderName = accountHolderName;
        this.accountNumber = accountNumber;
        totalAccounts++;
    }

    // Static method to get total accounts
    public static void getTotalAccounts() {
        System.out.println("Total accounts created: " + totalAccounts);
    }

    // Display account details
    public void displayDetails() {
        // Using instanceof to verify the object type
        if (this instanceof BankAccount) {
            System.out.println("Bank: " + bankName);
            System.out.println("Account Holder: " + accountHolderName);
            System.out.println("Account Number: " + accountNumber);
        } else {
            System.out.println("Not a valid BankAccount object.");
        }
    }
}

// Main class to test the BankAccount
public class Main {
    public static void main(String[] args) {
        BankAccount acc1 = new BankAccount("Ravi Kumar", 1001);
        BankAccount acc2 = new BankAccount("Neha Sharma", 1002);

        acc1.displayDetails();
        System.out.println();
        acc2.displayDetails();

        System.out.println();
        BankAccount.getTotalAccounts();
    }
}
