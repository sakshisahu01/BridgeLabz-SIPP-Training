    package JavaStreamApi;

import java.util.Arrays;
import java.util.List;

public class IoTSensorReadings {

    public static void main(String[] args) {
        List<Double> sensorReadings = Arrays.asList(22.5, 25.1, 19.8, 28.3, 23.0, 30.5);
        double threshold = 25.0;

        System.out.println("Sensor Readings Above Threshold (" + threshold + "):");
        sensorReadings.stream()
                .filter(reading -> reading > threshold)
                .forEach(reading -> System.out.println("High Reading: " + reading));
    }
}