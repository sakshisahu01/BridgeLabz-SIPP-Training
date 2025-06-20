import java.util.Scanner;

class StudentVoteChecker
{
	public boolean canStudentVote(int age)
	{
        	if (age < 0)
		{
            		return false;
                }
        return age >= 18;
        }

    public static void main(String[] args)
	{
        Scanner scanner = new Scanner(System.in);
        StudentVoteChecker checker = new StudentVoteChecker();

        int[] studentAges = new int[10];

        System.out.println("Enter the age of 10 students:");

        for (int i = 0; i < studentAges.length; i++) {
            System.out.print("Age of student " + (i + 1) + ": ");
            studentAges[i] = scanner.nextInt();

            boolean canVote = checker.canStudentVote(studentAges[i]);

            if (studentAges[i] < 0) {
                System.out.println("Invalid age entered.");
            } else if (canVote) {
                System.out.println("Student " + (i + 1) + " is eligible to vote.");
            } else {
                System.out.println("Student " + (i + 1) + " is not eligible to vote.");
            }
        }
    }
}
