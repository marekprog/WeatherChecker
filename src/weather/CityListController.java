package weather;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by marek an 21.10.2019.
 */
public class CityListController implements Initializable {

    @FXML
    private Label LabelCity;

    @FXML
    private ListView<String> ListCities = new ListView<String>();

    @FXML
    private Button Submit;

    @FXML
    public void selectCity(){

        System.out.println("selected a city"+ListCities.getSelectionModel().getSelectedItem());}

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
    }

    public void makeCityList(String CityName){
        LabelCity.setText(CityName);
        CityHandler cityLocal = new CityHandler(CityName);
        String[] CityList=cityLocal.printCityList(cityLocal.getCityList());
        ObservableList<String> items = FXCollections.observableArrayList (CityList);
        ListCities.setItems(items);
    }
}
