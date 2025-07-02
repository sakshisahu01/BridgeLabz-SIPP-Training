public class Course {
    String courseName;
    int duration; // in hours

    public Course(String courseName, int duration) {
        this.courseName = courseName;
        this.duration = duration;
    }

    public static void main(String[] args) {
        PaidOnlineCourse course = new PaidOnlineCourse("Java Basics", 40, "Udemy", true, 199.99, 20.0);
        System.out.println("Course: " + course.courseName);
        System.out.println("Duration: " + course.duration + " hours");
        System.out.println("Platform: " + course.platform);
        System.out.println("Recorded: " + course.isRecorded);
        System.out.println("Fee: $" + course.fee);
        System.out.println("Discount: " + course.discount + "%");
    }
}

class OnlineCourse extends Course {
    String platform;
    boolean isRecorded;

    public OnlineCourse(String courseName, int duration, String platform, boolean isRecorded) {
        super(courseName, duration);
        this.platform = platform;
        this.isRecorded = isRecorded;
    }
}

class PaidOnlineCourse extends OnlineCourse {
    double fee;
    double discount;

    public PaidOnlineCourse(String courseName, int duration, String platform, boolean isRecorded, double fee, double discount) {
        super(courseName, duration, platform, isRecorded);
        this.fee = fee;
        this.discount = discount;
    }
}