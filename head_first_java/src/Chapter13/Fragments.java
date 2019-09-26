package Chapter13;
import javax.swing.*;
import java.awt.*;

public class Fragments
{
    public static void main(String[] args)
    {
        JFrame frame = new JFrame();
        JPanel panel = new JPanel();

        panel.setBackground(Color.darkGray);
        JButton button = new JButton("tesuji");
        JButton buttonTwo = new JButton("Watari");

        frame.getContentPane().add(BorderLayout.NORTH, buttonTwo);
        frame.getContentPane().add(BorderLayout.CENTER, button);

        panel.add(buttonTwo);
        frame.setSize(300, 300);
        frame.setVisible(true);
    }
}
