

 class PalindromeChecker{
    // Private field to store the input text
    private String text;

    // Constructor to initialize the text
    public PalindromeChecker(String text) {
        this.text = text;
    }

    // Method to check if the text is a palindrome
    public boolean isPalindrome() {
        // Remove spaces and convert to lowercase for accurate comparison
        String cleanedText = text.replaceAll("\\s+", "").toLowerCase();

        int left = 0;
        int right = cleanedText.length() - 1;

        while (left < right) {
            if (cleanedText.charAt(left) != cleanedText.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    // Method to display the result
    public void displayResult() {
        System.out.println("Input Text: " + text);
        if (isPalindrome()) {
            System.out.println("Result    : It is a palindrome.");
        } else {
            System.out.println("Result    : It is NOT a palindrome.");
        }
    }

    // Main method to test the PalindromeChecker
    public static void main(String[] args) {
        // Example 1
        PalindromeChecker checker1 = new PalindromeChecker("Madam");
        checker1.displayResult();

        // Example 2
        PalindromeChecker checker2 = new PalindromeChecker("Hello");
        checker2.displayResult();

        // Example 3 (with space and case-insensitive)
        PalindromeChecker checker3 = new PalindromeChecker("Nurses Run");
        checker3.displayResult();
    }
}
