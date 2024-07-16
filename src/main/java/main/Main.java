package main;
import javafx.application.Application;
import javafx.stage.Stage;
import view.CurrencyConverterView;
public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage primaryStage) {
        CurrencyConverterView view = new CurrencyConverterView();
        view.start(primaryStage);
    }
}
