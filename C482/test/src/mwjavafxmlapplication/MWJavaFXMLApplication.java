package mwjavafxmlapplication;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.DataProvider;
import model.Dog;

public class MWJavaFXMLApplication extends Application {

    @Override
    public void start(Stage stage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("/view/MainMenu.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        Dog dog1 = new Dog(1,"Argentino",15,"licky",222.99, true,"no");
        Dog dog2 = new Dog(2,"Anatolian Lab",5,"barky",199.99, false,"yes");
        Dog dog3 = new Dog(3,"Pit-Bull",7,"bitey",129.99, true,"no");
        Dog dog4 = new Dog(4,"Alaskan Malamute",17,"chill",125.99, false,"yes");
        Dog dog5 = new Dog(5,"Anatolian Shephard",10,"smarty",214.99, true,"no");
        DataProvider.addAnimal(dog1);
        DataProvider.addAnimal(dog2);
        DataProvider.addAnimal(dog3);
        DataProvider.addAnimal(dog4);
        DataProvider.addAnimal(dog5);

        launch(args);
    }
}
