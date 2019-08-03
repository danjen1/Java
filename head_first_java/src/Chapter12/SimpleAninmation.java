package Chapter12;
import javax.swing.*;
import java.awt.*;


public class SimpleAninmation
{
    int x = 70;
    int y = 70;

    public static void main(String[] args)
    {
        SimpleAninmation gui = new SimpleAninmation();
        gui.go();
    }

    public void go()
    {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        MyDrawPanel1 drawPanel = new MyDrawPanel1();

        frame.getContentPane().add(drawPanel);
        frame.setSize(300, 300);
        frame.setVisible(true);

        for (int i = 0; i < 130; i++)
        {
            x++;
            y++;
            drawPanel.repaint();
            try
            {
                Thread.sleep(5);
            } catch (Exception ex)
            {
            }
        }
    }

    class MyDrawPanel1 extends JPanel
    {
        public void paintComponent(Graphics g)
        {
            g.setColor(Color.white);
            g.fillRect(0, 0, this.getWidth(), this.getHeight());
            g.setColor(Color.blue);
            g.fillOval(x, y, 40, 40);
        }
    }


}
