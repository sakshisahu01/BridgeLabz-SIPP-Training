package Workshop;

public class EduQuizGrader {

    // Method to calculate score and print feedback
    public static int calculateScore(String[] correctAnswers, String[] studentAnswers) {
        int score = 0;

        System.out.println("Quiz Feedback:");
        System.out.println("--------------");

        for (int i = 0; i < correctAnswers.length; i++) {
            if (correctAnswers[i].equalsIgnoreCase(studentAnswers[i])) {
                System.out.println("Question " + (i + 1) + ": Correct");
                score++;
            } else {
                System.out.println("Question " + (i + 1) + ": Incorrect (Correct: " 
                    + correctAnswers[i] + ", Your Answer: " + studentAnswers[i] + ")");
            }
        }

        return score;
    }

    // Main method for testing
    public static void main(String[] args) {
        // Sample correct answers
        String[] correctAnswers = {
            "A", "B", "C", "D", "A", "B", "C", "D", "A", "B"
        };

        // Sample student answers
        String[] studentAnswers = {
            "a", "b", "D", "d", "A", "c", "C", "D", "B", "b"
        };

        // Calculate score
        int score = calculateScore(correctAnswers, studentAnswers);
        System.out.println("\nTotal Score: " + score + " / " + correctAnswers.length);
    }
}

