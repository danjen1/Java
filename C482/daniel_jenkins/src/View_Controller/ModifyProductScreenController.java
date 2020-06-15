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

public class ModifyProductScreenController implements Initializable
{
    Stage stage;
    Parent scene;

    @FXML
    private TextField modifyProductIDTextField;
    @FXML
    private TextField modifyProductNameTextField;
    @FXML
    private TextField modifyProductInvTextField;
    @FXML
    private TextField modifyProductPriceTextField;
    @FXML
    private TextField modifyProductMaxTextField;
    @FXML
    private TextField modifyProductMinTextField;
    @FXML
    private TextField modifyProductSearchTextField;
    @FXML
    private TableColumn<Part, Integer> modifyProductPartIDTopColumn;
    @FXML
    private TableView<Part> modifyProductTableViewBottom;
    @FXML
    private TableColumn<Part, String> modifyProductPartNameTopColumn;
    @FXML
    private TableColumn<Part, Integer> modifyProductInvTopColumn;
    @FXML
    private TableColumn<Part, Double> modifyProductPriceTopColumn;
    @FXML
    private TableColumn<Part, Integer> modifyProductPartIDBottomColumn;
    @FXML
    private TableColumn<Part, String> modifyProductPartNameBottomColumn;
    @FXML
    private TableColumn<Part, Integer> modifyProductPartInvBottomColumn;
    @FXML
    private TableColumn<Part, Double> modifyProductPriceBottomColumn;
    @FXML
    private TableView<Part> modifyProductTableViewTop;

    private final ObservableList<Part> topList = FXCollections.observableArrayList();
    private ObservableList<Part> bottomList = FXCollections.observableArrayList();

    @FXML
    private void onActionModifyProductSearch(ActionEvent actionEvent)
    {
        {
            ObservableList<Part> searched = FXCollections.observableArrayList();
            String searchValue = modifyProductSearchTextField.getText();
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
                        modifyProductTableViewTop.setItems(searched);
                        Platform.runLater(() ->
                        {
                            modifyProductTableViewTop.requestFocus();
                            modifyProductTableViewTop.getSelectionModel().select(0);
                            modifyProductTableViewTop.scrollTo(0);
                        });
                    }
                }
                if (found == false)
                {
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Information Dialog");
                    alert.setHeaderText("Error!");
                    alert.setContentText("Part not found");

                    alert.showAndWait();
                    modifyProductTableViewTop.setItems(topList);
                }
            } catch (NumberFormatException e)
            {
                for (Part part : Inventory.getAllParts())
                {
                    if (part.getName().equalsIgnoreCase(searchValue))
                    {
                        found = true;

                        searched.add(part);
                        modifyProductTableViewTop.setItems(searched);
                        Platform.runLater(() ->
                        {
                            modifyProductTableViewTop.requestFocus();
                            modifyProductTableViewTop.getSelectionModel().select(0);
                            modifyProductTableViewTop.scrollTo(0);
                        });

                    }
                }
                if (found == false)
                {
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Information Dialog");
                    alert.setHeaderText("Error");
                    alert.setContentText("Part not found");

                    alert.showAndWait();
                    modifyProductTableViewTop.setItems(Inventory.getAllParts());
                }
            }
        }
    }

    @FXML
    private void onActionModifyProductDelete(ActionEvent actionEvent)
    {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Are you sure you want to delete Part?");
        Optional<ButtonType> result = alert.showAndWait();
        if (result.isPresent() && result.get() == ButtonType.OK){
            Part toMove = modifyProductTableViewBottom.getSelectionModel().getSelectedItem();
            if (toMove == null)
            {
                return;
            }
            bottomList.remove(toMove);
            if( topList.contains(toMove))
            {
            } else{
                topList.add(toMove);
                modifyProductTableViewTop.setItems(topList);
            }
            modifyProductTableViewBottom.setItems(bottomList);
        }
    }

    @FXML
    private void onActionModifyProductSave(ActionEvent actionEvent) throws IOException
    {
        boolean success = false;
        try
        {
            String name = modifyProductNameTextField.getText();
            double price = Double.parseDouble(modifyProductPriceTextField.getText());
            int stock = Integer.parseInt(modifyProductInvTextField.getText());
            int max = Integer.parseInt(modifyProductMaxTextField.getText());
            int min = Integer.parseInt(modifyProductMinTextField.getText());
            int id = Integer.parseInt(modifyProductIDTextField.getText());
            if (stock < min || stock > max)
            {
                modifyProductMinTextField.clear();
                modifyProductMaxTextField.clear();
                modifyProductInvTextField.clear();
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Information Dialog");
                alert.setHeaderText("Error!");
                alert.setContentText("Inventory Level not within minimum and maximum" + "\ninventory requirements");
                alert.showAndWait();
            } else
            {
                Product newProduct = new Product(id, name, price, stock, min, max, bottomList);
                Inventory.getAllProducts().set(id - 1, newProduct);
                success = true;
            }
        } catch (Exception e)
        {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Information Dialog");
            alert.setHeaderText("Error!");
            alert.setContentText("Product not added successfully. Double check all fields");
            alert.showAndWait();
            success = false;
        } finally
        {
            if (success)
            {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Confirmation Dialog");
                alert.setHeaderText("Confirm!");
                alert.setContentText("Product Added Successfully");
                alert.showAndWait();
                stage = (Stage) ((Button) actionEvent.getSource()).getScene().getWindow();
                scene = FXMLLoader.load(getClass().getResource("ModifyProduct.fxml"));
                stage.setTitle("Modify Product Menu");

                stage.setScene(new Scene(scene));
                stage.show();
            }
        }
    }

    @FXML
    private void onActionModifyProductCancel(ActionEvent actionEvent) throws IOException
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
    private void onActionAddToBottomTable(ActionEvent actionEvent)
    {
        Part toMove = modifyProductTableViewTop.getSelectionModel().getSelectedItem();
        if(toMove == null)
        {
            return;
        }
        bottomList.add(toMove);
        topList.remove(toMove);
        modifyProductTableViewTop.setItems(topList);
        modifyProductTableViewBottom.setItems(bottomList);
    }

    public void sendProduct(Product prod)
    {
        modifyProductIDTextField.setText(String.valueOf(prod.getId()));
        modifyProductNameTextField.setText(prod.getName());
        modifyProductInvTextField.setText(String.valueOf(prod.getStock()));
        modifyProductPriceTextField.setText(String.valueOf(prod.getPrice()));
        modifyProductMinTextField.setText(String.valueOf(prod.getMin()));
        modifyProductMaxTextField.setText(String.valueOf(prod.getMax()));
        if (!(prod.getAssociatedParts() == null))
        {
            bottomList.addAll(prod.getAssociatedParts());
            modifyProductTableViewBottom.setItems(prod.getAssociatedParts());

        } else
        {
            bottomList.clear();
        }
        topList.addAll(Inventory.getAllParts());
        modifyProductTableViewTop.setItems(topList);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources)
    {
        modifyProductTableViewTop.setItems(topList);
        modifyProductPartIDTopColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        modifyProductPartNameTopColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        modifyProductInvTopColumn.setCellValueFactory(new PropertyValueFactory<>("stock"));
        modifyProductPriceTopColumn.setCellValueFactory(new PropertyValueFactory<>("price"));

        modifyProductTableViewBottom.setItems(bottomList);
        modifyProductPartIDBottomColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        modifyProductPartNameBottomColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        modifyProductPartInvBottomColumn.setCellValueFactory(new PropertyValueFactory<>("stock"));
        modifyProductPriceBottomColumn.setCellValueFactory(new PropertyValueFactory<>("price"));
    }

    @FXML
    private void onActionModifyProductSearchTextFieldMouseExit(MouseEvent mouseEvent)
    {
        if (modifyProductSearchTextField.getText().isEmpty())
        {
            modifyProductTableViewTop.setItems(topList);
        }
    }
}
