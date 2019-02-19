package Chapter12;
import javax.swing.*;
import java .awt.*;
import java.awt.event.*;

public class TwoButtons
{
    JFrame frame;
    JLabel label;
    public static void main(String[] args)
    {
        TwoButtons gui = new TwoButtons();
        gui.go();
    }

    public void go()
    {
        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //JButton labelButton = new JButton("Change Label");
        //labelButton.addActionListener(new LabelListener());

        JButton open = new JButton("Open");
        open.addActionListener(new openListener());
        JButton start = new JButton("New");
        start.addActionListener(new startListener());



        frame.getContentPane().add(BorderLayout.SOUTH, open);
        frame.getContentPane().add(BorderLayout.SOUTH, start);


        frame.setSize(200, 200);
        frame.setVisible(true);
    }

    public class openListener implements ActionListener
    {
        public void actionPerformed(ActionEvent event)
        {
            label.setText("Ouch");
        }
    }

    public class startListener implements ActionListener
    {
        public void actionPerformed(ActionEvent event)
        {
            frame.repaint();
        }
    }

}
