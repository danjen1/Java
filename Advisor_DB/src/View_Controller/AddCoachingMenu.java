package View_Controller;

import Model.Advisor;
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
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;

import static java.lang.Integer.parseInt;

public class AddCoachingMenu implements Initializable {

    Stage stage;
    Parent scene;

    public ComboBox<String> addCoachingNameComboBox;
    public DatePicker addCoachingDatePicker;
    public ComboBox<String> addCoachingTypeComboBox;
    public TextArea addCoachingCommentsTextArea;
    private String name;
    private int ID;
    private String date = "";


    public void onActionAddCoachingSave(ActionEvent actionEvent) throws IOException {

        String name = addCoachingNameComboBox.getValue();
        String comments = addCoachingCommentsTextArea.getText();

        date = addCoachingDatePicker.getValue().toString();
        String type = addCoachingTypeComboBox.getValue();
        System.out.println(type);
        Coaching temp = new Coaching(name, date, type, comments);
        System.out.println(name);

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("Details.fxml"));
        loader.load();

        DetailsMenuController detailsMenuController =  loader.getController();
        detailsMenuController.sendCoaching(temp);

        stage = (Stage) ((Button) actionEvent.getSource()).getScene().getWindow();
        stage.setTitle("Advisor Details Menu");

        Parent scene = loader.getRoot();
        stage.setScene(new Scene(scene));
        stage.show();

    }


    public void onActionAddCoachingCancel(ActionEvent actionEvent) throws IOException {
        stage = (Stage) ((Button) actionEvent.getSource()).getScene().getWindow();
        scene = FXMLLoader.load(getClass().getResource("Details.fxml"));
        stage.setTitle("Advisor Details Menu");
        stage.setScene(new Scene(scene));
        stage.show();
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {

        for (Advisor advisor : Records.getAdvisorDB()) {
            String name = advisor.getName();
            addCoachingNameComboBox.getItems().add(name);
        }

        addCoachingTypeComboBox.getItems().addAll("1x1", "NorthStar", "Check-in", "AUX", "Behavioral", "KPIs", "FollowUp");
        addCoachingDatePicker.setValue(LocalDate.now());
    }

    public void sendCoaching(String name) {
        this.name = name;
        System.out.println(name);
        addCoachingNameComboBox.setValue(name);
    }


}
