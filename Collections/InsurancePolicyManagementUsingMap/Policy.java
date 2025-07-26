package Collections.InsurancePolicyManagementUsingMap;

import java.time.LocalDate;
import java.util.Objects;

public class Policy implements Comparable<Policy> {
    private String policyNumber;
    private String policyholderName;
    private LocalDate expiryDate;
    private String coverageType;
    private double premiumAmount;

    public Policy(String policyNumber, String policyholderName, LocalDate expiryDate, String coverageType, double premiumAmount) {
        this.policyNumber = policyNumber;
        this.policyholderName = policyholderName;
        this.expiryDate = expiryDate;
        this.coverageType = coverageType;
        this.premiumAmount = premiumAmount;
    }

    public String getPolicyNumber() {
        return policyNumber;
    }

    public String getPolicyholderName() {
        return policyholderName;
    }

    public LocalDate getExpiryDate() {
        return expiryDate;
    }

    public String getCoverageType() {
        return coverageType;
    }

    public double getPremiumAmount() {
        return premiumAmount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Policy policy = (Policy) o;
        return Objects.equals(policyNumber, policy.policyNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(policyNumber);
    }

    @Override
    public String toString() {
        return "Policy{" +
               "policyNumber='" + policyNumber + '\'' +
               ", policyholderName='" + policyholderName + '\'' +
               ", expiryDate=" + expiryDate +
               ", coverageType='" + coverageType + '\'' +
               ", premiumAmount=" + String.format("%.2f", premiumAmount) +
               '}';
    }

    @Override
    public int compareTo(Policy other) {
        // Sort policies by expiry date
        return this.expiryDate.compareTo(other.expiryDate);
    }
}