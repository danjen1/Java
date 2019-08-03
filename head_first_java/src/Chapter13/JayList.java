package Chapter13;
import java.util.*;
import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.*;

public class JayList implements ListSelectionListener
{
    JList list;

    public static void main(String[] args)
    {
        JayList gui = new JayList();
        gui.go();
    }

    public void go()
    {
        JFrame frame = new JFrame();
        JPanel panel = new JPanel();
        String[] str = {"alpha", "beta", "gamma", "delta", "epsilon", "zeta", "eta", "theta"};
        list = new JList<String>(str);

        list.setVisibleRowCount(4);
        list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        list.addListSelectionListener(this);
        JScrollPane scroller = new JScrollPane(list);
        scroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        scroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);

        panel.add(scroller);
        panel.setSize(55, 250);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        frame.getContentPane().add(BorderLayout.WEST, panel);
        frame.setSize(500, 500);
        frame.setVisible(true);

    }

    public void valueChanged(ListSelectionEvent lse)
    {
        if (!lse.getValueIsAdjusting())
        {
            String selection = (String) list.getSelectedValue();
            System.out.println(selection);
        }
    }
}
