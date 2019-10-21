package weather;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class Controller {



    @FXML
    private Label weatherhome;

    @FXML
    private TextField city1= new TextField();

    @FXML
    public void getHomeWeather(){
        try{
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("CitySelector.fxml"));
            Parent root1=(Parent)fxmlLoader.load();
            CityListController controller = fxmlLoader.getController();
            controller.makeCityList(city1.getText());
            Stage stage =new Stage();
            stage.setTitle("City selector");
            stage.setScene(new Scene(root1));
            stage.show();
        }
        catch(Exception e) {
            System.out.println("cant load new window");
        }
    }
}
