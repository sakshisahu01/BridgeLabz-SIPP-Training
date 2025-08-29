package JavaStreamApi;


import java.util.Arrays;
import java.util.List;

public class EmailNotifications {

    public static void sendEmailNotification(String email) {
        System.out.println("Sending email notification to: " + email);
        // In a real application, this would involve actual email sending logic
    }

    public static void main(String[] args) {
        List<String> userEmails = Arrays.asList(
                "user1@example.com",
                "user2@example.com",
                "user3@example.com"
        );

        System.out.println("Initiating Email Notifications:");
        userEmails.forEach(EmailNotifications::sendEmailNotification);
    }
}