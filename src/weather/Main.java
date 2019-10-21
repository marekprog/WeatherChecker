package weather;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;




public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("wewidget.fxml"));
        primaryStage.setTitle("Weather Checker v.1.0");
        primaryStage.setScene(new Scene(root, 600, 400));
        GetWeatherData localweather = new GetWeatherData();
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
