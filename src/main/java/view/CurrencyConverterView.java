package view;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import model.CurrencyConverter;
import model.CurrencyDataFetcher;
public class CurrencyConverterView extends Application {
    @Override
    public void start(Stage primaryStage) {
        // Crear componentes de la interfaz
        Label amountLabel = new Label("Monto:");
        TextField amountField = new TextField();
        Label fromCurrencyLabel = new Label("De:");
        ComboBox<String> fromCurrencyBox = new ComboBox<>();
        fromCurrencyBox.getItems().addAll("USD", "EUR", "JPY");
        Label toCurrencyLabel = new Label("A:");
        ComboBox<String> toCurrencyBox = new ComboBox<>();
        toCurrencyBox.getItems().addAll("USD", "EUR", "JPY");
        Button convertButton = new Button("Convertir");
        Label resultLabel = new Label();
        // Configurar layout
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10, 10, 10, 10));
        grid.setVgap(8);
        grid.setHgap(10);
        GridPane.setConstraints(amountLabel, 0, 0);
        GridPane.setConstraints(amountField, 1, 0);
        GridPane.setConstraints(fromCurrencyLabel, 0, 1);
        GridPane.setConstraints(fromCurrencyBox, 1, 1);
        GridPane.setConstraints(toCurrencyLabel, 0, 2);
        GridPane.setConstraints(toCurrencyBox, 1, 2);
        GridPane.setConstraints(convertButton, 1, 3);
        GridPane.setConstraints(resultLabel, 1, 4);
        grid.getChildren().addAll(amountLabel, amountField, fromCurrencyLabel, fromCurrencyBox, toCurrencyLabel, toCurrencyBox, convertButton, resultLabel);
        // Configurar acción del botón
        convertButton.setOnAction(e -> {
            try {
                double amount = Double.parseDouble(amountField.getText());
                String fromCurrency = fromCurrencyBox.getValue();
                String toCurrency = toCurrencyBox.getValue();
                CurrencyDataFetcher dataFetcher = new CurrencyDataFetcher();
                CurrencyConverter converter = new CurrencyConverter(dataFetcher.fetchExchangeRates());
                double result = converter.convert(amount, fromCurrency, toCurrency);
                resultLabel.setText(String.format("%.2f %s = %.2f %s", amount, fromCurrency, result, toCurrency));
            } catch (NumberFormatException ex) {
                resultLabel.setText("Por favor, ingrese un número válido.");
            } catch (NullPointerException ex) {
                resultLabel.setText("Por favor, seleccione las monedas.");
            }
        });
        // Crear escena y mostrar
        Scene scene = new Scene(grid, 300, 200);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Conversor de Monedas");
        primaryStage.show();
    }
}