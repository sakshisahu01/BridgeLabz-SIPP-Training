import java.util.Random;

class MatrixOperations
{

    public static int[][] createRandomMatrix(int rows, int cols)
	{
        Random rand = new Random();
        int[][] matrix = new int[rows][cols];
        for (int i = 0; i < rows; i++)
            for (int j = 0; j < cols; j++)
                matrix[i][j] = rand.nextInt(10);
        return matrix;
    	}

    public static int[][] addMatrices(int[][] a, int[][] b)
	{
        int rows = a.length;
        int cols = a[0].length;
        int[][] result = new int[rows][cols];
        for (int i = 0; i < rows; i++)
            for (int j = 0; j < cols; j++)
                result[i][j] = a[i][j] + b[i][j];
        return result;
    	}

    public static int[][] subtractMatrices(int[][] a, int[][] b)
	{
        int rows = a.length;
        int cols = a[0].length;
        int[][] result = new int[rows][cols];
        for (int i = 0; i < rows; i++)
            for (int j = 0; j < cols; j++)
                result[i][j] = a[i][j] - b[i][j];
        return result;
    	}

    public static int[][] multiplyMatrices(int[][] a, int[][] b)
	{
        int rows = a.length;
        int cols = b[0].length;
        int common = a[0].length;
        int[][] result = new int[rows][cols];
        for (int i = 0; i < rows; i++)
            for (int j = 0; j < cols; j++)
                for (int k = 0; k < common; k++)
                    result[i][j] += a[i][k] * b[k][j];
        return result;
    	}

    public static void printMatrix(int[][] matrix)
	{
        for (int[] row : matrix)
		{
            		for (int val : row)
                		System.out.print(val + " ");
            			System.out.println();
        	}
        	System.out.println();
    	}

    public static void main(String[] args)
	{
        int rows = 3;
        int cols = 3;

        int[][] matrixA = createRandomMatrix(rows, cols);
        int[][] matrixB = createRandomMatrix(rows, cols);
        int[][] matrixC = createRandomMatrix(cols, rows);

        System.out.println("Matrix A:");
        printMatrix(matrixA);

        System.out.println("Matrix B:");
        printMatrix(matrixB);

        System.out.println("Addition (A + B):");
        printMatrix(addMatrices(matrixA, matrixB));

        System.out.println("Subtraction (A - B):");
        printMatrix(subtractMatrices(matrixA, matrixB));

        System.out.println("Multiplication (A x C):");
        printMatrix(multiplyMatrices(matrixA, matrixC));
        }
}
