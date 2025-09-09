import java.io.*;
import java.util.*;

// Custom Exception
class CourseFullException extends Exception {
    public CourseFullException(String message) {
        super(message);
    }
}

public class CourseEnrollment {
    private static final int MAX_STUDENTS = 50;

    public static void main(String[] args) {
        // enrollment data file (simulate input file: studentId,courseName)
        String inputFile = "enrollment.txt";  
        String fullCoursesFile = "full_courses.txt";
        String serializedFile = "enrollments.ser";

        HashMap<String, List<Integer>> courseMap = new HashMap<>();

        try (BufferedReader br = new BufferedReader(new FileReader(inputFile))) {
            String line;

            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                int studentId = Integer.parseInt(parts[0].trim());
                String courseName = parts[1].trim();

                try {
                    enrollStudent(courseMap, studentId, courseName);
                } catch (CourseFullException e) {
                    System.out.println("⚠ " + e.getMessage());
                }
            }

            // Write full courses to text file
            writeFullCourses(courseMap, fullCoursesFile);

            // Serialize remaining enrollments
            serializeEnrollments(courseMap, serializedFile);

            System.out.println("✅ Enrollment process completed.");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Method to enroll student
    private static void enrollStudent(HashMap<String, List<Integer>> map, int studentId, String courseName) throws CourseFullException {
        map.putIfAbsent(courseName, new ArrayList<>());

        List<Integer> students = map.get(courseName);

        if (students.size() >= MAX_STUDENTS) {
            throw new CourseFullException("Course " + courseName + " is full (50 students). Student " + studentId + " not added.");
        }

        students.add(studentId);
    }

   
    private static void writeFullCourses(HashMap<String, List<Integer>> map, String fileName) throws IOException {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(fileName))) {
            for (Map.Entry<String, List<Integer>> entry : map.entrySet()) {
                if (entry.getValue().size() >= MAX_STUDENTS) {
                    bw.write("Course: " + entry.getKey() + " -> Students: " + entry.getValue());
                    bw.newLine();
                }
            }
        }
    }


    private static void serializeEnrollments(HashMap<String, List<Integer>> map, String fileName) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {
            oos.writeObject(map);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
