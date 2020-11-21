package View_Controller;

import Model.Advisor;
import Model.Attendance;
import Storage.Records;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class ModifyAttendance implements Initializable {

    public DatePicker modifyAttendanceDatePicker;
    public ComboBox<String> modifyAttendanceNameComboBox;
    public ComboBox<String> modifyAttendanceTypeComboBox;
    public CheckBox modifyAttendanceCompletedCheckBox;
    public TextField modifyAttendanceHoursTextField;
    public TextArea modifyAttendanceCommentsTextArea;
    Stage stage;
    Parent scene;

    String name = "";
    int ID;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        for (Advisor advisor : Records.getAdvisorDB()) {
            String name = advisor.getName();
            modifyAttendanceNameComboBox.getItems().add(name);
        }

        modifyAttendanceTypeComboBox.getItems().addAll("Approved", "VTO", "Apple DownTime", "Home DownTime", "Inclement Weather", "Full Day Sick", "Mid Day Sick",
                "Early or Late Out", "Personal", "No Call No Show", "Pending Protected Time", "Tardy or Left Early", "Late From Lunch",
                "KinCare", "Regional Sick", "Bereavement", "Parental Time", "Jury Duty", "LOA", "iLOA", "Job Accommodation", "Total");
    }

    public void sendAttendance(Attendance attend) {
        name = attend.getName();
        ID = attend.getID();
        String date = String.valueOf(attend.getDate());
        modifyAttendanceDatePicker.setValue(LocalDate.parse(date));
        modifyAttendanceTypeComboBox.setValue(attend.getType());
        modifyAttendanceCommentsTextArea.setText(attend.getComments());
        modifyAttendanceNameComboBox.setValue(attend.getName());
        modifyAttendanceHoursTextField.setText(String.valueOf(attend.getHours()));
        if(attend.getCompleted().equals("Complete")){
            modifyAttendanceCompletedCheckBox.setSelected(true);
        }
    }

    public void onActionModifyAttendanceSave(ActionEvent actionEvent) throws IOException {
        String tempName = modifyAttendanceNameComboBox.getValue();
        String comments = modifyAttendanceCommentsTextArea.getText();
        String date = modifyAttendanceDatePicker.getValue().toString();
        String type = modifyAttendanceTypeComboBox.getValue();
        double hours = Double.parseDouble(modifyAttendanceHoursTextField.getText());
        boolean isComplete = modifyAttendanceCompletedCheckBox.isSelected();
        System.out.println("On Action Modify "  + ID);
        Attendance temp;
        if (!(this.name.equals(tempName))){
            temp = new Attendance(tempName, date, type, hours, comments, isComplete);
            Records.getAttendance(name).remove(ID -1);
        } else {
            temp = new Attendance(ID, name, date, type, hours, comments, isComplete);
        }

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("Details.fxml"));
        loader.load();

        DetailsMenuController detailsMenuController =  loader.getController();
        detailsMenuController.sendAttendance(temp);

        stage = (Stage) ((Button) actionEvent.getSource()).getScene().getWindow();
        stage.setTitle("Advisor Details Menu");

        Parent scene = loader.getRoot();
        stage.setScene(new Scene(scene));
        stage.show();
        System.out.println("Attendance Save Modify");
    }

    public void onActionModifyAttendanceCancel(ActionEvent actionEvent) throws IOException {
        String tempName = modifyAttendanceNameComboBox.getSelectionModel().getSelectedItem();
        new CancelButton(actionEvent, tempName);
    }
}
