package weather;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

import com.sun.prism.shader.Solid_TextureYV12_AlphaTest_Loader;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

//import com.google.gson.*;
//import com.google.gson.reflect.*;

/**
 * Created by marek an 18.10.2019.
 */
public class WeatherHandler {
    private static String API_KEY = "1948f4846ad801580c470dc03af314bc";
    String LOCATION = "Kraków";
    private String LAT;
    private String LON;
    private JSONArray PrognosisJson = new JSONArray();
    private Vector<WObs> Forecast = new Vector<WObs>();

    String  createUrlString(){
        return "http://api.openweathermap.org/data/2.5/forecast?lat="+LAT+"&lon="+LON+"&appid="+API_KEY+"&units" +
                "=metric";
    }


    public WeatherHandler(String LAT, String LON) {
        this.LAT = LAT;
        this.LON = LON;
    }

    String getAPI_KEY(){return API_KEY;};
    String getWeather(){
        String report;
        try {
        StringBuilder result= new StringBuilder();
        URL url=new URL(createUrlString());
        //System.out.println(createUrlString());
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
            this.ParseForecast();
            return "ok";

        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }

        } catch (IOException e){
        System.out.println(e.getMessage());
        }
        return "ok";
    }

    public void ParseForecast(){
        System.out.println("Parse forecast"+ Integer.toString(PrognosisJson.size()));
        for (int i = 0; i < PrognosisJson.size(); i++) {
            JSONObject jsonObject = (JSONObject) PrognosisJson.get(i);
            WObs singleObservation = new WObs(jsonObject);
            singleObservation.setALL();
            Forecast.add(singleObservation);
        }
    }


    public String getLAT() {
        return LAT;
    }

    public void setLAT(String LAT) {
        this.LAT = LAT;
    }

    public String getLON() {
        return LON;
    }

    public void setLON(String LON) {
        this.LON = LON;
    }
    public Vector<WObs> getForecast(){
        return Forecast;
    }
}
