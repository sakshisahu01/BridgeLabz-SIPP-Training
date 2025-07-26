package Collections.InsurancePolicyManagementSystem;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.TimeUnit;

public class InsurancePolicyManagementSystem {

    private Set<Policy> hashSetPolicies; // For quick lookups
    private Set<Policy> linkedHashSetPolicies; // To maintain insertion order
    private Set<Policy> treeSetPolicies; // To maintain policies sorted by expiry date

    public InsurancePolicyManagementSystem() {
        hashSetPolicies = new HashSet<>();
        linkedHashSetPolicies = new LinkedHashSet<>();
        treeSetPolicies = new TreeSet<>();
    }

    // 1. Store Unique Policies
    public void addPolicy(Policy policy) {
        hashSetPolicies.add(policy);
        linkedHashSetPolicies.add(policy);
        treeSetPolicies.add(policy);
    }

    // 2. Retrieve Policies
    public void displayAllPolicies(String setName, Set<Policy> policies) {
        System.out.println("\n--- All Policies in " + setName + " ---");
        if (policies.isEmpty()) {
            System.out.println("No policies to display.");
            return;
        }
        for (Policy policy : policies) {
            System.out.println(policy);
        }
    }

    public void displayPoliciesExpiringSoon(int days) {
        System.out.println("\n--- Policies Expiring Within " + days + " Days ---");
        LocalDate today = LocalDate.now();
        LocalDate expiryThreshold = today.plusDays(days);
        boolean found = false;
        for (Policy policy : hashSetPolicies) { // Can use any set for iteration
            if (policy.getExpiryDate().isBefore(expiryThreshold) || policy.getExpiryDate().isEqual(expiryThreshold)) {
                System.out.println(policy);
                found = true;
            }
        }
        if (!found) {
            System.out.println("No policies expiring soon.");
        }
    }

    public void displayPoliciesByCoverageType(String coverageType) {
        System.out.println("\n--- Policies with Coverage Type: " + coverageType + " ---");
        boolean found = false;
        for (Policy policy : hashSetPolicies) {
            if (policy.getCoverageType().equalsIgnoreCase(coverageType)) {
                System.out.println(policy);
                found = true;
            }
        }
        if (!found) {
            System.out.println("No policies found for coverage type: " + coverageType);
        }
    }

    public void displayDuplicatePolicies() {
        System.out.println("\n--- Duplicate Policies (based on policy number) ---");
        Set<String> uniquePolicyNumbers = new HashSet<>();
        Set<Policy> duplicates = new HashSet<>();
        for (Policy policy : linkedHashSetPolicies) { // LinkedHashSet maintains insertion order for consistent duplicate detection
            if (!uniquePolicyNumbers.add(policy.getPolicyNumber())) {
                duplicates.add(policy);
            }
        }
        if (duplicates.isEmpty()) {
            System.out.println("No duplicate policies found.");
        } else {
            for (Policy policy : duplicates) {
                System.out.println(policy);
            }
        }
    }

    // 3. Performance Comparison (Simplified for demonstration)
    public void comparePerformance() {
        System.out.println("\n--- Performance Comparison (Adding 100,000 policies) ---");

        int numPolicies = 100000;

        // HashSet
        long startTime = System.nanoTime();
        Set<Policy> tempHashSet = new HashSet<>();
        for (int i = 0; i < numPolicies; i++) {
            tempHashSet.add(new Policy("HS" + i, "Holder" + i, LocalDate.now().plusDays(i), "Type" + (i % 3), 100.0 + i));
        }
        long endTime = System.nanoTime();
        long durationHashSet = TimeUnit.NANOSECONDS.toMillis(endTime - startTime);
        System.out.println("HashSet Add: " + durationHashSet + " ms");

        // LinkedHashSet
        startTime = System.nanoTime();
        Set<Policy> tempLinkedHashSet = new LinkedHashSet<>();
        for (int i = 0; i < numPolicies; i++) {
            tempLinkedHashSet.add(new Policy("LHS" + i, "Holder" + i, LocalDate.now().plusDays(i), "Type" + (i % 3), 100.0 + i));
        }
        endTime = System.nanoTime();
        long durationLinkedHashSet = TimeUnit.NANOSECONDS.toMillis(endTime - startTime);
        System.out.println("LinkedHashSet Add: " + durationLinkedHashSet + " ms");

        // TreeSet
        startTime = System.nanoTime();
        Set<Policy> tempTreeSet = new TreeSet<>();
        for (int i = 0; i < numPolicies; i++) {
            tempTreeSet.add(new Policy("TS" + i, "Holder" + i, LocalDate.now().plusDays(i), "Type" + (i % 3), 100.0 + i));
        }
        endTime = System.nanoTime();
        long durationTreeSet = TimeUnit.NANOSECONDS.toMillis(endTime - startTime);
        System.out.println("TreeSet Add: " + durationTreeSet + " ms");

        System.out.println("\nNote: Performance can vary based on system and specific operations (add, remove, search).");
    }

    public static void main(String[] args) {
        InsurancePolicyManagementSystem ipms = new InsurancePolicyManagementSystem();

        // Create some policies
        Policy p1 = new Policy("P001", "Sohil", LocalDate.now().plusDays(30), "Auto", 500.00);
        Policy p2 = new Policy("P002", "Raj", LocalDate.now().plusDays(10), "Health", 1200.00);
        Policy p3 = new Policy("P003", "Tanuj", LocalDate.now().plusDays(90), "Home", 800.00);
        Policy p4 = new Policy("P004", "nikhil", LocalDate.now().plusDays(5), "Auto", 550.00); // Expiring soon, duplicate policyholder
        Policy p5 = new Policy("P001", "prateek", LocalDate.now().plusDays(60), "Health", 1300.00); // Duplicate policy number
        Policy p6 = new Policy("P005", "prakash", LocalDate.now().plusDays(15), "Home", 700.00);

        ipms.addPolicy(p1);
        ipms.addPolicy(p2);
        ipms.addPolicy(p3);
        ipms.addPolicy(p4);
        ipms.addPolicy(p5);
        ipms.addPolicy(p6);

        // Display policies
        ipms.displayAllPolicies("HashSet", ipms.hashSetPolicies);
        ipms.displayAllPolicies("LinkedHashSet", ipms.linkedHashSetPolicies);
        ipms.displayAllPolicies("TreeSet", ipms.treeSetPolicies);

        ipms.displayPoliciesExpiringSoon(30);
        ipms.displayPoliciesByCoverageType("Auto");
        ipms.displayPoliciesByCoverageType("Health");
        ipms.displayDuplicatePolicies();

        // Performance comparison
        ipms.comparePerformance();
    }
}