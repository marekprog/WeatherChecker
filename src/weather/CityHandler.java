package weather;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.sql.Struct;
import java.util.Iterator;
import java.util.Stack;
import java.util.Vector;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
/**
 * Created by marek an 21.10.2019.
 */
public class CityHandler {
    String location = "";
    String urlString="";//"https://nominatim.openstreetmap.org/?format=json&city="+location.replaceAll("\\s","+");

    private Vector<City> cities = new Vector<City>();
    private City selectedCity = new City();

    public CityHandler(String cityName){
        this.location=cityName;
        this.urlString="https://nominatim.openstreetmap.org/?format=json&city="+location.replaceAll("\\s","+");
    }

    public void setUrlString(){
        this.urlString="https://nominatim.openstreetmap.org/?format=json&city="+location.replaceAll("\\s","+");
    }

    public void selectCity(int index){
        selectedCity=cities.elementAt(index);
    }

    Vector<City> getCityList() {
        String report;
        JSONArray ja = null;
        cities.clear();
        try {
            StringBuilder result = new StringBuilder();
            URL url = new URL(urlString);
            URLConnection conn = url.openConnection();
            BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String line;
            while ((line = rd.readLine()) != null) {
                result.append(line);
            }
            rd.close();
            //convert to object
            try {
                Object obj = new JSONParser().parse(result.toString());
                ja = (JSONArray) obj;
                for (int i = 0; i < ja.size(); i++) {
                    JSONObject jsonObject = (JSONObject) ja.get(i);
                    City city = new City();
                    city.CityName=(String)jsonObject.get("display_name");
                    city.lat=(String)jsonObject.get("lat");
                    city.lon=(String)jsonObject.get("lon");
                    cities.addElement(city);

                }

            } catch (Exception e) {
                System.out.println("failed to convert object");
                System.out.println(e.getMessage());
            }

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return cities;
    }
    void setCityName(String cityName){
        location = cityName;
    }
    String getCityName(){
        return selectedCity.CityName;
    }
    String getLat(){
        return selectedCity.lat;
    }
    String getLon(){
        return selectedCity.lon;
    }
    String[] printCityList(){
        String[] ListOfCities = new String[cities.size()];
        Iterator<City> iterator = cities.iterator();
        int index=0;
        while (iterator.hasNext()){
            ListOfCities[index]=iterator.next().CityName;
            index++;

        }
        return ListOfCities;

    }
}
