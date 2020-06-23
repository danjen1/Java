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
    public ComboBox<String> advisorDetailsAdvisorComboBox;
    public ComboBox<String> advisorDetailsCoachingAttendComboBox;
    public ComboBox<String> advisorDetailsCoachingPeriodComboBox;

    int oneOnOne = 0, checkIn = 0, northStars, ROD = 0, NTF = 0;
    double unplanned = 0, downTime = 0, KinCare = 0;

    LocalDate today = LocalDate.now().plusDays(1);
    LocalDate thirty = today.minusDays(30);
    LocalDate sixty = today.minusDays(60);
    LocalDate ninety = today.minusDays(90);
    LocalDate oneEighty = today.minusDays(180);
    LocalDate year = today.minusDays(365);

    Stage stage;
    Parent scene;

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
        advisorDetailsCoachingAttendComboBox.getSelectionModel().select("90 Days");
        advisorDetailsCoachingPeriodComboBox.getSelectionModel().select("30 Days");

        System.out.println("Initialize ran");
    }


    public void sendAdvisor(Advisor advisor, ObservableList<Coaching> coach, ObservableList<Attendance> attend) throws IOException
    {
        advisorDetailsAdvisorComboBox.getSelectionModel().select(advisor.getName());
        fillTables();

        coachLabelDefault(coach);
        attendLabelDefault(attend);
        advisorDetailsAdvisorComboBox.setValue(advisor.getName());

    }

    public void sendCoaching(Coaching coach) throws IOException
    {
        advisorDetailsAdvisorComboBox.getSelectionModel().select(coach.getName());
        fillTables();
        detailsAdvisorCoachingTableView.requestFocus();
        detailsAdvisorCoachingTableView.getSelectionModel().select(0);
        detailsAdvisorCoachingTableView.scrollTo(0);

        coachingTotals();
        attendTotals();
    }

    public void sendAttendance(Attendance attend) throws IOException
    {
        advisorDetailsAdvisorComboBox.getSelectionModel().select(attend.getName());
        fillTables();
        detailsAdvisorAttendanceTableView.requestFocus();
        detailsAdvisorAttendanceTableView.getSelectionModel().select(0);
        detailsAdvisorAttendanceTableView.scrollTo(0);

        coachingTotals();
        attendTotals();
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
        coachingTotals();
        attendTotals();

    }

    public void onActionAdvisorDetailsAdvisorName(ActionEvent actionEvent) throws IOException
    {
        fillTables();
        coachingTotals();
        attendTotals();

    }

    public void onActionAdvisorDetailsCoachingStatus(ActionEvent actionEvent) throws IOException
    {
        coachingTotals();
    }

    public void coachingTotals() throws IOException
    {
        ObservableList<Coaching> searched = FXCollections.observableArrayList();
        String sort = advisorDetailsCoachingPeriodComboBox.getSelectionModel().getSelectedItem();
        clearCoachLabel();
        System.out.println(northStars + " " + oneOnOne + " " +  checkIn);
        for (Coaching coach : (Records.getCoaching(advisorDetailsAdvisorComboBox.getSelectionModel().getSelectedItem())))
        {
            switch (sort)
            {
                case "30 Days" :
                    System.out.println("30 Days");
                    if (coach.getDate().isBefore(today) && coach.getDate().isAfter(thirty))
                    {
                        searched.add(coach);
                        coachTypeTotals(coach);
                    }
                    detailsAdvisorCoachingTableView.setItems(searched);
                    break;
                case "60 Days" :
                    if (coach.getDate().isBefore(today) && coach.getDate().isAfter(sixty))
                    {
                        searched.add(coach);
                        coachTypeTotals(coach);
                    }
                    detailsAdvisorCoachingTableView.setItems(searched);
                    break;
                case "180 Days" :
                    if (coach.getDate().isBefore(today) && coach.getDate().isAfter(oneEighty))
                    {
                        searched.add(coach);
                        coachTypeTotals(coach);
                    }
                    detailsAdvisorCoachingTableView.setItems(searched);
                    break;
                case "90 Days" :
                    if (coach.getDate().isBefore(today) && coach.getDate().isAfter(ninety))
                    {
                        searched.add(coach);
                        coachTypeTotals(coach);
                    }
                    detailsAdvisorCoachingTableView.setItems(searched);
                    break;
                case "12 Month" :
                    if (coach.getDate().isBefore(today) && coach.getDate().isAfter(year))
                    {
                        searched.add(coach);
                        coachTypeTotals(coach);
                    }
                    detailsAdvisorCoachingTableView.setItems(searched);
                    break;
                default  :
                    coachTypeTotals(coach);
                    detailsAdvisorCoachingTableView.setItems(Records.getCoaching(advisorDetailsAdvisorComboBox.getSelectionModel().getSelectedItem()));
                    break;
            }
        }
        String test = advisorDetailsCoachingPeriodComboBox.getSelectionModel().getSelectedItem();
        System.out.println(test);
        if(searched.size() == 0 && (!(test.equals("All"))))
        {
            clearAttendLabel();
        }
    }

    public void coachTypeTotals(Coaching coach){
        if(coach.getType().equals("1x1")){
            oneOnOne++;
            System.out.println("One On One : " + oneOnOne);
        } else if (coach.getType().equals("Check-in")){
            checkIn++;
            System.out.println("Check-n " + checkIn);
        }else if (coach.getType().equals("NorthStar")){
            northStars++;
            System.out.println("NothStars " + northStars);
        }
        advisorDetails1x1Label.setText(String.valueOf(oneOnOne));
        advisorDetailsCheckinLabel.setText(String.valueOf(checkIn));
        advisorDetailsNorthStarLabel.setText(String.valueOf(northStars));
    }

    public void coachLabelDefault(ObservableList<Coaching> coach) throws IOException
    {
        for (Coaching item : coach)
        {
            if (item.getDate().isBefore(today) && item.getDate().isAfter(thirty))
            {
                coachTypeTotals(item);
            }
        }
    }
    public void clearCoachLabel(){
        oneOnOne = 0;
        checkIn = 0;
        northStars = 0;
        advisorDetails1x1Label.setText(String.valueOf(oneOnOne));
        advisorDetailsCheckinLabel.setText(String.valueOf(checkIn));
        advisorDetailsNorthStarLabel.setText(String.valueOf(northStars));
    }

    public void onActionAdvisorDetailsAttendStatus(ActionEvent actionEvent) throws IOException
    {
        attendTotals();
    }
    public void attendTotals() throws IOException
    {
        ObservableList<Attendance> searched = FXCollections.observableArrayList();
        String sort = advisorDetailsCoachingAttendComboBox.getSelectionModel().getSelectedItem();
        clearAttendLabel();
        System.out.println("clear attendance labels ran " + unplanned);
        for (Attendance attend : (Records.getAttendance(advisorDetailsAdvisorComboBox.getSelectionModel().getSelectedItem())))
        {
            switch (sort)
            {
                case "30 Days" :
                    if (attend.getDate().isBefore(today) && attend.getDate().isAfter(thirty))
                    {
                        searched.add(attend);
                        attendTypeTotals(attend);
                    }
                    detailsAdvisorAttendanceTableView.setItems(searched);
                    break;
                case "60 Days" :
                    if (attend.getDate().isBefore(today) && attend.getDate().isAfter(sixty))
                    {
                        searched.add(attend);
                        attendTypeTotals(attend);
                    }
                    detailsAdvisorAttendanceTableView.setItems(searched);
                    break;
                case "180 Days" :
                    if (attend.getDate().isBefore(today) && attend.getDate().isAfter(oneEighty))
                    {
                        searched.add(attend);
                        attendTypeTotals(attend);
                    }
                    detailsAdvisorAttendanceTableView.setItems(searched);
                    break;
                case "90 Days" :
                    if (attend.getDate().isBefore(today) && attend.getDate().isAfter(ninety))
                    {
                        searched.add(attend);
                        attendTypeTotals(attend);
                    }
                    detailsAdvisorAttendanceTableView.setItems(searched);
                    break;
                case "12 Month" :
                    if (attend.getDate().isBefore(today) && attend.getDate().isAfter(year))
                    {
                        searched.add(attend);
                        attendTypeTotals(attend);
                    }
                    detailsAdvisorAttendanceTableView.setItems(searched);
                    break;
                default  :
                    attendTypeTotals(attend);
                    detailsAdvisorAttendanceTableView.setItems(Records.getAttendance(advisorDetailsAdvisorComboBox.getSelectionModel().getSelectedItem()));
                    break;
            }
        }
        String test = advisorDetailsCoachingAttendComboBox.getSelectionModel().getSelectedItem();
        System.out.println(test);
        if(searched.size() == 0 && (!(test.equals("All"))))
        {
            clearAttendLabel();
        }
    }


    public void attendTypeTotals(Attendance attend){
        if(attend.getType().equals("ROD")){
            ROD++;
        } else if (attend.getType().equals("NTF")){
            NTF++;
        }else if (attend.getUnplanned()){
            unplanned+= attend.getHours();
            System.out.println("Unplanned " + attend.getType() + attend.getName() + attend.getUnplanned() + attend.getDate() + attend.getHours());
        } else if (attend.getType().equals("Home DownTime")){
            downTime+= attend.getHours();
        } else if (attend.getType().equals("KinCare")){
            KinCare+= attend.getHours();
        }
        System.out.println("Unplanned " + unplanned);
        detailsNTFLabel.setText(String.valueOf(NTF));
        detailsRODLabel.setText(String.valueOf(ROD));
        detailsDowntineLabel.setText(String.valueOf(downTime));
        detailsKincareLabel.setText(String.valueOf(KinCare));
        detailsUnplannedLabel.setText(String.valueOf(unplanned));
    }

    public void attendLabelDefault(ObservableList<Attendance> attend) throws IOException
    {
        for (Attendance item : attend)
        {
            if (item.getDate().isBefore(today) && item.getDate().isAfter(ninety))
            {
                attendTypeTotals(item);
            }
        }
    }
    public void clearAttendLabel(){
        NTF = 0;
        ROD = 0;
        unplanned = 0;
        downTime = 0;
        KinCare = 0;
        detailsNTFLabel.setText(String.valueOf(NTF));
        detailsRODLabel.setText(String.valueOf(ROD));
        detailsDowntineLabel.setText(String.valueOf(downTime));
        detailsKincareLabel.setText(String.valueOf(KinCare));
        detailsUnplannedLabel.setText(String.valueOf(unplanned));
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

    public void coachAttendCancel(String name) throws IOException
    {
        advisorDetailsAdvisorComboBox.setValue(name);
        fillTables();
    }
}

