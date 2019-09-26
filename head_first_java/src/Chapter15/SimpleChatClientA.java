package Chapter15;
import java.awt.*;
import javax.swing.*;
import java.io.*;
import java.net.*;
import java.awt.event.*;

public class SimpleChatClientA
{
    JTextField outgoing;
    PrintWriter writer;
    Socket sock;

    public void go()
    {
        //make GUI and register a listener with the send button
        //call the setUpNetworking() method

        JFrame frame = new JFrame("Luicrously Simple Chat Client");
        frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
        JPanel panel = new JPanel();
        outgoing = new JTextField(20);
        Font bigFont = new Font("sanserif", Font.PLAIN, 18);
        outgoing.setFont(bigFont);
        JButton send = new JButton("Send");
        send.addActionListener(new SendButtonListener());

        panel.add(outgoing);
        panel.add(send);
        frame.getContentPane().add(BorderLayout.CENTER, panel);
        setUpNetworking();
        frame.setSize(600, 200);
        frame.setVisible(true);
    }

    private void setUpNetworking()
    {
        //make a Socket, then make a PrintWriter
        //assign the PrintWriter to writer instance veriable
        try
        {
            sock = new Socket("127.0.0.1", 5000);
            writer = new PrintWriter(sock.getOutputStream());

        } catch (IOException ex)
        {
            ex.printStackTrace();
        }
    }

    public class SendButtonListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            //get the text from the text field and
            //send it tot he server using the writer (a PrinterWriter)
            try
            {
                writer.println(outgoing.getText());
                writer.flush();
            } catch (Exception ex)
            {
                ex.printStackTrace();
            }
            outgoing.setText("");
            outgoing.requestFocus();
        }
    }

    public static void main(String[] args)
    {
        SimpleChatClientA a = new SimpleChatClientA();
        a.go();
    }

}
