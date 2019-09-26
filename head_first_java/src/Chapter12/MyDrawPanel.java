package Chapter12;
import java.awt.*;
import javax.swing.*;

public class MyDrawPanel extends JPanel
{
    public void paintComponent(Graphics g)
    {
        g.setColor(Color.orange);
        g.fillRect(20,50,100,100);

        Image image = new ImageIcon("catzilla.jpg").getImage();
        g.drawImage(image, 3, 4, this);

        g.fillRect(0, 0, this.getWidth(), this.getHeight());

        int red = (int) (Math.random() * 255);
        int green = (int) (Math.random() * 255);
        int blue = (int) (Math.random() * 255);

        Color randomColor = new Color(red, green, blue);
        g.setColor(randomColor);
        g.fillOval(70, 70, 100, 100);

        Graphics2D g2d = (Graphics2D) g;

        GradientPaint gradient = new GradientPaint(70, 70, Color.blue, 150, 150, Color.orange);
        g2d.setPaint(gradient);
        g2d.fillOval(70,70,100,100);

        int red2D = (int) (Math.random() * 255);
        int green2D = (int) (Math.random() * 255);
        int blue2D = (int) (Math.random() * 255);
        Color startColor = new Color(red2D, green2D, blue2D);

        red2D = (int) (Math.random() * 255);
        green2D = (int) (Math.random() * 255 );
        blue2D = (int) (Math.random() * 255 );
        Color endColor = new Color(red2D, green2D, blue2D);

        GradientPaint gradient2 = new GradientPaint(70, 70, startColor, 150, 150, endColor);
        g2d.setPaint(gradient2);
        g2d.fillOval(70, 70, 100, 100);
    }
}
