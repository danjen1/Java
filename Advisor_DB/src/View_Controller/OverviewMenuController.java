package View_Controller;


import Model.Advisor;
import Model.Attendance;
import Model.Coaching;
import Other.TableUtils;
import Storage.Records;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.Date;
import java.util.Optional;
import java.util.ResourceBundle;

public class OverviewMenuController implements Initializable {

    boolean details;
    @FXML
    public TableView<Advisor> overviewAdvisorTableView;
    @FXML
    public TableColumn<Advisor, String> overviewNameCol;
    @FXML
    public TableColumn<Advisor, String> overviewStatusCol;
    @FXML
    public TableColumn<Advisor, String> overviewDSIDCol;
    @FXML
    public TableColumn<Advisor, String> overviewEIDCol;
    @FXML
    public TableColumn<Advisor, String> overviewShiftCol;
    @FXML
    public TableColumn<Advisor, String> overviewMobileCol;
    @FXML
    public TableColumn<Advisor, Date> overviewHireDateCol;
    @FXML
    public TableColumn<Advisor, String> overviewEmailCol;
    @FXML
    public TableColumn<Advisor, String> overviewBDayCol;
    @FXML
    public TableColumn<Advisor, String> overviewAddressCol;
    @FXML
    public ComboBox<String> overviewStatusComboBox;
    @FXML
    public Tab overviewMenu;
    @FXML
    public TableColumn<Advisor, String> overviewTimeZoneCol;
    @FXML
    public TableColumn<Advisor, String> overviewShiftTypeCol;

    Stage stage;
    Parent scene;

    public void initialize(URL location, ResourceBundle resources) {
        

        overviewAdvisorTableView.setItems(Records.getAdvisorDB());

        overviewStatusComboBox.getItems().addAll("All", "Active", "LOA", "Rotation", "Term");

        overviewNameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        overviewStatusCol.setCellValueFactory(new PropertyValueFactory<>("status"));
        overviewDSIDCol.setCellValueFactory(new PropertyValueFactory<>("DSID"));
        overviewEIDCol.setCellValueFactory(new PropertyValueFactory<>("ID"));
        overviewTimeZoneCol.setCellValueFactory(new PropertyValueFactory<>("t_zone"));
        overviewShiftTypeCol.setCellValueFactory(new PropertyValueFactory<>("shift_type"));
        overviewShiftCol.setCellValueFactory(new PropertyValueFactory<>("shift"));
        overviewMobileCol.setCellValueFactory(new PropertyValueFactory<>("phone"));
        overviewEmailCol.setCellValueFactory(new PropertyValueFactory<>("Email"));
        overviewHireDateCol.setCellValueFactory(new PropertyValueFactory<>("DOH"));
        overviewBDayCol.setCellValueFactory(new PropertyValueFactory<>("BDay"));
        overviewAddressCol.setCellValueFactory(new PropertyValueFactory<>("address"));
        overviewNameCol.setSortType(TableColumn.SortType.ASCENDING);
        overviewAdvisorTableView.getSortOrder().add(overviewNameCol);
        overviewAdvisorTableView.sort();

        overviewAdvisorTableView.getSelectionModel().setCellSelectionEnabled(true);
        overviewAdvisorTableView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        TableUtils.installCopyPasteHandler(overviewAdvisorTableView);
        overviewAdvisorTableView.requestFocus();
        overviewAdvisorTableView.getSelectionModel().select(0);
        overviewAdvisorTableView.scrollTo(0);

    }

    public void onActionOverviewStatus(ActionEvent actionEvent) {

        ObservableList<Advisor> searched = FXCollections.observableArrayList();
        String sort = overviewStatusComboBox.getSelectionModel().getSelectedItem();

        if (sort.equals("All")) {
            overviewAdvisorTableView.setItems(Records.getAdvisorDB());
            overviewNameCol.setSortType(TableColumn.SortType.ASCENDING);
            overviewAdvisorTableView.getSortOrder().add(overviewNameCol);
            overviewAdvisorTableView.sort();
        }

        for (Advisor status : Records.getAdvisorDB()) {
            if (status.getStatus().equalsIgnoreCase(sort)) {

                searched.add(status);
                overviewAdvisorTableView.setItems(searched);
                Platform.runLater(() ->
                {
                    overviewAdvisorTableView.requestFocus();
                    overviewAdvisorTableView.getSelectionModel().select(0);
                    overviewAdvisorTableView.scrollTo(0);
                });
            }
        }
    }



    public void onActionOverviewDetails(ActionEvent actionEvent) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("Details.fxml"));
        loader.load();

        DetailsMenuController detailsMenuController =  loader.getController();
        detailsMenuController.sendAdvisor(overviewAdvisorTableView.getSelectionModel().getSelectedItem());

        stage = (Stage) ((Button) actionEvent.getSource()).getScene().getWindow();
        stage.setTitle("Advisor Details Menu");

        Parent scene = loader.getRoot();
        stage.setScene(new Scene(scene));
        stage.show();

    }

    public void onActionOverviewAddNew(ActionEvent actionEvent) throws IOException {
        stage = (Stage) ((Button) actionEvent.getSource()).getScene().getWindow();
        scene = FXMLLoader.load(getClass().getResource("AddAdvisor.fxml"));
        stage.setTitle("Add Advisoor Menu");

        stage.setScene(new Scene(scene));
        stage.show();
    }


    public void onActionOverviewModify(ActionEvent actionEvent) throws IOException {
        {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("ModifyAdvisor.fxml"));
            loader.load();

            ModifyAdvisorMenuController moodifyAdvisorController = loader.getController();
            moodifyAdvisorController.sendAdvisor(overviewAdvisorTableView.getSelectionModel().getSelectedItem());

            stage = (Stage) ((Button) actionEvent.getSource()).getScene().getWindow();
            stage.setTitle("Modify Part Menu");

            Parent scene = loader.getRoot();
            stage.setScene(new Scene(scene));
            stage.show();
        }
    }

    public void onActionOverviewExit(ActionEvent actionEvent) throws IOException {


    }

    public void onActionOverviewDelete(ActionEvent actionEvent) throws IOException {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Are you sure you want to delete Advisor?");
        Optional<ButtonType> result = alert.showAndWait();
        if (result.isPresent() && result.get() == ButtonType.OK) {
            Records.getAdvisorDB().remove(overviewAdvisorTableView.getSelectionModel().getSelectedItem());
            overviewAdvisorTableView.setItems(Records.getAdvisorDB());
            Alert alert1 = new Alert(Alert.AlertType.INFORMATION, "Advisor Deleted Successfully");
            alert1.showAndWait();
        }
    }

}

