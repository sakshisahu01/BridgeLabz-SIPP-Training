import java.util.*;

class Question1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int rows = sc.nextInt();
        int cols = sc.nextInt();
        int[][] matrix = new int[rows][cols];
        for(int i = 0; i < rows; i++)
            for(int j = 0; j < cols; j++)
                matrix[i][j] = sc.nextInt();
        int[] array = new int[rows * cols];
        int index = 0;
        for(int i = 0; i < rows; i++)
            for(int j = 0; j < cols; j++)
                array[index++] = matrix[i][j];
        for(int i : array)
            System.out.print(i + " ");
    }
}
