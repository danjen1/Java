package sample;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;



public class Test extends Application {

    @Override
    public void start(Stage primaryStage) {

        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25,25,25,25));

        Scene scene = new Scene(grid, 375, 275);

        Text scenetitle = new Text("Please Login: ");

        scenetitle.setFont(Font.font("Tahoma",FontWeight.NORMAL, 20));
        Label userName = new Label("User Name:");
        TextField userTextField = new TextField();
        Label pw = new Label("Password: ");
        PasswordField pwBox = new PasswordField();
        pwBox.setId("login-boxes");
        userTextField.setId("login-boxes");

        grid.add(scenetitle,0,0,2,1);
        grid.add(userName,0,1);
        grid.add(userTextField, 1,1);
        grid.add(pw,0,2);
        grid.add(pwBox,1,2);
        grid.setGridLinesVisible(true);

        Button btn = new Button("Sign in");
        HBox hbBtn = new HBox(10);
        Button btn1 = new Button("Cancel");
        hbBtn.setAlignment(Pos.BOTTOM_RIGHT);
        hbBtn.getChildren().add(btn);
        hbBtn.getChildren().add(btn1);
        grid.add(hbBtn,1,4);

        final Text actiontarget = new Text();
        actiontarget.setId("action-target");
        grid.add(actiontarget,1,6, 2,1);
        btn.setOnAction(event ->
        {
            actiontarget.setFill(Color.FIREBRICK);
            actiontarget.setText("Sign in button pressed");
            userTextField.clear();
            pwBox.clear();

        });

        btn1.setOnAction(event ->
        {
            actiontarget.setFill(Color.ORANGE);
            actiontarget.setText("All Clear!");
            userTextField.clear();
            pwBox.clear();
        });
        scene.getStylesheets().
                add(Test.class.getResource("Login.css").toExternalForm());
        primaryStage.setTitle("JavaFX Login Form");
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}