package Chapter13;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.util.EventListener;

public class JCheck implements ItemListener
{
    JCheckBox box;

    public static void main(String[] args)
    {
        JCheck gui = new JCheck();
        gui.go();
    }

    public void go()
    {
        JFrame frame = new JFrame();
        JPanel panel = new JPanel();
        box = new JCheckBox("Goes to 11");
        panel.add(box);

        box.addItemListener(this);
        box.setSelected(true);

        panel.add(box);
        frame.getContentPane().add(BorderLayout.EAST, box);
        frame.setSize(500, 500);
        frame.setVisible(true);
    }

    public void itemStateChanged(ItemEvent ev)
    {
        String onorOff = "off";
        if (box.isSelected())
        {
            onorOff = "on";
        }
        System.out.println("CheckBox is " + onorOff);
    }
}
