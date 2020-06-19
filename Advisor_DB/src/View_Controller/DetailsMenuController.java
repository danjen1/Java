package View_Controller;

import Model.Advisor;
import Model.Attendance;
import Model.Coaching;
import Other.TableUtils;
import Storage.Records;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

public class DetailsMenuController implements Initializable {
    public TableView<Coaching> detailsAdvisorCoachingTableView;
    public TableColumn<Coaching, String> detailsCoachingDateCol;
    public TableColumn<Coaching, String> detailsCoachingTypeCol;
    public TableColumn<Coaching, String> detailsCoachingCommentsCol;
    public TableView<Attendance> detailsAdvisorAttendanceTableView;
    public TableColumn<Attendance, String> detailsAtteendStatusCol;
    public TableColumn<Attendance, String>  detailsAttendDateCol;
    public TableColumn<Attendance, String>  detailsAttendTypeCol;
    public TableColumn<Attendance, String>  detailsAttendCommentsCol;
    public TableColumn<Attendance, Double> detailsAttendHoursCol;

    public Label detailsUnplannedLabel;
    public Label detailsDowntineLabel;
    public Label detailsKincareLabel;
    public Label detailsRODLabel;
    public Label detailsNTFLabel;
    public Label advisorDetails1x1Label;
    public Label advisorDetailsCheckinLabel;
    public Label advisorDetailsNorthStarLabel;
    public Label advisorDetailsAdvisorLabel;
    public ComboBox<String> advisorDetailsAdvisorComboBox;
    public ComboBox<String> advisorDetailsCoachingAttendComboBox;
    public ComboBox<String> advisorDetailsCoachingPeriodComboBox;

    Stage stage;
    Parent scene;
    String name = "";

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        for (Advisor advisor : Records.getAdvisorDB()) {
            String name = advisor.getName();
            advisorDetailsAdvisorComboBox.getItems().add(name);
        }
        advisorDetailsCoachingAttendComboBox.getItems().addAll("All", "30 Days", "60 Days", "90 Days", "180 Days", "12 month");
        advisorDetailsCoachingPeriodComboBox.getItems().addAll("All", "30 Days", "60 Days", "90 Days", "180 Days", "12 month");

    }
    public void sendAdvisor(Advisor advisor) throws IOException {
        advisorDetailsAdvisorLabel.setText((advisor.getName()));
        name = advisor.getName();
        detailsAdvisorCoachingTableView.setItems(Records.getCoaching(advisor.getName()));
        detailsCoachingTypeCol.setCellValueFactory(new PropertyValueFactory<>("type"));
        detailsCoachingDateCol.setCellValueFactory(new PropertyValueFactory<>("date"));
        detailsCoachingCommentsCol.setCellValueFactory(new PropertyValueFactory<>("comments"));

        detailsAdvisorAttendanceTableView.setItems(Records.getAttendance(advisor.getName()));
        detailsAtteendStatusCol.setCellValueFactory(new PropertyValueFactory<>("status"));
        detailsAttendDateCol.setCellValueFactory(new PropertyValueFactory<>("date"));
        detailsAttendTypeCol.setCellValueFactory(new PropertyValueFactory<>("type"));
        detailsAttendCommentsCol.setCellValueFactory(new PropertyValueFactory<>("comments"));
        detailsAttendHoursCol.setCellValueFactory(new PropertyValueFactory<>("hours"));
        detailsAtteendStatusCol.setCellValueFactory(new PropertyValueFactory<>("completed"));
        TableUtils.installCopyPasteHandler(detailsAdvisorCoachingTableView);
        detailsAdvisorCoachingTableView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

        TableUtils.installCopyPasteHandler(detailsAdvisorAttendanceTableView);
        detailsAdvisorAttendanceTableView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);


        detailsAdvisorCoachingTableView.requestFocus();
        detailsAdvisorCoachingTableView.getSelectionModel().select(0);
        detailsAdvisorCoachingTableView.scrollTo(0);
        advisorDetailsAdvisorComboBox.setValue(advisor.getName());
    }

    public void sendCoaching(Coaching coach) throws IOException {

        advisorDetailsAdvisorComboBox.setValue(coach.getName());
        advisorDetailsAdvisorLabel.setText(coach.getName());
        detailsAdvisorCoachingTableView.setItems(Records.getCoaching(coach.getName()));
        detailsCoachingTypeCol.setCellValueFactory(new PropertyValueFactory<>("type"));
        detailsCoachingDateCol.setCellValueFactory(new PropertyValueFactory<>("date"));
        detailsCoachingCommentsCol.setCellValueFactory(new PropertyValueFactory<>("comments"));


    }

    public void sendAttendance(Attendance attend) throws IOException {

        advisorDetailsAdvisorComboBox.setValue(attend.getName());
        detailsAdvisorAttendanceTableView.setItems(Records.getAttendance(attend.getName()));
        detailsAttendTypeCol.setCellValueFactory(new PropertyValueFactory<>("type"));
        detailsAttendDateCol.setCellValueFactory(new PropertyValueFactory<>("date"));
        detailsAttendCommentsCol.setCellValueFactory(new PropertyValueFactory<>("comments"));
        detailsAttendHoursCol.setCellValueFactory(new PropertyValueFactory<>("hours"));
        detailsAtteendStatusCol.setCellValueFactory(new PropertyValueFactory<>("completed"));


    }


        public void onActionAdvisorDetailsAdvisorName(ActionEvent actionEvent) throws IOException {

        ObservableList<Advisor> searched = FXCollections.observableArrayList();
        String name = advisorDetailsAdvisorComboBox.getSelectionModel().getSelectedItem();

        detailsAdvisorCoachingTableView.setItems(Records.getCoaching(name));
        detailsCoachingTypeCol.setCellValueFactory(new PropertyValueFactory<>("type"));
        detailsCoachingDateCol.setCellValueFactory(new PropertyValueFactory<>("date"));
        detailsCoachingCommentsCol.setCellValueFactory(new PropertyValueFactory<>("comments"));
        advisorDetailsAdvisorLabel.setText(name);

        detailsAdvisorAttendanceTableView.setItems(Records.getAttendance(name));
        detailsAtteendStatusCol.setCellValueFactory(new PropertyValueFactory<>("status"));
        detailsAttendDateCol.setCellValueFactory(new PropertyValueFactory<>("date"));
        detailsAttendTypeCol.setCellValueFactory(new PropertyValueFactory<>("type"));
        detailsAttendCommentsCol.setCellValueFactory(new PropertyValueFactory<>("comments"));
        detailsAttendHoursCol.setCellValueFactory(new PropertyValueFactory<>("hours"));
        TableUtils.installCopyPasteHandler(detailsAdvisorCoachingTableView);
        detailsAdvisorCoachingTableView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

        TableUtils.installCopyPasteHandler(detailsAdvisorAttendanceTableView);
        detailsAdvisorAttendanceTableView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

        detailsAdvisorCoachingTableView.requestFocus();
        detailsAdvisorCoachingTableView.getSelectionModel().select(0);
        detailsAdvisorCoachingTableView.scrollTo(0);


    }

    public void onActionAdvisorDetailsCoachingStatus(ActionEvent actionEvent) {
    }

    public void onActionAdvisorDetailsAttendStatus(ActionEvent actionEvent) {
    }

    public void onActionAdvisorDetailsAddBtn(ActionEvent actionEvent) throws IOException {

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("AddAttendance.fxml"));
        loader.load();


        AddAttendanceMenu addAttendanceMenuController =  loader.getController();
        addAttendanceMenuController.sendAttendance(advisorDetailsAdvisorComboBox.getSelectionModel().getSelectedItem());
        stage = (Stage) ((Button) actionEvent.getSource()).getScene().getWindow();

        stage = (Stage) ((Button) actionEvent.getSource()).getScene().getWindow();
        stage.setTitle("Add Attendance Menu");

        Parent scene = loader.getRoot();
        stage.setScene(new Scene(scene));
        stage.show();

    }

    public void onActionAdvisorDetailsModifyBtn(ActionEvent actionEvent) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("ModifyAttendanceMenu.fxml"));
        loader.load();

        ModifyAttendance modifyAttendanceController =  loader.getController();
        modifyAttendanceController.sendAttendance(detailsAdvisorAttendanceTableView.getSelectionModel().getSelectedItem());

        stage = (Stage) ((Button) actionEvent.getSource()).getScene().getWindow();
        stage.setTitle("Advisor Details Menu");

        Parent scene = loader.getRoot();
        stage.setScene(new Scene(scene));
        stage.show();
    }

    public void onActionAdvisorDetailsDeleteBtn(ActionEvent actionEvent) {

    }

    public void onActionAdvisorDetailsExitBtn(ActionEvent actionEvent) {
    }

    public void onActionCoachingAdd(ActionEvent actionEvent) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("AddCoaching.fxml"));
        loader.load();


        AddCoachingMenu addCoachingMenuController =  loader.getController();
        addCoachingMenuController.sendCoaching(advisorDetailsAdvisorComboBox.getSelectionModel().getSelectedItem());
        stage = (Stage) ((Button) actionEvent.getSource()).getScene().getWindow();

        stage = (Stage) ((Button) actionEvent.getSource()).getScene().getWindow();
        stage.setTitle("Add Coaching Menu");

        Parent scene = loader.getRoot();
        stage.setScene(new Scene(scene));
        stage.show();
    }

    public void onActionDetailsCoachingModify(ActionEvent actionEvent) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("ModifyCoaching.fxml"));
        loader.load();

        ModifyCoachingMenu modifyCoachingMenu =  loader.getController();
        modifyCoachingMenu.sendCoaching(detailsAdvisorCoachingTableView.getSelectionModel().getSelectedItem());

        stage = (Stage) ((Button) actionEvent.getSource()).getScene().getWindow();
        stage.setTitle("Modify Coaching Menu");

        Parent scene = loader.getRoot();
        stage.setScene(new Scene(scene));
        stage.show();
    }

    public void onActionDetailsCoaching(ActionEvent actionEvent) throws IOException {
        Coaching coach = detailsAdvisorCoachingTableView.getSelectionModel().getSelectedItem();
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Are you sure you want to delete Coaching?");
        Optional<ButtonType> result = alert.showAndWait();
        if (result.isPresent() && result.get() == ButtonType.OK) {
            Records.getCoaching(coach.getName()).remove(detailsAdvisorCoachingTableView.getSelectionModel().getSelectedItem());
            detailsAdvisorCoachingTableView.setItems(Records.getCoaching(coach.getName()));
            detailsCoachingDateCol.setSortType(TableColumn.SortType.DESCENDING);
            detailsAdvisorCoachingTableView.getSortOrder().add(detailsCoachingDateCol);
            detailsAdvisorCoachingTableView.sort();
        }
    }
}
