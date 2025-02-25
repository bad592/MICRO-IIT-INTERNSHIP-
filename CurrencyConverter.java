import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CurrencyConverter {
    private static Map<String, Double> exchangeRates = new HashMap<>();

    public static void main(String[] args) {
        // Simulate exchange rates (relative to USD)
        exchangeRates.put("USD", 1.0);
        exchangeRates.put("EUR", 0.85);
        exchangeRates.put("GBP", 0.73);
        exchangeRates.put("JPY", 145.20);

        Scanner scanner = new Scanner(System.in);

        // Get user input
        System.out.println("Welcome to the Currency Converter!");
        System.out.print("Enter amount: ");
        double amount = scanner.nextDouble();

        System.out.print("Enter source currency (e.g., USD, EUR, GBP, JPY): ");
        String fromCurrency = scanner.next().toUpperCase();

        System.out.print("Enter target currency (e.g., USD, EUR, GBP, JPY): ");
        String toCurrency = scanner.next().toUpperCase();

        // Perform conversion
        double result = convertCurrency(amount, fromCurrency, toCurrency);
        
        // Display result
        if (result != -1) {
            System.out.printf("%.2f %s = %.2f %s%n", amount, fromCurrency, result, toCurrency);
        } else {
            System.out.println("Invalid currency code entered.");
        }

        scanner.close();
    }

    private static double convertCurrency(double amount, String from, String to) {
        // Check if currencies exist in our map
        if (!exchangeRates.containsKey(from) || !exchangeRates.containsKey(to)) {
            return -1;
        }

        // Convert amount to USD first (base currency), then to target currency
        double amountInUSD = amount / exchangeRates.get(from);
        double convertedAmount = amountInUSD * exchangeRates.get(to);

        return convertedAmount;
    }
}