package View_Controller;

import Model.Advisor;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

public class AddCoachingMenu {
    public TextField advisorIDTextField;
    public DatePicker addCoachingDatePicker;
    public ComboBox<String> addCoachingTypeComboBox;
    public TextArea addCoachingCommentsTextArea;


    public void onActionAddCoachingSave(ActionEvent actionEvent) {

        String comments = addCoachingCommentsTextArea.getText();

        /*new Coaching( name, EID, DSID, email, status, shift_type, shift, phone, time_zone, DOH, bday, address);

        stage = (Stage)((Button)actionEvent.getSource()).getScene().getWindow();
        scene = FXMLLoader.load(getClass().getResource("Overview.fxml"));
        stage.setTitle("Overview Menu");

        stage.setScene(new Scene(scene));
        stage.show();*/

    }

    public void onActionAddCoachingCancel(ActionEvent actionEvent) {
    }
}
