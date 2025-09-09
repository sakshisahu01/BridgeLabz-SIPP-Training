import java.io.*;
import java.util.*;

// Custom Exception
class InvalidStockQuantityException extends Exception {
    public InvalidStockQuantityException(String message) {
        super(message);
    }
}

// Stock class
class Stock implements Serializable {
    private String symbol;
    private int quantity;
    private double pricePerShare;

    public Stock(String symbol, int quantity, double pricePerShare) {
        this.symbol = symbol;
        this.quantity = quantity;
        this.pricePerShare = pricePerShare;
    }

    public String getSymbol() {
        return symbol;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getPricePerShare() {
        return pricePerShare;
    }

    public double getTotalValue() {
        return quantity * pricePerShare;
    }

    @Override
    public String toString() {
        return symbol + " -> Quantity: " + quantity +
                ", Price: " + pricePerShare +
                ", Value: " + getTotalValue();
    }
}

public class StockPortfolio {
    public static void main(String[] args) {
        String inputFile = "portfolio.txt";           // Input: stockSymbol, quantity, pricePerShare
        String summaryFile = "portfolio_summary.txt"; // Output file

        HashMap<String, Stock> portfolio = new HashMap<>();
        double totalValue = 0.0;

        try (BufferedReader br = new BufferedReader(new FileReader(inputFile))) {
            String line;

            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                String symbol = parts[0].trim();
                int quantity = Integer.parseInt(parts[1].trim());
                double price = Double.parseDouble(parts[2].trim());

                try {
                    if (quantity < 0) {
                        throw new InvalidStockQuantityException(
                                "Invalid quantity for stock " + symbol + ": " + quantity
                        );
                    }

                    Stock stock = new Stock(symbol, quantity, price);
                    portfolio.put(symbol, stock);
                    totalValue += stock.getTotalValue();

                } catch (InvalidStockQuantityException e) {
                    System.out.println("⚠ " + e.getMessage());
                }
            }

            // Write summary to file
            writeSummary(portfolio, totalValue, summaryFile);

            System.out.println("✅ Portfolio summary created in " + summaryFile);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Write portfolio summary
    private static void writeSummary(HashMap<String, Stock> portfolio, double totalValue, String fileName) throws IOException {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(fileName))) {
            bw.write("----- Portfolio Summary -----");
            bw.newLine();
            for (Stock stock : portfolio.values()) {
                bw.write(stock.toString());
                bw.newLine();
            }
            bw.write("-----------------------------");
            bw.newLine();
            bw.write("Total Portfolio Value: " + totalValue);
        }
    }
}
