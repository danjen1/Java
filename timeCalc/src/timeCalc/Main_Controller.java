package timeCalc;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

import java.net.URL;
import java.util.ResourceBundle;

public class Main_Controller implements Initializable

{
    @FXML
    public TextField hoursWorkedTextField;
    @FXML
    public TextField numMinutesTextField;
    @FXML
    public Label hrsMinsLbl;
    @FXML
    public RadioButton fiveByEightRbtn;
    @FXML
    public RadioButton fourByTenRbtn;
    @FXML
    public Label convertedLbl;
    @FXML
    public Button submitBtn;


    public void submitEnter(KeyEvent keyEvent) {

        if (submitBtn.isFocused() && keyEvent.getCode() == KeyCode.ENTER){
                submit();
            }
    }

    public void onActionSubmitBtn(ActionEvent actionEvent) {
        submit();
    }

    public void submit(){
        if (!hoursWorkedTextField.getText().isEmpty() && (!(numMinutesTextField.getText().isEmpty()))){
            submitMins();
            submitDT();
        }
        else if (numMinutesTextField.getText().isEmpty()){
            submitDT();
            convertedLbl.setText("0.00");
            numMinutesTextField.clear();

        } else if (hoursWorkedTextField.getText().isEmpty()){
            submitMins();
            fiveByEightRbtn.setSelected(false);
            fourByTenRbtn.setSelected(false);
            hrsMinsLbl.setText("0 hours/ 0 minutes");
        }

    }

    public void submitMins() {
        {
            double num3 = Double.parseDouble(numMinutesTextField.getText());
            num3 = num3 / 60;
            num3 = Math.round(num3 * 100.0) / 100.0;
            convertedLbl.setText(String.valueOf(num3));
        }
    }

    public void submitDT(){
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
            hrsMinsLbl.setText(b + " hours " + c + " minutes");
        }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        hoursWorkedTextField.clear();
        numMinutesTextField.clear();
        fiveByEightRbtn.setSelected(false);
        fourByTenRbtn.setSelected(false);
    }
    public static double dt(double shft,  double hrs){
        return (shft - hrs) / 2;
    }
}

