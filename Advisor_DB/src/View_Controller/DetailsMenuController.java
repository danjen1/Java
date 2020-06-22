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
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Objects;
import java.util.Optional;
import java.util.ResourceBundle;

public class DetailsMenuController implements Initializable
{
    public TableView<Coaching> detailsAdvisorCoachingTableView;
    public TableColumn<Coaching, String> detailsCoachingDateCol;
    public TableColumn<Coaching, String> detailsCoachingTypeCol;
    public TableColumn<Coaching, String> detailsCoachingCommentsCol;
    public TableView<Attendance> detailsAdvisorAttendanceTableView;
    public TableColumn<Attendance, String> detailsAtteendStatusCol;
    public TableColumn<Attendance, String> detailsAttendDateCol;
    public TableColumn<Attendance, String> detailsAttendTypeCol;
    public TableColumn<Attendance, String> detailsAttendCommentsCol;
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
    public void initialize(URL location, ResourceBundle resources)
    {
        for (Advisor adv : Records.getAdvisorDB())
        {
            String name = adv.getName();
            advisorDetailsAdvisorComboBox.getItems().add(name);
        }
        advisorDetailsCoachingAttendComboBox.getItems().addAll("All", "30 Days", "60 Days", "90 Days", "180 Days", "12 Month");
        advisorDetailsCoachingPeriodComboBox.getItems().addAll("All", "30 Days", "60 Days", "90 Days", "180 Days", "12 Month");
    }

    public void sendAdvisor(Advisor advisor) throws IOException
    {
        advisorDetailsAdvisorComboBox.getSelectionModel().select(advisor.getName());
        fillTables();

        advisorDetailsAdvisorComboBox.setValue(advisor.getName());
    }

    public void sendCoaching(Coaching coach) throws IOException
    {
        advisorDetailsAdvisorComboBox.getSelectionModel().select(coach.getName());
        fillTables();

        detailsAdvisorCoachingTableView.requestFocus();
        detailsAdvisorCoachingTableView.getSelectionModel().select(0);
        detailsAdvisorCoachingTableView.scrollTo(0);
    }

    public void sendAttendance(Attendance attend) throws IOException
    {
        advisorDetailsAdvisorComboBox.getSelectionModel().select(attend.getName());
        fillTables();

        detailsAdvisorAttendanceTableView.requestFocus();
        detailsAdvisorAttendanceTableView.getSelectionModel().select(0);
        detailsAdvisorAttendanceTableView.scrollTo(0);
    }

    public void fillTables() throws IOException
    {
        String name = advisorDetailsAdvisorComboBox.getSelectionModel().getSelectedItem();
        detailsAdvisorCoachingTableView.setItems(Records.getCoaching(name));
        detailsCoachingTypeCol.setCellValueFactory(new PropertyValueFactory<>("type"));
        detailsCoachingDateCol.setCellValueFactory(new PropertyValueFactory<>("date"));
        detailsCoachingCommentsCol.setCellValueFactory(new PropertyValueFactory<>("comments"));
        detailsAdvisorCoachingTableView.getSelectionModel().setCellSelectionEnabled(true);

        detailsAdvisorCoachingTableView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        TableUtils.installCopyPasteHandler(detailsAdvisorCoachingTableView);


        detailsAdvisorAttendanceTableView.setItems(Records.getAttendance(name));
        detailsAttendDateCol.setCellValueFactory(new PropertyValueFactory<>("date"));
        detailsAttendTypeCol.setCellValueFactory(new PropertyValueFactory<>("type"));
        detailsAttendCommentsCol.setCellValueFactory(new PropertyValueFactory<>("comments"));
        detailsAttendHoursCol.setCellValueFactory(new PropertyValueFactory<>("hours"));
        detailsAtteendStatusCol.setCellValueFactory(new PropertyValueFactory<>("completed"));
        detailsAdvisorAttendanceTableView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        detailsAdvisorAttendanceTableView.getSelectionModel().setCellSelectionEnabled(true);

        TableUtils.installCopyPasteHandler(detailsAdvisorAttendanceTableView);

    }

    public void onActionAdvisorDetailsAdvisorName(ActionEvent actionEvent) throws IOException
    {
        fillTables();
    }

    public void onActionAdvisorDetailsCoachingStatus(ActionEvent actionEvent) throws IOException
    {
        ObservableList<Coaching> searched = FXCollections.observableArrayList();
        String sort = advisorDetailsCoachingPeriodComboBox.getSelectionModel().getSelectedItem();
        LocalDate today = LocalDate.now();
        LocalDate thirty = today.minusDays(30);
        LocalDate sixty = today.minusDays(60);
        LocalDate ninety = today.minusDays(90);
        LocalDate oneEighty = today.minusDays(180);
        LocalDate year = today.minusDays(365);
        double sum30 = 0;
        double sum60 = 0;
        double sum90 = 0;
        double sum180 = 0;
        double sumTotal = 0;
        for (Coaching coach : (Records.getCoaching(advisorDetailsAdvisorComboBox.getSelectionModel().getSelectedItem())))
        {
            switch (sort)
            {
                case "30 Days" :
                    System.out.println("30 Days");
                    if (coach.getDate().isBefore(today) && coach.getDate().isAfter(thirty))
                        searched.add(coach);
                        System.out.println("Searched array size " + searched.size());
                        detailsAdvisorCoachingTableView.setItems(searched);
                        break;
                case "60 Days" :
                    if (coach.getDate().isBefore(today) && coach.getDate().isAfter(sixty))
                        searched.add(coach);
                        detailsAdvisorCoachingTableView.setItems(searched);
                    break;
                case "180 Days" :
                    if (coach.getDate().isBefore(today) && coach.getDate().isAfter(oneEighty))
                        searched.add(coach);
                        detailsAdvisorCoachingTableView.setItems(searched);
                    break;
                case "90 Days" :
                    if (coach.getDate().isBefore(today) && coach.getDate().isAfter(ninety))
                        searched.add(coach);
                        detailsAdvisorCoachingTableView.setItems(searched);

                    break;
                case "12 Month" :
                    if (coach.getDate().isBefore(today) && coach.getDate().isAfter(year))
                        searched.add(coach);
                        detailsAdvisorCoachingTableView.setItems(searched);
                    break;
               default  :
                    detailsAdvisorCoachingTableView.setItems(Records.getCoaching(advisorDetailsAdvisorComboBox.getSelectionModel().getSelectedItem()));
                    break;
            }
        }
    }

     public void onActionAdvisorDetailsAttendStatus(ActionEvent actionEvent) throws IOException
     {
      ObservableList<Attendance> searched = FXCollections.observableArrayList();
      String sort = advisorDetailsCoachingAttendComboBox.getSelectionModel().getSelectedItem();
      LocalDate today = LocalDate.now();
      LocalDate thirty = today.minusDays(30);
      LocalDate sixty = today.minusDays(60);
      LocalDate ninety = today.minusDays(90);
      LocalDate oneEighty = today.minusDays(180);
      LocalDate year = today.minusDays(365);

      for (Attendance attend : (Records.getAttendance(advisorDetailsAdvisorComboBox.getSelectionModel().getSelectedItem())))
      {
          switch (sort)
          {
              case "30 Days" :
                  System.out.println("30 Days");
                  if (attend.getDate().isBefore(today) && attend.getDate().isAfter(thirty))
                      searched.add(attend);
                  System.out.println("Searched array size " + searched.size());
                  detailsAdvisorAttendanceTableView.setItems(searched);
                  break;
              case "60 Days" :
                  if (attend.getDate().isBefore(today) && attend.getDate().isAfter(sixty))
                      searched.add(attend);
                  detailsAdvisorAttendanceTableView.setItems(searched);
                  break;
              case "180 Days" :
                  if (attend.getDate().isBefore(today) && attend.getDate().isAfter(oneEighty))
                      searched.add(attend);
                  detailsAdvisorAttendanceTableView.setItems(searched);
                  break;
              case "90 Days" :
                  if (attend.getDate().isBefore(today) && attend.getDate().isAfter(ninety))
                      searched.add(attend);
                  detailsAdvisorAttendanceTableView.setItems(searched);

                  break;
              case "12 Month" :
                  if (attend.getDate().isBefore(today) && attend.getDate().isAfter(year))
                      searched.add(attend);
                  detailsAdvisorAttendanceTableView.setItems(searched);
                  break;
              default  :
                  detailsAdvisorAttendanceTableView.setItems(Records.getAttendance(advisorDetailsAdvisorComboBox.getSelectionModel().getSelectedItem()));
                  break;
          }
      }
  }

    public void onActionAdvisorDetailsAddBtn(ActionEvent actionEvent) throws IOException
    {

        FXMLLoader loader = new FXMLLoader();
        if (!(detailsAdvisorAttendanceTableView.getSelectionModel().isEmpty()))

        {
            loader.setLocation(getClass().getResource("AddAttendance.fxml"));
            loader.load();
            AddAttendanceMenu addAttendanceMenuController = loader.getController();
            addAttendanceMenuController.sendAttendance(advisorDetailsAdvisorComboBox.getSelectionModel().getSelectedItem());

            stage = (Stage) ((Button) actionEvent.getSource()).getScene().getWindow();
            stage.setTitle("Add Attendance Menu");
            Parent scene = loader.getRoot();
            stage.setScene(new Scene(scene));
        } else
        {
            loader.setLocation(getClass().getResource("AddCoaching.fxml"));
            loader.load();

            AddCoachingMenu addCoachingMenu = loader.getController();
            addCoachingMenu.sendCoaching(advisorDetailsAdvisorComboBox.getSelectionModel().getSelectedItem());

            stage = (Stage) ((Button) actionEvent.getSource()).getScene().getWindow();
            stage.setTitle("Add Coaching Menu");

            Parent scene = loader.getRoot();
            stage.setScene(new Scene(scene));
        }
        stage.show();
    }

    public void onActionAdvisorDetailsDeleteBtn(ActionEvent actionEvent) throws IOException
    {
        FXMLLoader loader = new FXMLLoader();
        Coaching coach = detailsAdvisorCoachingTableView.getSelectionModel().getSelectedItem();
        Attendance attend = detailsAdvisorAttendanceTableView.getSelectionModel().getSelectedItem();

        System.out.println();
        if (!(detailsAdvisorAttendanceTableView.getSelectionModel().isEmpty()))
        {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Are you sure you want to delete Attendance?");
            Optional<ButtonType> result = alert.showAndWait();
            if (result.isPresent() && result.get() == ButtonType.OK)
            {
                Records.getAttendance(attend.getName()).remove(detailsAdvisorAttendanceTableView.getSelectionModel().getSelectedItem());


            }
        }else
        {
            Alert alert1 = new Alert(Alert.AlertType.CONFIRMATION, "Are you sure you want to delete Coaching?");
            Optional<ButtonType> result1 = alert1.showAndWait();
            if (result1.isPresent() && result1.get() == ButtonType.OK)
            {
                Records.getCoaching(coach.getName()).remove(detailsAdvisorCoachingTableView.getSelectionModel().getSelectedItem());

            }
            detailsAdvisorCoachingTableView.setItems(Records.getCoaching(coach.getName()));
            detailsCoachingDateCol.setSortType(TableColumn.SortType.DESCENDING);
            detailsAdvisorCoachingTableView.getSortOrder().add(detailsCoachingDateCol);
            detailsAdvisorCoachingTableView.sort();
            fillTables();
        }

    }


    @FXML
    private void detailsMenuCoachingMouseClicked(MouseEvent mouseEvent) throws IOException
    {
        if(mouseEvent.getButton().equals(MouseButton.PRIMARY)){
            if(mouseEvent.getClickCount() == 2){
                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(getClass().getResource("ModifyCoaching.fxml"));
                loader.load();

                ModifyCoachingMenu modifyCoachingMenu =  loader.getController();
                modifyCoachingMenu.sendCoaching(detailsAdvisorCoachingTableView.getSelectionModel().getSelectedItem());


                stage = (Stage) ((TableView) mouseEvent.getSource()).getScene().getWindow();
                stage.setTitle("Advisor Details Menu");

                Parent scene = loader.getRoot();
                stage.setScene(new Scene(scene));
                stage.show();
            }
        }
    }


    @FXML
    private void detailsMenuAttendMouseClicked(MouseEvent mouseEvent) throws IOException
    {
        if(mouseEvent.getButton().equals(MouseButton.PRIMARY)){
            if(mouseEvent.getClickCount() == 2){
                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(getClass().getResource("ModifyAttendanceMenu.fxml"));
                loader.load();

                ModifyAttendance modifyAttendanceMenuController =  loader.getController();
                modifyAttendanceMenuController.sendAttendance(detailsAdvisorAttendanceTableView.getSelectionModel().getSelectedItem());


                stage = (Stage) ((TableView) mouseEvent.getSource()).getScene().getWindow();
                stage.setTitle("Advisor Details Menu");

                Parent scene = loader.getRoot();
                stage.setScene(new Scene(scene));
                stage.show();
            }
        }
    }

    @FXML
    private void onActionAdvisorDetailsExitBtn(ActionEvent actionEvent) throws IOException
    {
        stage = (Stage)((Button)actionEvent.getSource()).getScene().getWindow();
        scene = FXMLLoader.load(getClass().getResource("Overview.fxml"));
        stage.setTitle("Team View Menu");

        stage.setScene(new Scene(scene));
        stage.show();

    }

    @FXML
    private void detailsMenuAttendanceMousePressed(MouseEvent mouseEvent)
    {
        detailsAdvisorCoachingTableView.getSelectionModel().clearSelection();
    }

    @FXML
    private void detailsMenuCoachingMousePressed(MouseEvent mouseEvent)
    {
        detailsAdvisorAttendanceTableView.getSelectionModel().clearSelection();

    }
}

