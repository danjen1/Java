package View_Controller;

import Model.Advisor;
import Model.Attendance;
import Model.Coaching;
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

public class AddAttendanceMenu implements Initializable {

    public DatePicker addAttendanceDatePicker;
    public ComboBox<String> addAttendanceTypeComboBox;
    public TextArea addAttendanceCommentsTextArea;
    public ComboBox<String> addAttendanceNameComboBox;
    public CheckBox addAttendanceCompletedCheckBox;
    public TextField addAttendanceHoursTextField;


    Stage stage;
    Parent scene;
    String date;
    String name = "";

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        for (Advisor advisor : Records.getAdvisorDB()) {
            String name = advisor.getName();
            addAttendanceNameComboBox.getItems().add(name);
        }
        addAttendanceTypeComboBox.getItems().addAll("Approved", "VTO", "Apple DownTime", "Home DownTime", "Inclement Weather", "Full Day Sick", "Mid Day Sick",
                "Early or Late Out", "Personal", "No Call No Show", "Pending Protected Time", "Tardy or Left Early", "Late From Lunch",
                "KinCare", "Regional Sick", "Bereavement", "Parental Time", "Jury Duty", "LOA", "iLOA", "Job Accommodation");
        addAttendanceDatePicker.setValue(LocalDate.now());
    }


    public void onActionAddAttendanceSave(ActionEvent actionEvent) throws IOException {
        String name = addAttendanceNameComboBox.getValue();
        String comments = addAttendanceCommentsTextArea.getText();

        date = addAttendanceDatePicker.getValue().toString();
        System.out.println(date);
        String type = addAttendanceTypeComboBox.getValue();
        boolean completed = addAttendanceCompletedCheckBox.isSelected();
        double hours = Double.parseDouble(addAttendanceHoursTextField.getText());
        System.out.println(hours);

        Attendance temp = new Attendance(name, date,type,hours,comments,completed);
        System.out.println(name);

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

    }

    public void sendAttendance(String name) {
        this.name = name;
        System.out.println(name);
        addAttendanceNameComboBox.setValue(name);
    }

    public void onActionAddAttendanceCancel(ActionEvent actionEvent) {
    }
}
