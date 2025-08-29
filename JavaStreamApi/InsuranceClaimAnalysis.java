package JavaStreamApi;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class InsuranceClaimAnalysis {

    static class Claim {
        String claimId;
        String claimType;
        double claimAmount;

        public Claim(String claimId, String claimType, double claimAmount) {
            this.claimId = claimId;
            this.claimType = claimType;
            this.claimAmount = claimAmount;
        }

        public String getClaimId() {
            return claimId;
        }

        public String getClaimType() {
            return claimType;
        }

        public double getClaimAmount() {
            return claimAmount;
        }

        @Override
        public String toString() {
            return "Claim{claimId='" + claimId + "', claimType='" + claimType + "', claimAmount=" + claimAmount + "}";
        }
    }

    public static void main(String[] args) {
        List<Claim> claims = Arrays.asList(
                new Claim("C001", "Medical", 1500.00),
                new Claim("C002", "Auto", 2500.00),
                new Claim("C003", "Medical", 3000.00),
                new Claim("C004", "Home", 1000.00),
                new Claim("C005", "Auto", 1800.00),
                new Claim("C006", "Medical", 2000.00)
        );

        // Find the average claim amount for each claim type
        Map<String, Double> averageClaimAmountByType = claims.stream()
                .collect(Collectors.groupingBy(
                        Claim::getClaimType,
                        Collectors.averagingDouble(Claim::getClaimAmount)
                ));

        System.out.println("Average claim amount by claim type:");
        averageClaimAmountByType.forEach((type, avgAmount) ->
                System.out.println(type + ": " + String.format("%.2f", avgAmount))
        );
    }
}