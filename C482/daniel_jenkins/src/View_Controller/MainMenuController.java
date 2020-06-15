package View_Controller;

import Model.Inventory;
import Model.Part;
import Model.Product;
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
import javafx.scene.input.MouseDragEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

public class MainMenuController implements Initializable
{
    Parent scene;
    Stage stage;

    @FXML
    private TextField productSearchTextField;
    @FXML
    private TextField partSearchTextField;
    @FXML
    private TableView<Part> partsTableView;
    @FXML
    private TableColumn<Part, Integer> partsPartID;
    @FXML
    private TableColumn<Part, String> partsPartName;
    @FXML
    private TableColumn<Part, Integer> partsInvLevel;
    @FXML
    private TableColumn<Part, Double> partsPricePerUnit;
    @FXML
    private TableView<Product> productsTableView;
    @FXML
    private TableColumn<Product, Integer> productsProductID;
    @FXML
    private TableColumn<Product, String> productsProductName;
    @FXML
    private TableColumn<Product, Integer> productsProductInvLevel;
    @FXML
    private TableColumn<Product, Double> productsPricePerUnit;

    @Override
    public void initialize(URL location, ResourceBundle resources)
    {
        partsTableView.setItems(Inventory.getAllParts());

        partsPartID.setCellValueFactory(new PropertyValueFactory<>("id"));
        partsPartName.setCellValueFactory(new PropertyValueFactory<>("name"));
        partsInvLevel.setCellValueFactory(new PropertyValueFactory<>("stock"));
        partsPricePerUnit.setCellValueFactory(new PropertyValueFactory<>("price"));

        productsTableView.setItems(Inventory.getAllProducts());
        productsProductID.setCellValueFactory(new PropertyValueFactory<>("id"));
        productsProductName.setCellValueFactory(new PropertyValueFactory<>("name"));
        productsProductInvLevel.setCellValueFactory(new PropertyValueFactory<>("stock"));
        productsPricePerUnit.setCellValueFactory(new PropertyValueFactory<>("price"));
    }

    @FXML
    private void onActionSearchPart(ActionEvent actionEvent)
    {
        ObservableList<Part> searched = FXCollections.observableArrayList();
        String searchValue = partSearchTextField.getText();
        boolean found = false;

        try
        {
            int itemNumber = Integer.parseInt(searchValue);
            for (Part part : Inventory.getAllParts())
            {
                if (part.getId() == itemNumber)
                {
                    System.out.println("This is part " + itemNumber);
                    found = true;
                    searched.add(part);
                    partsTableView.setItems(searched);
                    Platform.runLater(() ->
                    {
                        partsTableView.requestFocus();
                        partsTableView.getSelectionModel().select(0);
                        partsTableView.scrollTo(0);
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
                partsTableView.setItems(Inventory.getAllParts());
            }
        } catch (NumberFormatException e)
        {
            for (Part part : Inventory.getAllParts())
            {
                if (part.getName().equalsIgnoreCase(searchValue))
                {
                    found = true;

                    searched.add(part);
                    partsTableView.setItems(searched);
                    Platform.runLater(() ->
                    {
                        partsTableView.requestFocus();
                        partsTableView.getSelectionModel().select(0);
                        partsTableView.scrollTo(0);
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
                partsTableView.setItems(Inventory.getAllParts());
            }
        }
    }

    @FXML
    private void onActionAddPart(ActionEvent actionEvent) throws IOException
    {
        stage = (Stage)((Button)actionEvent.getSource()).getScene().getWindow();
        scene = FXMLLoader.load(getClass().getResource("AddPartScreen.fxml"));
        stage.setTitle("Add Part Menu");

        stage.setScene(new Scene(scene));
        stage.show();
    }

    @FXML
    private void onActionModifyPart(ActionEvent actionEvent) throws IOException
    {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("ModifyPart.fxml"));
        loader.load();

        ModifyPartScreenController modifyPartsController =  loader.getController();
        modifyPartsController.sendPart(partsTableView.getSelectionModel().getSelectedItem());

        stage = (Stage) ((Button) actionEvent.getSource()).getScene().getWindow();
        stage.setTitle("Modify Part Menu");

        Parent scene = loader.getRoot();
        stage.setScene(new Scene(scene));
        stage.show();
    }

    @FXML
    private void onActionDeletePart(ActionEvent actionEvent)
    {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Are you sure you want to delete Part?");
        Optional<ButtonType> result = alert.showAndWait();
        if (result.isPresent() && result.get() == ButtonType.OK)
        {
            Inventory.getAllParts().remove(partsTableView.getSelectionModel().getSelectedItem());
            partsTableView.setItems(Inventory.getAllParts());
        }
    }

    @FXML
    private void onActionExitMainMenu(ActionEvent actionEvent)
    {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Are you sure you want to Exit?");
        Optional<ButtonType> result = alert.showAndWait();
        if (result.isPresent() && result.get() == ButtonType.OK)
        {
            System.exit(0);
        }
    }

    @FXML
    private void onActionSearchProduct(ActionEvent actionEvent)
    {
        ObservableList<Product> searched = FXCollections.observableArrayList();
        String searchValue = productSearchTextField.getText();
        boolean found=false;
        try{
            int itemNumber = Integer.parseInt(searchValue);
            for(Product product : Inventory.getAllProducts()){
                if(product.getId() == itemNumber){
                    found=true;
                    searched.add(product);
                    productsTableView.setItems(searched);
                    Platform.runLater(() ->
                    {
                        productsTableView.requestFocus();
                        productsTableView.getSelectionModel().select(0);
                        productsTableView.scrollTo(0);
                    });
                }
            }
            if (found==false){
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Information Dialog");
                alert.setHeaderText("Error!");
                alert.setContentText("Product not found");

                alert.showAndWait();
            }
    } catch (NumberFormatException e)
    {
        for (Product product : Inventory.getAllProducts())
        {
            if (product.getName().equalsIgnoreCase(searchValue))
            {
                found = true;

                searched.add(product);
                productsTableView.setItems(searched);
                Platform.runLater(() ->
                {
                    productsTableView.requestFocus();
                    productsTableView.getSelectionModel().select(0);
                    productsTableView.scrollTo(0);
                });
            }
        }
        if (found == false)
        {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Information Dialog");
            alert.setHeaderText("Error");
            alert.setContentText("Product not found");

            alert.showAndWait();
            productsTableView.setItems(Inventory.getAllProducts());
        }
    }
}

    @FXML
    private void onActionAddProduct(ActionEvent actionEvent) throws IOException
    {
        stage = (Stage)((Button)actionEvent.getSource()).getScene().getWindow();
        scene = FXMLLoader.load(getClass().getResource("AddProductScreen.fxml"));
        stage.setTitle("Add Product Menu");
        stage.setScene(new Scene(scene));
        stage.show();
    }

    @FXML
    private void onActionModifyProduct(ActionEvent actionEvent) throws IOException
    {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("ModifyProduct.fxml"));
        loader.load();

        ModifyProductScreenController modifyProdController =  loader.getController();
        modifyProdController.sendProduct(productsTableView.getSelectionModel().getSelectedItem());

        stage = (Stage) ((Button) actionEvent.getSource()).getScene().getWindow();
        stage.setTitle("Modify Product Menu");

        Parent scene = loader.getRoot();
        stage.setScene(new Scene(scene));
        stage.show();
    }

    @FXML
    private void onActionDeleteProduct(ActionEvent actionEvent)
    {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Are you sure you want to delete Product?");
        Optional<ButtonType> result = alert.showAndWait();
        if (result.isPresent() && result.get() == ButtonType.OK)
        {
            Inventory.getAllProducts().remove(productsTableView.getSelectionModel().getSelectedItem());
            productsTableView.setItems(Inventory.getAllProducts());
        }
    }

    @FXML
    private void onActionMainMenuProductsSearchMouseExited(MouseEvent mouseEvent)
    {
        if (productSearchTextField.getText().isEmpty())
        {
            productsTableView.setItems(Inventory.getAllProducts());
        }
    }

    @FXML
    private void onActionMainMenuPartsMousexited(MouseEvent mouseEvent)
    {
        if (partSearchTextField.getText().isEmpty())
        {
            partsTableView.setItems(Inventory.getAllParts());
        }

    }
}
