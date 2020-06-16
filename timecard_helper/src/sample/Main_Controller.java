package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;

import java.net.URL;
import java.util.ResourceBundle;

public class Main_Controller implements Initializable

{
    @FXML
    public TextField hoursWorkedTextField;
    @FXML
    public TextField numMinutesTextField;
    @FXML
    public Label paidDownTimeLbl;
    @FXML
    public RadioButton fiveByEightRbtn;
    @FXML
    public RadioButton fourByTenRbtn;
    @FXML
    public Label convertedMinsLbl;


    public void onActionExitBtn(ActionEvent actionEvent) {
        System.exit(0);
    }

    public void onActionSubmitBtn(ActionEvent actionEvent) {

            if (hoursWorkedTextField.getText().isEmpty()) {
                double num3 = Double.parseDouble(numMinutesTextField.getText());
                num3 = num3/60;
                num3 = Math.round(num3 * 100.0) / 100.0;
                numMinutesTextField.setText(String.valueOf(num3));
                paidDownTimeLbl.setText("");

            } else{

                double num1 = 10.0;
                double num2 = Double.parseDouble(hoursWorkedTextField.getText());

                if(fiveByEightRbtn.isSelected()) {
                    num1 = 8.0;
                }
                double a = dt(num1, num2);
                double dec = (a - (long) a) * 60;
                a = Math.floor(a);
                int b = (int) a;
                int c = (int) dec;
                paidDownTimeLbl.setText(String.valueOf(b + " hrs " + c + " mins"));

                double num3 = Double.parseDouble(numMinutesTextField.getText());
                num3 = num3/60;
                num3 = Math.round(num3 * 100.0) / 100.0;
                numMinutesTextField.setText(String.valueOf(num3));
                hoursWorkedTextField.clear();
                fiveByEightRbtn.setSelected(false);
                fourByTenRbtn.setSelected(false);

            }

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        hoursWorkedTextField.clear();
        numMinutesTextField.clear();
        paidDownTimeLbl.setText("");
        fiveByEightRbtn.setSelected(false);
        fourByTenRbtn.setSelected(false);
    }
    public static double dt(double shft,  double hrs){
        return (shft - hrs) / 2;
    }
}

