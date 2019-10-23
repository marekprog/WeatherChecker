package weather;

import org.json.simple.JSONObject;

/**
 * Created by marek an 23.10.2019.
 */
public class WObs {
    private int dt;
    private String dt_txt;
    private String icon;
    private String description;
    private String main;
    private String id;
    private double temp;
    private double temp_min;
    private int ground_level;
    private double temp_kf;
    private int humidity;
    private int pressure;
    private int sea_level;
    private double temp_max;
    private int wind_deg;
    private double wind_speed;

    private JSONObject obsJson;


}
