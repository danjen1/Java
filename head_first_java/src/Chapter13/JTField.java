package Chapter13;
import javax.swing.*;
import java.awt.*;

public class JTField
{
    public static void main(String[] args)
    {
        JFrame frame = new JFrame();
        JPanel panel = new JPanel();
        JTextField field = new JTextField();
        field.setSize(20, 30);
        field.setText("whatever");
        System.out.println(field.getText());
        field.selectAll();
        field.requestFocus();

        frame.setDefaultCloseOperation(3);

        panel.add(field);
        frame.getContentPane().add(BorderLayout.EAST, panel);
        frame.setSize(200, 200);
        frame.setVisible(true);



    }
}
