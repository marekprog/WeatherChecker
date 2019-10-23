package weather;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Control;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.Arrays;
import java.util.ResourceBundle;

/**
 * Created by marek an 21.10.2019.
 */
public class CityListController implements Initializable {

    private boolean Selection;
    @FXML
    private Label LabelCity;

    @FXML
    private ListView<String> ListCities = new ListView<String>();

    @FXML
    private Button Submit;

    @FXML
    public void selectCity(){
        Stage closeWindow= (Stage) Submit.getScene().getWindow();
        closeWindow.close();
        System.out.println(ListCities.getSelectionModel().getSelectedIndex());
        if (Selection==true)
            Controller.Home.selectCity(ListCities.getSelectionModel().getSelectedIndex());
        else
            Controller.Destination.selectCity(ListCities.getSelectionModel().getSelectedIndex());
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("wewidget.fxml"));
        try {
            Parent root1=fxmlLoader.load();
            Controller controller = fxmlLoader.getController();
            Stage stage =new Stage();
            stage.setTitle("City selector");
            stage.setScene(new Scene(root1));
            stage.show();



        }
        catch (IOException ex){
            System.out.println("error");
        }


    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
    }

    public void makeCityList(String CityName){
        LabelCity.setText(CityName);
        CityHandler cityLocal = new CityHandler(CityName);
        //String [] CityList;
        System.out.println(CityName);
        String [] CityList;
        if (Selection==true) {
            Controller.Home.setCityName(CityName);
            Controller.Home.setUrlString();
            System.out.println(Controller.Home.getCityName());
            Controller.Home.getCityList();
            //CityList = Controller.Home.printCityList();
            ObservableList<String> items = FXCollections.observableArrayList (Controller.Home.printCityList());
            ListCities.setItems(items);
            //CityList = Controller.Home.printCityList();
        }
        else {
            Controller.Destination.setCityName(CityName);
            Controller.Destination.setUrlString();
            System.out.println(Controller.Destination.getCityName());
            Controller.Destination.getCityList();
            //CityList = Controller.Destination.printCityList();
            ObservableList<String> items = FXCollections.observableArrayList (Controller.Destination.printCityList());
            ListCities.setItems(items);
        }

    }
    public void setSelection(boolean selection){
        Selection=selection;
    }
}
