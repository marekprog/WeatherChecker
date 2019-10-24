package weather;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

import javax.swing.*;
import java.net.URL;
import java.security.spec.ECField;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    static CityHandler Home = new CityHandler("");
    static CityHandler Destination = new CityHandler("");

    @FXML
    public Label weatherhome=new Label();

    @FXML
    private Label weatherDest=new Label();

    @FXML
    private GridPane GridUp= new GridPane();

    @FXML
    private GridPane GridDown= new GridPane();

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
        weatherhome.setText(Home.getCityName());
    }
    @FXML
    public void publishWeather(WeatherPlot wplot,GridPane grid){
        try {
            for (int i = 0; i < 10; i++) {
                Label date = new Label();
                date.setText(wplot.widgets[i].getPrettyDate());
                date.setWrapText(true);
                date.setTextAlignment(TextAlignment.CENTER);
                date.setTextFill(Color.web("#ffffff"));
                Image icon= new Image("http://openweathermap.org/img/wn/"+wplot.widgets[i].getIcon()+"@2x.png");
                Label temp= new Label();
                temp.setText(wplot.widgets[i].getTemp()+" °C");
                temp.setTextFill(Color.web("#ffffff"));
                grid.add(date, i, 0);
                grid.add(new ImageView(icon), i, 1);
                grid.add(temp, i, 2);
            }
        }
        catch (Exception e){
            System.out.println("Weather plot not set");
        }
    }

    private void init(){
        WeatherHandler localW= new WeatherHandler(Home.getLat(),Home.getLon());
        WeatherHandler destW= new WeatherHandler(Destination.getLat(),Destination.getLon());
        localW.getWeather();
        destW.getWeather();
        weatherhome.setText(Home.getCityName());
        weatherDest.setText(Destination.getCityName());
        WeatherPlot local= new WeatherPlot(localW.getForecast());
        local.setObservations();
        local.setWidgets(localW.getForecast());
        publishWeather(local,GridUp);
        WeatherPlot dest= new WeatherPlot(destW.getForecast());
        dest.setObservations();
        dest.setWidgets(destW.getForecast());
        publishWeather(dest,GridDown);

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
