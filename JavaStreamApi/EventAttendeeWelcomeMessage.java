package JavaStreamApi;

import java.util.Arrays;
import java.util.List;

public class EventAttendeeWelcomeMessage {

    public static void main(String[] args) {
        List<String> attendees = Arrays.asList("Alice", "Bob", "Charlie", "David");

        System.out.println("Event Welcome Messages:");
        attendees.forEach(name -> System.out.println("Welcome, " + name + "! We're glad you're here."));
    }
}