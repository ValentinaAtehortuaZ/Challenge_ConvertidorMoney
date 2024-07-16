package model;
import java.util.Map;
public class CurrencyConverter {
    private Map<String, Double> exchangeRates;
    public CurrencyConverter(Map<String, Double> exchangeRates) {
        this.exchangeRates = exchangeRates;
    }
    public double convert(double amount, String fromCurrency, String toCurrency) {
        double fromRate = exchangeRates.get(fromCurrency);
        double toRate = exchangeRates.get(toCurrency);
        return amount * (toRate / fromRate);
    }
}