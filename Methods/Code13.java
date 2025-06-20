class RandomStats
{
    public int[] generate4DigitRandomArray(int size)
	{
        int[] randomNumbers = new int[size];
        for (int i = 0; i < size; i++) {
            randomNumbers[i] = (int)(Math.random() * 9000) + 1000; 
        }
        return randomNumbers;
    }

    public double[] findAverageMinMax(int[] numbers) {
        int min = numbers[0];
        int max = numbers[0];
        int sum = 0;

        for (int num : numbers) {
            sum += num;
            min = Math.min(min, num);
            max = Math.max(max, num);
        }

        double average = (double) sum / numbers.length;
        return new double[]{average, min, max};
    }

    public static void main(String[] args)
	{
        RandomStats stats = new RandomStats();

        int[] randomValues = stats.generate4DigitRandomArray(5);
        System.out.println("Generated 4-digit random numbers:");
        for (int value : randomValues) {
            System.out.println(value);
        }

        double[] results = stats.findAverageMinMax(randomValues);
        System.out.println("Average: " + results[0]);
        System.out.println("Minimum: " + results[1]);
        System.out.println("Maximum: " + results[2]);
       }
}
