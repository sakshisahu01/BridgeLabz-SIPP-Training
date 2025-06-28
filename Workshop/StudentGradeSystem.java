package Workshop;

import java.util.Arrays;

public class StudentGradeSystem {
    private String[] studentNames;
    private String[] studentIDs;
    private Integer[][] grades; // Using Integer to allow null for missing grades

    public StudentGradeSystem(String[] studentNames, String[] studentIDs, Integer[][] grades) {
        this.studentNames = studentNames;
        this.studentIDs = studentIDs;
        this.grades = grades;
    }

    // Calculate total grade for a student
    public int calculateTotalGrade(int studentIndex) {
        int total = 0;
        for (Integer grade : grades[studentIndex]) {
            if (grade != null) {
                total += grade;
            }
        }
        return total;
    }

    // Calculate average grade for a student
    public double calculateAverageGrade(int studentIndex) {
        int total = 0;
        int count = 0;
        for (Integer grade : grades[studentIndex]) {
            if (grade != null) {
                total += grade;
                count++;
            }
        }
        if (count == 0) return 0.0;
        return (double) total / count;
    }

    // Find highest grade in a subject
    public int highestGradeInSubject(int subjectIndex) {
        int highest = -1;
        for (int i = 0; i < grades.length; i++) {
            Integer grade = grades[i][subjectIndex];
            if (grade != null && grade > highest) {
                highest = grade;
            }
        }
        return highest;
    }

    // Calculate overall class average
    public double overallClassAverage() {
        int total = 0;
        int count = 0;
        for (Integer[] studentGrades : grades) {
            for (Integer grade : studentGrades) {
                if (grade != null) {
                    total += grade;
                    count++;
                }
            }
        }
        if (count == 0) return 0.0;
        return (double) total / count;
    }

    // Validate grades input
    public static void validateGrades(Integer[][] grades) throws IllegalArgumentException {
        for (int i = 0; i < grades.length; i++) {
            for (int j = 0; j < grades[i].length; j++) {
                Integer grade = grades[i][j];
                if (grade != null && (grade < 0 || grade > 100)) {
                    throw new IllegalArgumentException("Grade must be between 0 and 100. Invalid grade at student " + i + ", subject " + j);
                }
            }
        }
    }

    public void displayStudentGrades() {
        for (int i = 0; i < studentNames.length; i++) {
            System.out.println("Student: " + studentNames[i] + " (ID: " + studentIDs[i] + ")");
            System.out.println("Grades: " + Arrays.toString(grades[i]));
            System.out.println("Total Grade: " + calculateTotalGrade(i));
            System.out.printf("Average Grade: %.2f\n", calculateAverageGrade(i));
            System.out.println();
        }
    }

    public static void main(String[] args) {
        String[] names = {"Sohil", "tanuj", "Raj"};
        String[] ids = {"S001", "S002", "S003"};
        Integer[][] grades = {
            {85, 90, 78,88},
            {92, null, 88,65}, // tanuj has a missing grade
            {75, 80, 70,91}
        };

        
            validateGrades(grades);
            StudentGradeSystem sgs = new StudentGradeSystem(names, ids, grades);
            sgs.displayStudentGrades();

            System.out.println("Highest grade in subject 0: " + sgs.highestGradeInSubject(0));
            System.out.println("Highest grade in subject 1: " + sgs.highestGradeInSubject(1));
            System.out.println("Highest grade in subject 2: " + sgs.highestGradeInSubject(2));
            System.out.println("Highest grade in subject 3: " + sgs.highestGradeInSubject(3));

            System.out.printf("Overall class average: %.2f\n", sgs.overallClassAverage());
       
    }
}