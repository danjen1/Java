package Chapter13;
import javax.swing.*;
import java.awt.*;
import java.util.function.BinaryOperator;

public class Panel1
{
    public static void main(String[] args)
    {
        Panel1 gui = new Panel1();
        gui.go();
    }

    public void go()
    {

        ImageIcon img = new ImageIcon("Chapter13/1200x630bb.png");
        JFrame frame = new JFrame();
        frame.setIconImage(img.getImage());
        JPanel panel = new JPanel();
        panel.setBackground(Color.darkGray);
        panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));

        JButton button = new JButton("Shock Me");
        JButton buttonTwo = new JButton("bliss");
        JButton buttonThree = new JButton("huh?");
        panel.add(button);
        panel.add(buttonTwo);
        panel.add(buttonThree);

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.getContentPane().add(BorderLayout.SOUTH, panel);
        frame.setVisible(true);
        frame.setSize(250, 250);

    }
}

