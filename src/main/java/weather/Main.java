package weather;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("wewidget.fxml"));
        primaryStage.setTitle("Weather Checker v.1.0");
        primaryStage.setScene(new Scene(root, 1300, 625));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);

    }
}
