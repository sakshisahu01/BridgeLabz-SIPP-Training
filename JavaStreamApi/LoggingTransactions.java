package JavaStreamApi;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

public class LoggingTransactions {

    public static void main(String[] args) {
        List<String> transactionIds = Arrays.asList(
                "TXN001", "TXN002", "TXN003", "TXN004"
        );

        System.out.println("Logging Transactions:");
        transactionIds.forEach(id -> System.out.println(LocalDateTime.now() + " - Transaction: " + id));
    }
}