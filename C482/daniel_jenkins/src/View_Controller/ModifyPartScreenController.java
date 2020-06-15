package View_Controller;

import Model.InHouse;
import Model.Inventory;
import Model.Outsourced;
import Model.Part;
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

public class ModifyPartScreenController implements Initializable
{
    Stage stage;
    Parent scene;

    @FXML
    private Label companyNameLbl;
    @FXML
    private TextField modifyPartNameTextField;
    @FXML
    private TextField modifyPartInvTextField;
    @FXML
    private TextField modifyPartPriceTextField;
    @FXML
    private TextField modifyPartMaxTextField;
    @FXML
    private TextField modifyPartMinTextField;
    @FXML
    private TextField modifyPartCompNameTextField;
    @FXML
    private TextField modifyPartIDTextField;
    @FXML
    private RadioButton outsourcedRBtn;


    @Override
    public void initialize(URL location, ResourceBundle resources)
    {
    }

    public void sendPart(Part part)
    {
        modifyPartIDTextField.setText(String.valueOf(part.getId()));
        modifyPartNameTextField.setText(part.getName());
        modifyPartInvTextField.setText(String.valueOf(part.getStock()));
        modifyPartPriceTextField.setText(String.valueOf(part.getPrice()));
        modifyPartMinTextField.setText(String.valueOf(part.getMin()));
        modifyPartMaxTextField.setText(String.valueOf(part.getMax()));

        if (part instanceof Outsourced)
        {
            modifyPartCompNameTextField.setText(((Outsourced) part).getCompanyName());
            outsourcedRBtn.setSelected(true);
            companyNameLbl.setText("Company Name");

        } else
        {
            modifyPartCompNameTextField.setText(String.valueOf(((InHouse) part).getMachineId()));
        }
    }

    @FXML
    private void onActionInHouseRBtn(ActionEvent actionEvent)
    {
        modifyPartCompNameTextField.setId("addPartCompNameTextField");
        modifyPartCompNameTextField.setPromptText("Machine ID");
        companyNameLbl.setText("Machine ID");
    }


    @FXML
    private void onActionOutsourcedRBtn(ActionEvent actionEvent)
    {
        modifyPartCompNameTextField.setPromptText("Company Name");
        companyNameLbl.setText("Company");
    }

    @FXML
    private void onActionSaveModifyPart(ActionEvent actionEvent) throws IOException
    {
        int id = Integer.parseInt(modifyPartIDTextField.getText());
        String partName = modifyPartNameTextField.getText();
        int stock = Integer.parseInt(modifyPartInvTextField.getText());
        double price = Double.parseDouble(modifyPartPriceTextField.getText());
        int min = Integer.parseInt(modifyPartMinTextField.getText());
        int max = Integer.parseInt(modifyPartMaxTextField.getText());
        String compName = modifyPartCompNameTextField.getText();
        try
        {
            if (outsourcedRBtn.isSelected())
            {
                Outsourced newPart = new Outsourced(id, partName, price, stock, min, max, compName);
                Inventory.getAllParts().set(id - 1, newPart);
            } else
            {
                InHouse newPart = new InHouse(id, partName, price, stock, min, max, Integer.parseInt(compName));
                Inventory.getAllParts().set(id - 1, newPart);
            }
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Information Dialog");
            alert.setHeaderText("Success!");
            alert.setContentText("Modified Successfully");
            alert.showAndWait();

        } catch (NumberFormatException e)
        {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Information Dialog");
            alert.setHeaderText("Error!");
            alert.setContentText("Check field formatting");
            alert.showAndWait();
        }
        stage = (Stage)((Button)actionEvent.getSource()).getScene().getWindow();
        scene = FXMLLoader.load(getClass().getResource("MainMenu.fxml"));
        stage.setTitle("Main Menu");
        stage.setScene(new Scene(scene));
        stage.show();
    }
    @FXML
    private void onActionCancelModifyPart(ActionEvent actionEvent) throws IOException
    {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Are you sure?");
        Optional<ButtonType> result = alert.showAndWait();
        if (result.isPresent() && result.get() == ButtonType.OK)
        {
            stage = (Stage) ((Button) actionEvent.getSource()).getScene().getWindow();
            scene = FXMLLoader.load(getClass().getResource("MainMenu.fxml"));
            stage.setTitle("Main Menu");

            stage.setScene(new Scene(scene));
            stage.show();
        }
    }
}
