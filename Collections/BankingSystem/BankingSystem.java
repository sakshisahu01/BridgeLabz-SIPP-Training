package Collections.BankingSystem;

import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

// Represents a withdrawal request
class WithdrawalRequest {
    String accountNumber;
    double amount;

    public WithdrawalRequest(String accountNumber, double amount) {
        this.accountNumber = accountNumber;
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "WithdrawalRequest{accountNumber='" + accountNumber + "', amount=" + String.format("%.2f", amount) + "}";
    }
}

public class BankingSystem {

    // HashMap stores customer accounts (AccountNumber -> Account object)
    private Map<String, Account> accountsHashMap;

    // TreeMap sorts customers by balance (Account object -> Account object)
    // Note: TreeMap sorts by key. Account class must implement Comparable<Account>
    // or a custom Comparator must be provided.
    private Map<Account, Account> accountsTreeMap;

    // Queue processes withdrawal requests
    private Queue<WithdrawalRequest> withdrawalQueue;

    public BankingSystem() {
        accountsHashMap = new HashMap<>();
        // TreeMap will sort by Account's natural ordering (by balance)
        accountsTreeMap = new TreeMap<>();
        withdrawalQueue = new LinkedList<>();
    }

    // Add a new account
    public void addAccount(Account account) {
        if (accountsHashMap.containsKey(account.getAccountNumber())) {
            System.out.println("Account with number " + account.getAccountNumber() + " already exists.");
            return;
        }
        accountsHashMap.put(account.getAccountNumber(), account);
        accountsTreeMap.put(account, account); // Add to TreeMap for sorting
        System.out.println("Account added: " + account);
    }

    // Get account by number
    public Account getAccount(String accountNumber) {
        return accountsHashMap.get(accountNumber);
    }

    // Process a deposit
    public void makeDeposit(String accountNumber, double amount) {
        Account account = getAccount(accountNumber);
        if (account != null) {
            // Remove from TreeMap before modification and re-add to ensure correct sorting
            accountsTreeMap.remove(account);
            account.deposit(amount);
            accountsTreeMap.put(account, account);
        } else {
            System.out.println("Account " + accountNumber + " not found.");
        }
    }

    // Enqueue a withdrawal request
    public void requestWithdrawal(String accountNumber, double amount) {
        if (getAccount(accountNumber) == null) {
            System.out.println("Withdrawal request failed: Account " + accountNumber + " not found.");
            return;
        }
        WithdrawalRequest request = new WithdrawalRequest(accountNumber, amount);
        withdrawalQueue.offer(request);
        System.out.println("Withdrawal request enqueued: " + request);
    }

    // Process next withdrawal request from the queue
    public void processNextWithdrawalRequest() {
        if (withdrawalQueue.isEmpty()) {
            System.out.println("No withdrawal requests to process.");
            return;
        }
        WithdrawalRequest request = withdrawalQueue.poll();
        System.out.println("Processing withdrawal request: " + request);
        Account account = getAccount(request.accountNumber);
        if (account != null) {
            // Remove from TreeMap before modification and re-add to ensure correct sorting
            accountsTreeMap.remove(account);
            if (account.withdraw(request.amount)) {
                // If withdrawal successful, re-add to TreeMap
                accountsTreeMap.put(account, account);
            } else {
                // If withdrawal failed, re-add original account to TreeMap
                accountsTreeMap.put(account, account);
            }
        } else {
            System.out.println("Error: Account " + request.accountNumber + " not found during processing.");
        }
    }

    // Display all accounts sorted by balance (using TreeMap)
    public void displayAccountsSortedByBalance() {
        System.out.println("\n--- Accounts Sorted by Balance ---");
        if (accountsTreeMap.isEmpty()) {
            System.out.println("No accounts to display.");
            return;
        }
        for (Map.Entry<Account, Account> entry : accountsTreeMap.entrySet()) {
            System.out.println(entry.getKey()); // Key and Value are the same Account object
        }
    }

    public static void main(String[] args) {
        BankingSystem bank = new BankingSystem();

        System.out.println("--- Banking System Simulation ---");

        // Add accounts
        Account acc1 = new Account("ACC001", "Sohil", 1500.00);
        Account acc2 = new Account("ACC002", "Raj", 500.00);
        Account acc3 = new Account("ACC003", "Tanuj", 2000.00);
        Account acc4 = new Account("ACC004", "nikhil", 100.00);

        bank.addAccount(acc1);
        bank.addAccount(acc2);
        bank.addAccount(acc3);
        bank.addAccount(acc4);

        bank.displayAccountsSortedByBalance();

        // Make some deposits
        bank.makeDeposit("ACC001", 200.00);
        bank.makeDeposit("ACC004", 50.00);

        bank.displayAccountsSortedByBalance();

        // Request withdrawals
        bank.requestWithdrawal("ACC002", 600.00); // Insufficient funds
        bank.requestWithdrawal("ACC001", 300.00);
        bank.requestWithdrawal("ACC003", 1000.00);
        bank.requestWithdrawal("ACC005", 100.00); // Non-existent account

        // Process withdrawal requests
        bank.processNextWithdrawalRequest(); // ACC002 - should fail
        bank.processNextWithdrawalRequest(); // ACC001 - should succeed
        bank.processNextWithdrawalRequest(); // ACC003 - should succeed
        bank.processNextWithdrawalRequest(); // No more requests

        bank.displayAccountsSortedByBalance();

        // Try to withdraw directly (not through queue)
        Account acc1Direct = bank.getAccount("ACC001");
        if (acc1Direct != null) {
            bank.accountsTreeMap.remove(acc1Direct);
            acc1Direct.withdraw(100.00);
            bank.accountsTreeMap.put(acc1Direct, acc1Direct);
        }
        bank.displayAccountsSortedByBalance();
    }
}