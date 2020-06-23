package View_Controller;

import Model.Advisor;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class AddAdvisor implements Initializable {
    private TextField advisorAddAddressTextField;
    public TextField advisorAddBdayTextField;
    public TextField advisorAddHireDateTextField;
    public TextField advisorAddEmailTextField;
    public TextField advisorAddPhoneTextField;
    public TextField advisorModifyShiftTextField;
    public TextField advisorAddEIDTextField;
    public TextField advisorAddDSIDTextField;
    public TextField advisorAddNameTextField;
    public ComboBox<String> advisorAddTimeZoneComboBox;
    public ComboBox<String> advisorAddShiftTypeComboBox;
    public ComboBox<String> advisorModifyStatusComboBox;
    Stage stage;
    Parent scene;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        advisorModifyStatusComboBox.getItems().addAll("Active", "LOA", "Rotation");
        advisorAddTimeZoneComboBox.getItems().addAll("EST", "CST", "MST", "PST");
        advisorAddShiftTypeComboBox.getItems().addAll("Day 5x8", "5x8", "Day 4x10", "Swing 5x8", "Swing 4x10",
                "Grave 5x8", "Grave 4x10", "Split");
    }

    public void onActionAdvisorModifyStatus(ActionEvent actionEvent) {
    }

    public void onActionAdvisorAddShiftTypeComboBox(ActionEvent actionEvent) {
    }

    public void onActionAdvisorAddTimeZone(ActionEvent actionEvent) {
    }

    public void onActionAdvisorAddSave(ActionEvent actionEvent) throws IOException {


        String name = advisorAddNameTextField.getText();
        String DSID = advisorAddDSIDTextField.getText();
        String EID = advisorAddEIDTextField.getText();
        String shift = advisorModifyShiftTextField.getText();
        String address = advisorAddAddressTextField.getText();
        String bday = advisorAddBdayTextField.getText();
        String email = advisorAddEmailTextField.getText();
        String DOH = advisorAddHireDateTextField.getText();
        String phone = advisorAddPhoneTextField.getText();

        String status = advisorModifyStatusComboBox.getSelectionModel().getSelectedItem();
        String  time_zone = advisorAddTimeZoneComboBox.getSelectionModel().getSelectedItem();
        String shift_type = advisorAddShiftTypeComboBox.getSelectionModel().getSelectedItem();
        new Advisor( name, EID, DSID, email, status, shift_type, shift, phone, time_zone, DOH, bday, address);

        stage = (Stage)((Button)actionEvent.getSource()).getScene().getWindow();
        scene = FXMLLoader.load(getClass().getResource("Overview.fxml"));
        stage.setTitle("Overview Menu");

        stage.setScene(new Scene(scene));
        stage.show();


    }

    public void onActionAdvisorAddCancel(ActionEvent actionEvent) throws IOException {
        stage = (Stage)((Button)actionEvent.getSource()).getScene().getWindow();
        scene = FXMLLoader.load(getClass().getResource("Overview.fxml"));
        stage.setTitle("Overview Menu");

        stage.setScene(new Scene(scene));
        stage.show();
    }
}

