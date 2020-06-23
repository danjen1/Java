package View_Controller;

import Model.Advisor;
import Storage.Records;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
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


public class ModifyAdvisorMenuController implements Initializable {

    Stage stage;
    Parent scene;

    @FXML
    public TextField advisorModifyNameTextField;
    @FXML
    public TextField advisorIDTextField;
    @FXML
    public TextField advisorModifyDSIDTextField;
    @FXML
    public TextField advisorModifyEIDTextField;
    @FXML
    public TextField advisorModifyShiftTextField;
    @FXML
    public TextField advisorModifyAddressTextField;
    @FXML
    public TextField advisorModifyBdayTextField;
    @FXML
    public TextField advisorModifyPhoneTextField;
    @FXML
    public ComboBox<String> advisorModifyStatusComboBox;
    @FXML
    public ComboBox<String> advisorModifyTimeZoneComboBox;
    @FXML
    public ComboBox<String> advisorModifyShiftTypeComboBox;
    @FXML
    public TextField advisorModifyEmailTextField;
    @FXML
    public TextField advisorModifyHireDateTextField;

    public void sendAdvisor(Advisor advisor)
    {
        advisorModifyNameTextField.setText((advisor.getName()));
        advisorModifyDSIDTextField.setText(advisor.getDSID());
        advisorModifyEIDTextField.setText(advisor.getEID());
        advisorModifyShiftTextField.setText(advisor.getShift());
        advisorModifyAddressTextField.setText(advisor.getAddress());
        advisorModifyBdayTextField.setText(String.valueOf(advisor.getBDay()));
        advisorModifyEmailTextField.setText(advisor.getEmail());
        advisorModifyHireDateTextField.setText(String.valueOf(advisor.getDOH()));
        advisorModifyPhoneTextField.setText(advisor.getPhone());
        advisorIDTextField.setText((String.valueOf(advisor.getID())));

        advisorModifyStatusComboBox.getItems().addAll("Active", "LOA", "Rotation", "Term");
        advisorModifyTimeZoneComboBox.getItems().addAll("EST", "CST", "MST", "PST");
        advisorModifyShiftTypeComboBox.getItems().addAll("Day 5x8", "5x8", "Day 4x10", "Swing 5x8", "Swing 4x10",
                                                                    "Grave 5x8", "Grave 4x10", "Split");
        advisorModifyStatusComboBox.getSelectionModel().select(advisor.getStatus());
        advisorModifyTimeZoneComboBox.getSelectionModel().select(advisor.getT_zone());
        advisorModifyShiftTypeComboBox.getSelectionModel().select(advisor.getShift_type());
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {


    }

    public void onActionAdvisorModifyStatus(ActionEvent actionEvent) {
    }

    public void onActionAdvisorModifySave(ActionEvent actionEvent) throws IOException {

        String name = advisorModifyNameTextField.getText();
        String DSID = advisorModifyDSIDTextField.getText();
        String EID = advisorModifyEIDTextField.getText();
        String shift = advisorModifyShiftTextField.getText();
        String address = advisorModifyAddressTextField.getText();
        String bday = advisorModifyBdayTextField.getText();
        String email = advisorModifyEmailTextField.getText();
        String DOH = advisorModifyHireDateTextField.getText();
        String phone = advisorModifyPhoneTextField.getText();
        String status = advisorModifyStatusComboBox.getSelectionModel().getSelectedItem();
        String  time_zone =   advisorModifyTimeZoneComboBox.getSelectionModel().getSelectedItem();
        String shift_type = advisorModifyShiftTypeComboBox.getSelectionModel().getSelectedItem();
        int ID = (Integer.parseInt(advisorIDTextField.getText()));
        new Advisor(ID, name, EID, DSID, email, status, shift_type, shift, phone, time_zone, DOH, bday, address);

        stage = (Stage)((Button)actionEvent.getSource()).getScene().getWindow();
        scene = FXMLLoader.load(getClass().getResource("Overview.fxml"));
        stage.setTitle("Overview Menu");

        stage.setScene(new Scene(scene));
        stage.show();


    }

    public void onActionAdvisorModifyCancel(ActionEvent actionEvent) throws IOException {
        stage = (Stage)((Button)actionEvent.getSource()).getScene().getWindow();
        scene = FXMLLoader.load(getClass().getResource("Overview.fxml"));
        stage.setTitle("Overview Menu");

        stage.setScene(new Scene(scene));
        stage.show();
    }

    public void onActionAdvisorModifyTimeZone(ActionEvent actionEvent) {
    }

    public void onActionAdvisorModifyShiftTypeComboBox(ActionEvent actionEvent) {
    }
}
