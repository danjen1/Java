package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable
{
    @FXML
    private TableColumn allJerseyColumn;

    @FXML
    private TableView<BasketBallPlayer> allTable;
    @FXML
    private TableColumn allNameColumn;
    @FXML
    private TableColumn allPointsColumn;
    @FXML
    private TableColumn allTeamColumn;
    @FXML
    private TableView<BasketBallPlayer> fewTable;
    @FXML
    private TableColumn fewJerseyColumn;
    @FXML
    private TableColumn fewPointsColumn;
    @FXML
    private TableColumn fewNameColumn;
    @FXML
    private TableColumn fewTeamColumn;
    @FXML
    private Button addB;
    @FXML
    private Button removeB;

    private ObservableList<BasketBallPlayer> allPlayers = FXCollections.observableArrayList();
    private ObservableList<BasketBallPlayer> fewPlayers = FXCollections.observableArrayList();


    @Override
    public void initialize(URL location, ResourceBundle resources)
    {
        BasketBallPlayer a = new BasketBallPlayer("Daniel", 45, "Joos", 23);
        BasketBallPlayer b = new BasketBallPlayer("Cara", 46, "Bulls", 45);
        BasketBallPlayer c = new BasketBallPlayer("Gio", 12, "Celtics", 12);
        BasketBallPlayer d = new BasketBallPlayer("Maddie", 23, "Wizards", 12);
        BasketBallPlayer e = new BasketBallPlayer("Aspen", 1, "Negroes", 33);
        BasketBallPlayer f = new BasketBallPlayer("Kya", 13, "Krauts", 4);




        allPlayers.addAll(a, b, c, d, e, f);

        allTable.setItems(allPlayers);
        allJerseyColumn.setCellValueFactory(new PropertyValueFactory<>("jersey"));
        allNameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        allTeamColumn.setCellValueFactory(new PropertyValueFactory<>("team"));
        allPointsColumn.setCellValueFactory(new PropertyValueFactory<>("points"));

        fewTable.setItems(fewPlayers);
        fewJerseyColumn.setCellValueFactory(new PropertyValueFactory<>("jersey"));
        fewNameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        fewTeamColumn.setCellValueFactory(new PropertyValueFactory<>("team"));
        fewPointsColumn.setCellValueFactory(new PropertyValueFactory<>("points"));
    }

    public void onAddB(ActionEvent actionEvent)
    {
        BasketBallPlayer bp = allTable.getSelectionModel().getSelectedItem();
        if(bp == null)
        {
            return;
        }
        fewPlayers.add(bp);
        allPlayers.remove(bp);
    }

    public void onRemoveB(ActionEvent actionEvent)
    {
        BasketBallPlayer bp = fewTable.getSelectionModel().getSelectedItem();
        if(bp == null)
        {
            return;
        }
        allPlayers.add(bp);
        fewPlayers.remove(bp);

    }
}
