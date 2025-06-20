import java.util.Scanner;

public class CalendarGenerator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter month (1-12): ");
        int month = sc.nextInt();
        System.out.print("Enter year: ");
        int year = sc.nextInt();

        printCalendar(month, year);
    }

    public static void printCalendar(int month, int year) {
        String[] monthNames = {
            "", "January", "February", "March", "April", "May", "June",
            "July", "August", "September", "October", "November", "December"
        };

        int[] daysInMonth = {
            0, 31, 28, 31, 30, 31, 30,
            31, 31, 30, 31, 30, 31
        };

        if (month == 2 && isLeapYear(year)) {
            daysInMonth[2] = 29;
        }

        int firstDay = getFirstDayOfMonth(month, year);
        int totalDays = daysInMonth[month];

        System.out.println("\n   " + monthNames[month] + " " + year);
        System.out.println("Sun Mon Tue Wed Thu Fri Sat");

        for (int i = 0; i < firstDay; i++) {
            System.out.print("    ");
        }

        for (int day = 1; day <= totalDays; day++) {
            System.out.printf("%3d ", day);
            if ((day + firstDay) % 7 == 0)
                System.out.println();
        }
        System.out.println();
    }

    public static boolean isLeapYear(int year) {
        return (year % 400 == 0 || (year % 4 == 0 && year % 100 != 0));
    }

    public static int getFirstDayOfMonth(int month, int year) {
        if (month < 3) {
            month += 12;
            year--;
        }
        int q = 1;
        int m = month;
        int k = year % 100;
        int j = year / 100;

        int h = (q + 13*(m + 1)/5 + k + k/4 + j/4 + 5*j) % 7;

        return (h + 6) % 7; // 0 = Sunday, ..., 6 = Saturday
    }
}
