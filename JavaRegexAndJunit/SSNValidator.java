import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class SSNValidator {
    private static final String SSN_PATTERN = "^\\d{3}-\\d{2}-\\d{4}$";
    
    public static boolean isValidSSN(String ssn) {
        Pattern pattern = Pattern.compile(SSN_PATTERN);
        Matcher matcher = pattern.matcher(ssn);
        return matcher.matches();
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("=== Social Security Number (SSN) Validator ===");
        System.out.println("Valid format: XXX-XX-XXXX (where X is a digit)");
        
        System.out.print("\nEnter SSN: ");
        String ssn = scanner.nextLine();
        
        if (isValidSSN(ssn)) {
            System.out.println("✅ Valid SSN format");
        } else {
            System.out.println("❌ Invalid SSN format");
        }
        
        // Test examples
        System.out.println("\nTest Examples:");
        String[] testCases = {
            "123-45-6789", "123456789", "12-345-6789", 
            "123-45-678", "123-456-789", "000-00-0000"
        };
        for (String test : testCases) {
            System.out.println(test + " → " + (isValidSSN(test) ? "Valid" : "Invalid"));
        }
        
        scanner.close();
    }
}