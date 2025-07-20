package com.skill_forge;

public class Main {
    public static void main(String[] args) {
        
        // 1. Create an Instructor
        Instructor instructor = new Instructor(101, "Dr. Alice", "alice@skillforge.com");

        // 2. Create a Course
        int[] modules = {1, 2, 3, 4}; // Assume these are module IDs
        Course course = new Course("Java Programming", instructor.getName(), 5, modules);

        // 3. Create a Student
        Student student = new Student(201, "Bob", "bob@student.com");

        // 4. Simulate student progress and grade
        student.setProgress(100); // Completed 100%
        student.setGrade(92);     // Scored 92

        // 5. Display Course Details
        System.out.println("Course Title: " + course.getTitle());
        System.out.println("Instructor: " + course.getInstructor());
        System.out.println("Rating: " + course.getRating());
        System.out.print("Modules: ");
        for (int mod : course.getModules()) {
            System.out.print(mod + " ");
        }
        System.out.println("\n");

        // 6. Display Student Info
        System.out.println("Student Name: " + student.getName());
        System.out.println("Progress: " + student.getProgress() + "%");
        System.out.println("Grade: " + student.getGrade());

        // 7. Generate Certificate using Polymorphism
        System.out.println("\n--- Certificate ---");
        System.out.println(student.generateCertificate());

//        // 8. Display read-only course reviews
//        System.out.println("\nCourse Reviews:");
//        for (String review : course.getReviews()) {
//            System.out.println("- " + review);
//          Priyanshu_Yadav
//        }
    }
}