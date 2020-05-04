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

/*public class Main {
    private int x;

    public static void main(String[] args) {

        String urlS = "https://samples.openweathermap.org/data/2" +
                ".5/forecast?id=524901&appid=b6907d289e10d714a6e88b30761fae22";
        JSONArray PrognosisJson = new JSONArray();
        try {
            StringBuilder result= new StringBuilder();
            URL url=new URL(urlS);
            System.out.println(urlS);
            URLConnection conn = url.openConnection();
            BufferedReader rd=new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String line;
            while ((line=rd.readLine())!=null){
                result.append(line);
            }
            rd.close();
            //convert to object
            try {
                Object obj = new JSONParser().parse(result.toString());
                // typecasting obj to JSONObject
                JSONObject jo = (JSONObject) obj;
                // getting all data
                PrognosisJson = (JSONArray) jo.get("list");

            }
            catch (Exception e){
                System.out.println(e.getMessage());
            }

        } catch (IOException e){
            System.out.println(e.getMessage());
        }

        JSONObject oneFor=(JSONObject) PrognosisJson.get(0);
        JSONObject jsonObject = (JSONObject) PrognosisJson.get(0);
        //System.out.println(jsonObject);
        // Experiments
        JSONArray weather = (JSONArray) jsonObject.get("weather");
        JSONObject mainObj = (JSONObject) jsonObject.get("main");
        JSONObject weatherObj = (JSONObject)weather.get(0);
        System.out.println(mainObj);
        System.out.println(weatherObj.get("main"));



    }
}*/

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("wewidget.fxml"));
        primaryStage.setTitle("Weather Checker v.1.0");
        primaryStage.setScene(new Scene(root, 1300, 625));
        //GetWeatherData LocalWeather = new GetWeatherData();
        //GetWeatherData DestWeather = new GetWeatherData();



        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);

    }
}
