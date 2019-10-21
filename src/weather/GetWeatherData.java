package weather;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.util.HashMap;
import java.util.Map;

//import com.google.gson.*;
//import com.google.gson.reflect.*;

/**
 * Created by marek an 18.10.2019.
 */
public class GetWeatherData {
    private static String API_KEY = "1948f4846ad801580c470dc03af314bc";
    String LOCATION = "Kraków";

    String urlString=
            "http://api.openweathermap.org/data/2.5/forecast?q="+LOCATION+",pl"+"&appid="+API_KEY+"&units" +
                    "=metric";

    String getAPI_KEY(){return API_KEY;};
    String getWeather(){
        String report;
        try {
        StringBuilder result= new StringBuilder();
        URL url=new URL(urlString);
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
            JSONArray ja = (JSONArray) jo.get("list");
            System.out.println(ja);

        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }

        } catch (IOException e){
        System.out.println(e.getMessage());
        }
        return "ok";
    }


}
