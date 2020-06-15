package View_Controller;

import Model.InHouse;
import Model.Inventory;
import Model.Outsourced;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

public class AddPartScreenController implements Initializable
{
    Stage stage;
    Parent scene;

    @FXML
    private RadioButton inHouseRBtn;
    @FXML
    private RadioButton outsourcedRBtn;
    @FXML
    private TextField addPartNameTextField;
    @FXML
    private TextField addPartInvTextField;
    @FXML
    private TextField addPartPriceTextField;
    @FXML
    private TextField addPartMaxTextField;
    @FXML
    private TextField addPartMinTextField;
    @FXML
    private TextField addPartCompNameTextField;
    @FXML
    private TextField addPartMachineIDTextField;
    @FXML
    private Label companyNameLbl;


    @Override
    public void initialize(URL location, ResourceBundle resources)
    {

    }

    @FXML
    private void onActionSavePart(ActionEvent actionEvent) throws IOException
    {
        boolean success = false;
        try
        {
            String name = addPartNameTextField.getText();
            double price = Double.parseDouble(addPartPriceTextField.getText());
            int stock = Integer.parseInt(addPartInvTextField.getText());
            int min = Integer.parseInt(addPartMinTextField.getText());
            int max = Integer.parseInt(addPartMaxTextField.getText());

            if (stock < min || stock > max || min > max)
            {
                addPartMinTextField.clear();
                addPartMaxTextField.clear();
                addPartInvTextField.clear();
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Information Dialog");
                alert.setHeaderText("Error!");
                alert.setContentText("Check inventory, min and max values fields");
                alert.showAndWait();

            } else
            {
                if (inHouseRBtn.isSelected())
                    {
                        int machineId = Integer.parseInt(addPartCompNameTextField.getText());
                        InHouse newPart = new InHouse(name, price, stock, min, max, machineId);
                        Inventory.addPart(newPart);
                    } else
                    {
                        String companyName = addPartCompNameTextField.getText();
                        Outsourced newPart = new Outsourced(name, price, stock, min, max, companyName);
                        Inventory.addPart(newPart);
                    }
                success = true;
            }
        } catch (Exception e)
        {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Information Dialog");
            alert.setHeaderText("Error!");
            alert.setContentText("Part not added successfully. Double check all fields");
            alert.showAndWait();
            success = false;
        } finally
        {
            if (success)
            {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Confirmation Dialog");
                alert.setHeaderText("Confirm!");
                alert.setContentText("Part Added Successfully");
                alert.showAndWait();
                stage = (Stage) ((Button) actionEvent.getSource()).getScene().getWindow();
                scene = FXMLLoader.load(getClass().getResource("AddPartScreen.fxml"));
                stage.setTitle("Add Part Menu");

                stage.setScene(new Scene(scene));
                stage.show();
            }
        }
    }

    @FXML
    private void onActionCancelPart(ActionEvent actionEvent) throws IOException
    {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Are you sure?");
        Optional<ButtonType> result = alert.showAndWait();
        if (result.isPresent() && result.get() == ButtonType.OK){
            stage = (Stage)((Button)actionEvent.getSource()).getScene().getWindow();
            scene = FXMLLoader.load(getClass().getResource("MainMenu.fxml"));
            stage.setTitle("Main Menu");

            stage.setScene(new Scene(scene));
            stage.show();
        }

    }

    @FXML
    private void onActionInHouseRBtn(ActionEvent actionEvent)
    {
        addPartCompNameTextField.setId("addPartMachineIDTextField");
        addPartCompNameTextField.setPromptText("Machine ID");
        companyNameLbl.setText("Machine ID");
    }

    @FXML
    private void onActionOutsourcedRBtn(ActionEvent actionEvent)
    {
        addPartCompNameTextField.setPromptText("Company Name");
        companyNameLbl.setText("Company");
    }
}
