import javax.swing.*;
import java .awt.*;
import java.awt.event.*;

public class OpenPanel implements ActionListener {
    JFrame frame;

    public void go() {
        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JButton open = new JButton("Open");
        open.addActionListener(this);
        JButton start = new JButton("Start New");
        start.addActionListener(this);
        JLabel exp = new JLabel("Open A MAD_LIB or Start New", JLabel.CENTER);

        frame.add(open, BorderLayout.NORTH);
        frame.add(exp, BorderLayout.CENTER);
        frame.add(start, BorderLayout.SOUTH);
        frame.setSize(350, 200);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        OpenPanel op = new OpenPanel();
        op.go();

    }
}


