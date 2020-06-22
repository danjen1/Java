package View_Controller;

import Model.Advisor;
import Model.Coaching;
import Other.TableUtils;
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

public class ModifyCoachingMenu implements Initializable {
    public ComboBox<String> modifyCoachingNameComboBox;
    String name = "";
    int ID;
    public DatePicker modifyCoachingDatePicker;
    public ComboBox<String> modifyCoachingTypeComboBox;
    public TextArea modifyCoachingCommentsTextArea;
    Stage stage;
    Parent scene;


    public void sendCoaching(Coaching coach) throws IOException {

        name = coach.getName();
        String date = String.valueOf(coach.getDate());
        modifyCoachingDatePicker.setValue(LocalDate.parse(date));
        modifyCoachingTypeComboBox.setValue(coach.getType());
        modifyCoachingCommentsTextArea.setText(coach.getComments());
        modifyCoachingNameComboBox.setValue(coach.getName());
        ID = coach.getID();
        System.out.println(ID);
    }


    public void onActionModifyCoachingSave(ActionEvent actionEvent) throws IOException {
        String tempName = modifyCoachingNameComboBox.getValue();
        String comments = modifyCoachingCommentsTextArea.getText();
        String date = modifyCoachingDatePicker.getValue().toString();
        String type = modifyCoachingTypeComboBox.getValue();
        Coaching temp;
        System.out.println(this.name);
        if (!(this.name.equals(tempName))){
            temp = new Coaching(tempName, date, type, comments);
            Records.getCoaching(name).remove(ID);
            if(!(Records.getCoaching(name).isEmpty())){
                for (Coaching co : Records.getCoaching(this.name))
                {
                    co.setID(co.getID());
                }
            }

        } else {
            temp = new Coaching(ID, name, date, type, comments);
        }

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

    public void onActionModifyCoachingCancel(ActionEvent actionEvent) throws IOException {
        stage = (Stage)((Button)actionEvent.getSource()).getScene().getWindow();
        scene = FXMLLoader.load(getClass().getResource("Details.fxml"));
        stage.setTitle("Advisor Details Menu");

        stage.setScene(new Scene(scene));
        stage.show();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        for (Advisor advisor : Records.getAdvisorDB()) {
            String name = advisor.getName();
            modifyCoachingNameComboBox.getItems().add(name);
        }

        modifyCoachingTypeComboBox.getItems().addAll("1x1", "NorthStar", "Check-in", "AUX", "Behavioral", "KPIs", "FollowUp");

    }

    }

