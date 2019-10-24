package weather;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

/**
 * Created by marek an 23.10.2019.
 */
public class WObs {
    private Integer dt;
    private String dt_txt;
    private String icon;
    private String description;
    private String main;
    private String id;
    private String temp;
    private Double temp_min;
    private Integer ground_level;
    private Double temp_kf;
    private Integer humidity;
    private Integer pressure;
    private Integer sea_level;
    private Double temp_max;
    private Integer wind_deg;
    private Double wind_speed;

    JSONObject observJson;
    JSONObject weatherJson;
    JSONObject mainJson;

    public WObs(JSONObject obsJson) {
        this.observJson=obsJson;
        JSONArray weather = (JSONArray) observJson.get("weather");
        this.weatherJson = (JSONObject)weather.get(0);
        this.mainJson=(JSONObject)observJson.get("main");

    }

    public void setALL(){
        //dt= (int)observJson.get("dt");
        dt_txt= (String)observJson.get("dt_txt");
        temp=mainJson.get("temp").toString();
        icon=(String) weatherJson.get("icon");
    }


    public int getDt() {
        return dt;
    }

    public String getDt_txt() {
        return dt_txt;
    }

    public String getIcon() {
        return icon;
    }

    public String getDescription() {
        return description;
    }

    public String getMain() {
        return main;
    }

    public String getId() {
        return id;
    }

    public String getTemp() {
        return temp;
    }

    public double getTemp_min() {
        return temp_min;
    }

    public int getGround_level() {
        return ground_level;
    }

    public double getTemp_kf() {
        return temp_kf;
    }

    public int getHumidity() {
        return humidity;
    }

    public int getPressure() {
        return pressure;
    }

    public int getSea_level() {
        return sea_level;
    }

    public double getTemp_max() {
        return temp_max;
    }

    public int getWind_deg() {
        return wind_deg;
    }

    public double getWind_speed() {
        return wind_speed;
    }

}
