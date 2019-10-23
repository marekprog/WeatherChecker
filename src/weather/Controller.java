package weather;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    static CityHandler Home = new CityHandler("");
    static CityHandler Destination = new CityHandler("");

    @FXML
    public Label weatherhome=new Label();

    @FXML
    private Label weatherDest=new Label();

    @FXML Button SubmitHome;
    @FXML Button SubmitDest;

    @FXML
    private TextField city1= new TextField();

    @FXML
    private TextField city2= new TextField();

    @FXML
    public void getHomeWeather(){getWeather(city1.getText(),SubmitHome,true);
        //weatherhome.setText(Home.getCityName(),SubmitDest);
    }

    @FXML
    public void getDestWeather(){getWeather(city2.getText(),SubmitDest,false);}

    @FXML
    public void getWeather(String city, Button button,boolean select){

        try{
            Stage closeWindow= (Stage) button.getScene().getWindow();
            closeWindow.close();
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("CitySelector.fxml"));
            Parent root1=fxmlLoader.load();
            CityListController controller = fxmlLoader.getController();
            controller.setSelection(select);
            controller.makeCityList(city);


            Stage stage =new Stage();
            stage.setTitle("City selector");
            stage.setScene(new Scene(root1));
            stage.show();

        }
        catch(Exception e) {
            System.out.println("cant load new window");
        }
    }

    @FXML
    public void setWeatherhome(){
        //Home.setCityName(getHomeWeather());
        weatherhome.setText(Home.getCityName());
        //System.out.println("Set weather");
    }

    private void init(){
        WeatherHandler localW= new WeatherHandler(Home.getLat(),Home.getLon());
        WeatherHandler destW= new WeatherHandler(Destination.getLat(),Destination.getLon());
        weatherhome.setText(localW.getWeather());
        localW.ParseForecast();
        weatherDest.setText(destW.getWeather());
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        init();
    }



    @FXML
    public void setWeatherDest(String cityName){
        weatherDest.setText(cityName);
    }


}
