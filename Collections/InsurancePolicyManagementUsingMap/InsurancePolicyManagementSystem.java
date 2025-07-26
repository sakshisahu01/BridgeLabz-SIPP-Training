package Collections.InsurancePolicyManagementUsingMap;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class InsurancePolicyManagementSystem {

    // HashMap to store policies with policy numbers as keys and policy details as values.
    private Map<String, Policy> policiesHashMap;

    // LinkedHashMap to maintain the insertion order of policies.
    private Map<String, Policy> policiesLinkedHashMap;

    // TreeMap to store policies sorted by expiry date.
    // The key is the Policy object itself, and the Policy class implements Comparable<Policy>
    // to sort by expiry date.
    private Map<Policy, Policy> policiesTreeMap;

    public InsurancePolicyManagementSystem() {
        this.policiesHashMap = new HashMap<>();
        this.policiesLinkedHashMap = new LinkedHashMap<>();
        this.policiesTreeMap = new TreeMap<>();
    }

    // Add a new policy
    public void addPolicy(Policy policy) {
        if (policiesHashMap.containsKey(policy.getPolicyNumber())) {
            System.out.println("Policy with number " + policy.getPolicyNumber() + " already exists. Not adding.");
            return;
        }
        policiesHashMap.put(policy.getPolicyNumber(), policy);
        policiesLinkedHashMap.put(policy.getPolicyNumber(), policy);
        policiesTreeMap.put(policy, policy); // Key and value are the same for TreeMap sorting
        System.out.println("Added policy: " + policy.getPolicyNumber());
    }

    // Retrieve a policy by its number
    public Policy getPolicy(String policyNumber) {
        return policiesHashMap.get(policyNumber);
    }

    // List all policies expiring within the next 30 days
    public void listPoliciesExpiringSoon() {
        LocalDate today = LocalDate.now();
        LocalDate thirtyDaysLater = today.plusDays(30);

        System.out.println("\n--- Policies Expiring within 30 Days ---");
        boolean found = false;
        for (Policy policy : policiesHashMap.values()) {
            if (policy.getExpiryDate().isAfter(today) && policy.getExpiryDate().isBefore(thirtyDaysLater)) {
                System.out.println(policy);
                found = true;
            }
        }
        if (!found) {
            System.out.println("No policies expiring within the next 30 days.");
        }
    }

    // List all policies for a specific policyholder
    public void listPoliciesByPolicyholder(String policyholderName) {
        System.out.println("\n--- Policies for " + policyholderName + " ---");
        boolean found = false;
        for (Policy policy : policiesHashMap.values()) {
            if (policy.getPolicyholderName().equalsIgnoreCase(policyholderName)) {
                System.out.println(policy);
                found = true;
            }
        }
        if (!found) {
            System.out.println("No policies found for policyholder: " + policyholderName);
        }
    }

    // Remove policies that are expired
    public void removeExpiredPolicies() {
        LocalDate today = LocalDate.now();
        System.out.println("\n--- Removing Expired Policies ---");

        // Collect expired policy numbers first to avoid ConcurrentModificationException
        // when iterating and modifying the map.
        // For HashMap and LinkedHashMap
        policiesHashMap.entrySet().removeIf(entry -> entry.getValue().getExpiryDate().isBefore(today));
        policiesLinkedHashMap.entrySet().removeIf(entry -> entry.getValue().getExpiryDate().isBefore(today));

        // For TreeMap, we need to create a new map or remove carefully
        // Since TreeMap keys are Policy objects, we need to remove by Policy object
        policiesTreeMap.entrySet().removeIf(entry -> entry.getKey().getExpiryDate().isBefore(today));

        System.out.println("Expired policies removed.");
    }

    // Display all policies from HashMap
    public void displayAllPoliciesHashMap() {
        System.out.println("\n--- All Policies (HashMap - No guaranteed order) ---");
        if (policiesHashMap.isEmpty()) {
            System.out.println("No policies to display.");
            return;
        }
        policiesHashMap.values().forEach(System.out::println);
    }

    // Display all policies from LinkedHashMap (insertion order)
    public void displayAllPoliciesLinkedHashMap() {
        System.out.println("\n--- All Policies (LinkedHashMap - Insertion Order) ---");
        if (policiesLinkedHashMap.isEmpty()) {
            System.out.println("No policies to display.");
            return;
        }
        policiesLinkedHashMap.values().forEach(System.out::println);
    }

    // Display all policies from TreeMap (sorted by expiry date)
    public void displayAllPoliciesTreeMap() {
        System.out.println("\n--- All Policies (TreeMap - Sorted by Expiry Date) ---");
        if (policiesTreeMap.isEmpty()) {
            System.out.println("No policies to display.");
            return;
        }
        policiesTreeMap.keySet().forEach(System.out::println);
    }

    public static void main(String[] args) {
        InsurancePolicyManagementSystem system = new InsurancePolicyManagementSystem();

        // Create some policies
        Policy p1 = new Policy("POL001", "Sohil", LocalDate.of(2025, 1, 15), "Auto", 1200.00);
        Policy p2 = new Policy("POL002", "Raj", LocalDate.of(2024, 12, 1), "Home", 800.00);
        Policy p3 = new Policy("POL003", "Tanuj", LocalDate.of(2025, 3, 20), "Life", 500.00);
        Policy p4 = new Policy("POL004", "nikhil", LocalDate.of(2024, 7, 25), "Health", 1500.00); // Expiring soon
        Policy p5 = new Policy("POL005", "prateek", LocalDate.of(2024, 6, 1), "Auto", 900.00); // Expired
        Policy p6 = new Policy("POL006", "Ambani", LocalDate.of(2025, 2, 10), "Travel", 300.00);

        // Add policies
        system.addPolicy(p1);
        system.addPolicy(p2);
        system.addPolicy(p3);
        system.addPolicy(p4);
        system.addPolicy(p5);
        system.addPolicy(p6);

        // Try adding a duplicate
        system.addPolicy(new Policy("POL001", "Sohil", LocalDate.of(2026, 1, 15), "Auto", 1300.00));

        // Display policies from different maps
        system.displayAllPoliciesHashMap();
        system.displayAllPoliciesLinkedHashMap();
        system.displayAllPoliciesTreeMap();

        // Retrieve a policy
        System.out.println("\nRetrieving POL003: " + system.getPolicy("POL003"));
        System.out.println("Retrieving POL999: " + system.getPolicy("POL999"));

        // List policies expiring soon
        system.listPoliciesExpiringSoon();

        // List policies by policyholder
        system.listPoliciesByPolicyholder("Sohil");
        system.listPoliciesByPolicyholder("Raj");

        // Remove expired policies
        system.removeExpiredPolicies();

        // Display policies after removal
        system.displayAllPoliciesHashMap();
        system.displayAllPoliciesTreeMap();
    }
}