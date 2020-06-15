package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import model.Animal;
import model.Dog;


import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class AnimalDetailsController implements Initializable
{
    Stage stage;
    Parent scene;

    @FXML
    private Label animalidLbl;

    @FXML
    private Label breedLbl;

    @FXML
    private Label lifespanLbl;

    @FXML
    private Label behaviorLbl;

    @FXML
    private Label priceLbl;

    @FXML
    private Label vaccLbl;

    @FXML
    private Label specialLbl;

    @FXML
    void onActionDisplayMainMenu(ActionEvent event) throws IOException
    {
        stage = (Stage)((Button)event.getSource()).getScene().getWindow();
        scene = FXMLLoader.load(getClass().getResource("/view/DisplayAnimalMenu.fxml"));
        stage.setScene(new Scene(scene));
        stage.show();
    }

    public void sendAnimal(Animal dog)
    {
        animalidLbl.setText(String.valueOf(dog.getId()));
        breedLbl.setText(dog.getBreed());
        lifespanLbl.setText(String.valueOf(dog.getLifespan()));
        behaviorLbl.setText(dog.getBehavior());
        priceLbl.setText(String.valueOf(dog.getPrice()));
        if(dog.isVacc())
        {
            vaccLbl.setText("Yes");
        } else {
            vaccLbl.setText("No");
        }

        if(dog instanceof Dog)
        {
            specialLbl.setText(((Dog) dog).getSpecial());
        }

    }

    @Override
    public void initialize(URL location, ResourceBundle resources)
    {

    }
}