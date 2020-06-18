package View_Controller;

import Model.Advisor;
import Model.Coaching;
import Other.TableUtils;
import Storage.Records;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;

public class ModifyCoachingMenu {
    public ComboBox<String> addCoachingTypeComboBox;
    public DatePicker addCoachingDatePicker;
    public TextArea addCoachingCommentsTextArea;
    public TextField advisorIDTextField;


    public void onActionAddCoachingSave(ActionEvent actionEvent) {
    }

    public void onActionAddCoachingCancel(ActionEvent actionEvent) {
    }
    public void sendCoaching(Coaching coach) throws IOException {

        addCoachingCommentsTextArea.setText(String.valueOf((coach.getComments())));
        addCoachingTypeComboBox.getItems().addAll("All", "1x1", "NorthStar", "Check-in", "AUX", "Behavioral", "KPIs", "FollowUp");
    }


}
