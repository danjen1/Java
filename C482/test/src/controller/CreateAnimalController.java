package controller;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import model.DataProvider;
import model.Dog;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLOutput;
import java.util.Optional;
import java.util.ResourceBundle;

public class CreateAnimalController implements Initializable
{
    Stage stage;
    Parent scene;

    @FXML
    private TextField animalidTxt;

    @FXML
    private TextField breedTxt;

    @FXML
    private TextField lifespanTxt;

    @FXML
    private TextField behaviorTxt;

    @FXML
    private TextField priceTxt;

    @FXML
    private RadioButton vacYesRBtn;

    @FXML
    private RadioButton vacNoRBtn;

    @FXML
    void onActionDisplayMainMenu(ActionEvent event) throws IOException
    {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "This will clear all text fields, do you want to continue?");
        Optional<ButtonType> result = alert.showAndWait();
        if (result.isPresent() && result.get() == ButtonType.OK)
        {
            stage = (Stage)((Button)event.getSource()).getScene().getWindow();
            scene = FXMLLoader.load(getClass().getResource("/view/MainMenu.fxml"));
            stage.setScene(new Scene(scene));
            stage.show();
        }
    }

    @FXML
    void onActionSaveAnimal(ActionEvent event) throws IOException
    {
        try
        {
            int id = Integer.parseInt(animalidTxt.getText());
            String breed = breedTxt.getText();
            int lifespan = Integer.parseInt(lifespanTxt.getText());
            String behavior = behaviorTxt.getText();
            double price = Double.valueOf(priceTxt.getText());
            boolean isVacc;
            String special = null;

            if (vacYesRBtn.isSelected())
            {
                isVacc = true;
            } else
            {
                isVacc = false;
            }
            DataProvider.addAnimal(new Dog(id, breed, lifespan, behavior, price, isVacc, special));
            stage = (Stage) ((Button) event.getSource()).getScene().getWindow();
            scene = FXMLLoader.load(getClass().getResource("/view/MainMenu.fxml"));
            stage.setScene(new Scene(scene));
            stage.show();

        }
        catch (NumberFormatException e)
        {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Warning Dialog");
            alert.setContentText("Please enter valid value for each field");
            alert.showAndWait();
        }

    }

    @Override
    public void initialize(URL location, ResourceBundle resources)
    {


    }
}
