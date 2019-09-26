package Chapter13;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class JTextAr implements ActionListener
{
    JTextArea text = new JTextArea();
    public static void main(String[] args)
    {
        JTextAr gui = new JTextAr();
        gui.go();
    }

    public void go()
    {
        JFrame frame = new JFrame();
        JPanel panel = new JPanel();
        JButton button = new JButton("Just Click It");
        button.addActionListener(this);
        JCheckBox checkBox = new JCheckBox("Goes to 11");

        text = new JTextArea(10, 20);
        text.setLineWrap(true);
        Font areaFont = new Font("serif", Font.BOLD, 18);
        text.setFont(areaFont);

        JScrollPane scroller = new JScrollPane(text);
        scroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        panel.add(scroller);

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.getContentPane().add(BorderLayout.CENTER, panel);
        frame.getContentPane().add(BorderLayout.SOUTH, button);
        frame.setVisible(true);
        frame.setSize(350, 300);

    }

    public void actionPerformed(ActionEvent ev)
    {
        text.append("I Love Cara\n She's the Best \n  And Prettiest!!! \n");
        System.out.println();
        System.out.println();
    }
}
