package View_Controller;

import Model.*;
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
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

public class AddProductScreenController implements Initializable
{
    Stage stage;
    Parent scene;

    @FXML
    private TableView<Part> addProductTableViewTop;
    @FXML
    private TableColumn<Part, Integer> partsPartIDTop;
    @FXML
    private TableColumn<Part, String> partsPartNameTop;
    @FXML
    private TableColumn<Part, Integer> partsInvLevelTop;
    @FXML
    private TableColumn<Part, Double> partsPricePerUnitTop;
    @FXML
    private TableView<Part> addProductTableViewBottom;
    @FXML
    private TableColumn<Part, Integer> partsPartIDBottom;
    @FXML
    private TableColumn<Part, String> partsPartNameBottom;
    @FXML
    private TableColumn<Part, Integer> partsInvLevelBottom;
    @FXML
    private TableColumn<Part, Double> partsPricePerUnitBottom;
    @FXML
    private TextField addProductNameTextField;
    @FXML
    private TextField addProductInvTextField;
    @FXML
    private TextField addProductPriceTextField;
    @FXML
    private TextField addProductMaxTextField;
    @FXML
    private TextField addProductMinTextField;

    @FXML
    private TextField addProductSearchTextField;

    private final ObservableList<Part> topList = FXCollections.observableArrayList();
    private final ObservableList<Part> bottomList = FXCollections.observableArrayList();


    @FXML
    private void onActionAddProductSearch(ActionEvent actionEvent)
    {
        ObservableList<Part> searched = FXCollections.observableArrayList();
        String searchValue = addProductSearchTextField.getText();
        boolean found = false;
        try
        {
            int itemNumber = Integer.parseInt(searchValue);
            for (Part part : Inventory.getAllParts())
            {
                if (part.getId() == itemNumber)
                {
                    found = true;
                    searched.add(part);
                    addProductTableViewTop.setItems(searched);
                    Platform.runLater(() ->
                    {
                        addProductTableViewTop.requestFocus();
                        addProductTableViewTop.getSelectionModel().select(0);
                        addProductTableViewTop.scrollTo(0);
                    });
                }
            }
            if (!found)
            {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Information Dialog");
                alert.setHeaderText("Error!");
                alert.setContentText("Part not found");

                alert.showAndWait();
                addProductTableViewTop.setItems(topList);
            }
        } catch (NumberFormatException e)
        {
            for (Part part : Inventory.getAllParts())
            {
                if (part.getName().equalsIgnoreCase(searchValue))
                {
                    found = true;

                    searched.add(part);
                    addProductTableViewTop.setItems(searched);
                    Platform.runLater(() ->
                    {
                        addProductTableViewTop.requestFocus();
                        addProductTableViewTop.getSelectionModel().select(0);
                        addProductTableViewTop.scrollTo(0);
                    });

                }
            }
            if (!found)
            {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Information Dialog");
                alert.setHeaderText("Error");
                alert.setContentText("Part not found");

                alert.showAndWait();
                addProductTableViewTop.setItems(Inventory.getAllParts());
            }
        }
    }

    @FXML
    private void onActionAddProductDelete(ActionEvent actionEvent)
    {
        Part toMove = addProductTableViewBottom.getSelectionModel().getSelectedItem();
        if(toMove == null)
        {
            return;
        }
        bottomList.remove(toMove);
        topList.add(toMove);
    }

    @FXML
    private void onActionAddProductSaveBtn(ActionEvent actionEvent) throws IOException
    {
        {
            boolean success = false;
            try
            {
                String name = addProductNameTextField.getText();
                double price = Double.parseDouble(addProductPriceTextField.getText());
                int stock = Integer.parseInt(addProductInvTextField.getText());
                int max = Integer.parseInt(addProductMaxTextField.getText());
                int min = Integer.parseInt(addProductMinTextField.getText());

                if (stock < min || stock > max || min > max)
                {
                    addProductMinTextField.clear();
                    addProductMaxTextField.clear();
                    addProductInvTextField.clear();
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Information Dialog");
                    alert.setHeaderText("Error!");
                    alert.setContentText("Check inventory, min and max values fields");
                    alert.showAndWait();
                } else
                {
                    Product newProduct = new Product(name, price, stock, min, max, bottomList);
                    Inventory.addProduct(newProduct);
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
                    scene = FXMLLoader.load(getClass().getResource("AddProductScreen.fxml"));
                    stage.setTitle("Add Product Menu");

                    stage.setScene(new Scene(scene));
                    stage.show();
                }
            }
        }
    }

    @FXML
    private void onActionAddProductCancelBtn(ActionEvent actionEvent) throws IOException
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

    @Override
    public void initialize(URL location, ResourceBundle resources)
    {
        topList.addAll(Inventory.getAllParts());

        addProductTableViewTop.setItems(topList);
        partsPartIDTop.setCellValueFactory(new PropertyValueFactory<>("id"));
        partsPartNameTop.setCellValueFactory(new PropertyValueFactory<>("name"));
        partsInvLevelTop.setCellValueFactory(new PropertyValueFactory<>("stock"));
        partsPricePerUnitTop.setCellValueFactory(new PropertyValueFactory<>("price"));

        addProductTableViewBottom.setItems(bottomList);
        partsPartIDBottom.setCellValueFactory(new PropertyValueFactory<>("id"));
        partsPartNameBottom.setCellValueFactory(new PropertyValueFactory<>("name"));
        partsInvLevelBottom.setCellValueFactory(new PropertyValueFactory<>("stock"));
        partsPricePerUnitBottom.setCellValueFactory(new PropertyValueFactory<>("price"));
    }

    @FXML
    private void onActionAddToBottomTable(ActionEvent actionEvent)
    {
        Part toMove = addProductTableViewTop.getSelectionModel().getSelectedItem();
        if(toMove == null)
        {
            return;
        }
        bottomList.add(toMove);
        topList.remove(toMove);
        addProductTableViewTop.setItems(topList);
    }

    @FXML
    private void addProductSearchTextFieldOnMouseExited(MouseEvent mouseEvent)
    {
        if (addProductSearchTextField.getText().isEmpty())
        {
            addProductTableViewTop.setItems(topList);

        }
    }
}
