package model;
import java.util.HashMap;
import java.util.Map;
public class CurrencyDataFetcher {
    public Map<String, Double> fetchExchangeRates() {
        // Simulación de obtención de tasas de cambio
        Map<String, Double> exchangeRates = new HashMap<>();
        exchangeRates.put("USD", 1.0);
        exchangeRates.put("EUR", 0.85);
        exchangeRates.put("JPY", 110.0);
        return exchangeRates;
    }
}