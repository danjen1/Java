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
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.Date;
import java.util.Optional;
import java.util.ResourceBundle;

public class OverviewMenuController implements Initializable {
    @FXML
    private TableView<Advisor> overviewAdvisorTableView;
    @FXML
    private TableColumn<Advisor, String> overviewNameCol;
    @FXML
    private TableColumn<Advisor, String> overviewStatusCol;
    @FXML
    private TableColumn<Advisor, String> overviewDSIDCol;
    @FXML
    private TableColumn<Advisor, String> overviewEIDCol;
    @FXML
    private TableColumn<Advisor, String> overviewShiftCol;
    @FXML
    private TableColumn<Advisor, String> overviewMobileCol;
    @FXML
    private TableColumn<Advisor, Date> overviewHireDateCol;
    @FXML
    private TableColumn<Advisor, String> overviewEmailCol;
    @FXML
    private TableColumn<Advisor, String> overviewBDayCol;
    @FXML
    private TableColumn<Advisor, String> overviewAddressCol;
    @FXML
    private ComboBox<String> overviewStatusComboBox;
    @FXML
    private TableColumn<Advisor, String> overviewTimeZoneCol;
    @FXML
    private TableColumn<Advisor, String> overviewShiftTypeCol;

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

    public void onActionOverviewAddNew(ActionEvent actionEvent) throws IOException {
        stage = (Stage) ((Button) actionEvent.getSource()).getScene().getWindow();
        scene = FXMLLoader.load(getClass().getResource("AddAdvisor.fxml"));
        stage.setTitle("Add Advisor Menu");

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
        {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Are you sure you want to Exit?");
            Optional<ButtonType> result = alert.showAndWait();
            if (result.isPresent() && result.get() == ButtonType.OK)
            {
                System.exit(0);
            }
        }
    }

    public void onActionOverviewDelete(ActionEvent actionEvent) throws IOException {
        String name = overviewAdvisorTableView.getSelectionModel().getSelectedItem().getName();
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Are you sure you want to delete " + name);
        Optional<ButtonType> result = alert.showAndWait();
        if (result.isPresent() && result.get() == ButtonType.OK) {
            Records.getAdvisorDB().remove(overviewAdvisorTableView.getSelectionModel().getSelectedItem());
            overviewAdvisorTableView.setItems(Records.getAdvisorDB());
            Alert alert1 = new Alert(Alert.AlertType.INFORMATION, name + " Deleted Successfully");
            alert1.showAndWait();
        }
    }

    @FXML
    private void overViewMenuDoubleClick(MouseEvent mouseEvent) throws IOException
    {
                if(mouseEvent.getButton().equals(MouseButton.PRIMARY)){
                    if(mouseEvent.getClickCount() == 2){
                        FXMLLoader loader = new FXMLLoader();
                        loader.setLocation(getClass().getResource("Details.fxml"));
                        loader.load();

                        DetailsMenuController detailsMenuController =  loader.getController();
                        detailsMenuController.sendAdvisor(overviewAdvisorTableView.getSelectionModel().getSelectedItem(), overviewAdvisorTableView.getSelectionModel().getSelectedItem().getCoach(),
                                overviewAdvisorTableView.getSelectionModel().getSelectedItem().getAttendance());

                        stage = (Stage) ((TableView) mouseEvent.getSource()).getScene().getWindow();
                        stage.setTitle("Advisor Details Menu");

                        Parent scene = loader.getRoot();
                        stage.setScene(new Scene(scene));
                        stage.show();
                    }
                }
            }
        }




