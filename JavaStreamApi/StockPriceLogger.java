package JavaStreamApi;

import java.util.Arrays;
import java.util.List;

public class StockPriceLogger {

    public static void main(String[] args) {
        List<Double> stockPrices = Arrays.asList(150.25, 151.00, 149.80, 152.50, 150.90);

        System.out.println("Live Stock Price Feed:");
        stockPrices.forEach(price -> System.out.println("New Stock Price: " + price));
    }
}