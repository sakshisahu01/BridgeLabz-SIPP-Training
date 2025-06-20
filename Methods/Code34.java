import java.util.Random;

public class FootballTeamHeightStats {
    public static void main(String[] args) {
        int[] heights = generateRandomHeights(11);

        System.out.print("Player Heights (in cm): ");
        for (int height : heights) {
            System.out.print(height + " ");
        }
        System.out.println();

        int sum = calculateSum(heights);
        double mean = calculateMean(heights);
        int shortest = findShortest(heights);
        int tallest = findTallest(heights);

        System.out.println("Shortest Height: " + shortest + " cm");
        System.out.println("Tallest Height: " + tallest + " cm");
        System.out.println("Mean Height: " + mean + " cm");
    }

    public static int[] generateRandomHeights(int size) {
        Random rand = new Random();
        int[] heights = new int[size];
        for (int i = 0; i < size; i++) {
            heights[i] = rand.nextInt(101) + 150; // 150 to 250
        }
        return heights;
    }

    public static int calculateSum(int[] array) {
        int sum = 0;
        for (int num : array) {
            sum += num;
        }
        return sum;
    }

    public static double calculateMean(int[] array) {
        return (double) calculateSum(array) / array.length;
    }

    public static int findShortest(int[] array) {
        int min = array[0];
        for (int num : array) {
            if (num < min)
                min = num;
        }
        return min;
    }

    public static int findTallest(int[] array) {
        int max = array[0];
        for (int num : array) {
            if (num > max)
                max = num;
        }
        return max;
    }
}
