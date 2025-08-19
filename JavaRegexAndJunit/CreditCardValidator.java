import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class CreditCardValidator {
    private static final String VISA_PATTERN = "^4[0-9]{15}$";
    private static final String MASTERCARD_PATTERN = "^5[0-9]{15}$";
    
    public static String validateCreditCard(String cardNumber) {
        // Remove spaces and dashes
        String cleanNumber = cardNumber.replaceAll("[\\s-]", "");
        
        if (Pattern.matches(VISA_PATTERN, cleanNumber)) {
            return "Visa Card";
        } else if (Pattern.matches(MASTERCARD_PATTERN, cleanNumber)) {
            return "MasterCard";
        } else {
            return "Invalid";
        }
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("=== Credit Card Validator ===");
        System.out.println("Valid formats:");
        System.out.println("- Visa: Starts with 4, 16 digits");
        System.out.println("- MasterCard: Starts with 5, 16 digits");
        
        System.out.print("\nEnter credit card number: ");
        String cardNumber = scanner.nextLine();
        
        String result = validateCreditCard(cardNumber);
        
        if (result.equals("Invalid")) {
            System.out.println("❌ Invalid credit card format");
        } else {
            System.out.println("✅ Valid " + result);
        }
        
        // Test examples
        System.out.println("\nTest Examples:");
        String[] testCases = {
            "4111111111111111", "5111111111111111", "4111-1111-1111-1111", 
            "411111111111111", "6111111111111111", "1234567890123456"
        };
        for (String test : testCases) {
            String type = validateCreditCard(test);
            System.out.println(test + " → " + type);
        }
        
        scanner.close();
    }
}