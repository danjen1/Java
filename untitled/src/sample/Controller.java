package sample;

import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    public Label theLabel;

    @Override
    public void initialize(URL location, ResourceBundle resources){
        theLabel.setText("Hello");
    }

    public void handleTheButton(ActionEvent actionEvent) {
        theLabel.setText("Hello, Again");
    }
}
