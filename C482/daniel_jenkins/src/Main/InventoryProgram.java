package Main;

import Model.*;
import com.sun.javafx.fxml.builder.JavaFXSceneBuilder;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class InventoryProgram extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("/View_Controller/MainMenu.fxml"));
        primaryStage.setTitle("Main Menu");
        primaryStage.setScene(new Scene(root, 1280, 780));
        primaryStage.show();
    }

    public static void main(String[] args) {
        ObservableList<Part> testParts= FXCollections.observableArrayList();
        ObservableList<Part> testParts1= FXCollections.observableArrayList();
        ObservableList<Part> testParts2= FXCollections.observableArrayList();
        ObservableList<Part> testParts3= FXCollections.observableArrayList();
        ObservableList<Part> testParts4= FXCollections.observableArrayList();
        ObservableList<Part> testParts5= FXCollections.observableArrayList();

        Part test = new Outsourced( "Wheel",29.99, 25, 1, 53, "Outsourcers United");
        Part test1 = new Outsourced( "Screw",149.99, 4, 1, 9, "LTD Out Inc");
        Part test2 = new Outsourced( "Jet Engine",123.99, 53, 1, 125, "PyroTech Out");

        Part test3 = new InHouse("Bolt",1.99,5, 3, 34,9546123);
        Part test4 = new InHouse("Nut",249.99,145, 6, 250,7413545);
        Part test5 = new InHouse("GPU",29.99,9, 1, 23,3456767);

        testParts.setAll(test, test1, test2, test3);
        testParts1.setAll(test1, test3);
        testParts2.setAll(test2, test3, test5);
        testParts3.setAll(test5, test4, test1, test);
        testParts4.setAll(test1, test4);
        testParts5.setAll(test4, test2, test1);

        Product prod1 = new Product( "Car",2599.99, 2, 1, 9, testParts);
        Product prod2 = new Product( "Plane",24999.99, 5, 1, 123, testParts2);
        Product prod3 = new Product( "Boat",219.99, 45, 1, 100, testParts3);
        Product prod4 = new Product( "House",13.99, 1234, 1, 12345, testParts1);
        Product prod5 = new Product( "BBQ",9.99, 0, 0, 9, testParts4);
        Product prod6 = new Product( "Televison",99.99, 13, 1, 25, testParts5);

        Inventory.getAllParts().addAll(test, test1, test2, test3, test4, test5);
        Inventory.getAllProducts().addAll(prod1, prod2, prod3, prod4, prod5, prod6);

        launch(args);
    }
}
