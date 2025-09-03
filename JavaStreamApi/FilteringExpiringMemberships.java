package JavaStreamApi;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FilteringExpiringMemberships {

    static class Member {
        String name;
        LocalDate expiryDate;

        public Member(String name, LocalDate expiryDate) {
            this.name = name;
            this.expiryDate = expiryDate;
        }

        public String getName() {
            return name;
        }

        public LocalDate getExpiryDate() {
            return expiryDate;
        }

        @Override
        public String toString() {
            return "Member{name='" + name + "', expiryDate=" + expiryDate + "}";
        }
    }

    public static void main(String[] args) {
        LocalDate today = LocalDate.now();
        LocalDate thirtyDaysFromNow = today.plusDays(30);

        List<Member> members = Arrays.asList(
                new Member("Alice", today.plusDays(10)),
                new Member("Bob", today.plusDays(45)),
                new Member("Charlie", today.plusDays(25)),
                new Member("David", today.plusDays(5)),
                new Member("Eve", today.plusDays(60))
        );

        // Filter out members whose membership expires within the next 30 days
        List<Member> expiringMembers = members.stream()
                .filter(member -> member.getExpiryDate().isAfter(today) && member.getExpiryDate().isBefore(thirtyDaysFromNow))
                .collect(Collectors.toList());

        System.out.println("Memberships expiring within the next 30 days:");
        expiringMembers.forEach(System.out::println);
    }
}