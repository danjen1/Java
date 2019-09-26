package Chapter12;
import javax.swing.*;

public class SimpleGui
{
    public static void main(String[] args)
    {
        JFrame frame = new JFrame();
        JButton button = new JButton("Click Me");

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(button);
        frame.setSize(150, 150);
        frame.setVisible(true);
    }
}
