package View_Controller;


import View_Controller.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class CancelButton
{
    public  CancelButton(ActionEvent actionEvent, String tempName) throws IOException
    {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("Details.fxml"));
        loader.load();

        DetailsMenuController detailsMenuController =  loader.getController();
        detailsMenuController.coachAttendCancel(tempName);

        Stage stage = (Stage) ((Button) actionEvent.getSource()).getScene().getWindow();
        stage.setTitle("Advisor Details Menu");

        Parent scene = loader.getRoot();
        stage.setScene(new Scene(scene));
        stage.show();
        System.out.println("Attendance Save Modify");
    }
}
