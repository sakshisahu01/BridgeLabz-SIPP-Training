import java.util.*;

public class SearchDataStructureComparison {

    // Linear search in array
    public static boolean linearSearch(int[] arr, int target) {
        for (int num : arr) {
            if (num == target) return true;
        }
        return false;
    }

    // Generate array with random integers
    public static int[] generateArray(int size, int bound) {
        Random rand = new Random();
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = rand.nextInt(bound);
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] sizes = {1000, 100000, 1000000};

        for (int size : sizes) {
            System.out.println("Dataset Size: " + size);

            int[] data = generateArray(size, size * 2);
            int target = data[size / 2]; // Pick a target that exists

            // Array (Linear Search)
            long startArray = System.nanoTime();
            linearSearch(data, target);
            long endArray = System.nanoTime();
            System.out.println("Array Search Time: " + (endArray - startArray) / 1_000_000.0 + " ms");

            // HashSet Search
            HashSet<Integer> hashSet = new HashSet<>();
            for (int num : data) hashSet.add(num);
            long startHashSet = System.nanoTime();
            hashSet.contains(target);
            long endHashSet = System.nanoTime();
            System.out.println("HashSet Search Time: " + (endHashSet - startHashSet) / 1_000_000.0 + " ms");

            // TreeSet Search
            TreeSet<Integer> treeSet = new TreeSet<>();
            for (int num : data) treeSet.add(num);
            long startTreeSet = System.nanoTime();
            treeSet.contains(target);
            long endTreeSet = System.nanoTime();
            System.out.println("TreeSet Search Time: " + (endTreeSet - startTreeSet) / 1_000_000.0 + " ms");

            System.out.println("-----------");
        }
    }
}
