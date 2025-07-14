public class StringBufferVsStringBuilder {

    private static final int NUM_OPERATIONS = 1_000_000;

    public static void main(String[] args) {
        System.out.println("Performance Comparison: StringBuffer vs. StringBuilder");
        System.out.println("Number of operations: " + NUM_OPERATIONS);

        // Measure StringBuffer performance
        long startTimeBuffer = System.nanoTime();
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < NUM_OPERATIONS; i++) {
            stringBuffer.append("hello");
        }
        long endTimeBuffer = System.nanoTime();
        long durationBuffer = (endTimeBuffer - startTimeBuffer) / 1_000_000; // milliseconds
        System.out.println("StringBuffer Time: " + durationBuffer + " ms");

        // Measure StringBuilder performance
        long startTimeBuilder = System.nanoTime();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < NUM_OPERATIONS; i++) {
            stringBuilder.append("hello");
        }
        long endTimeBuilder = System.nanoTime();
        long durationBuilder = (endTimeBuilder - startTimeBuilder) / 1_000_000; // milliseconds
        System.out.println("StringBuilder Time: " + durationBuilder + " ms");

        System.out.println("\nExpected Result: StringBuilder is generally faster than StringBuffer in single-threaded environments because it is not synchronized.");
    }
}