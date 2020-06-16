import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.event.*;
public class Form
{


    public Form()
    {
        JFrame f=new JFrame("TimeHelper");
        f.setLocation(250,100);
        //east
        JPanel jpcalc=new JPanel();
        //center
        JLabel jfirstN=new JLabel("# mins to convert");
        JLabel jSecondN=new JLabel("# shift hours");
        JLabel jresult=new JLabel("# hours worked");
        final JTextField jtext=new JTextField(5);
        final JTextField jtext1=new JTextField(5);
        final JTextField jresult1=new JTextField(5);

        JPanel jpcenter=new JPanel();

        JButton jbSub =new JButton("Run");
        JButton jbDiv =new JButton("Quit");
        JPanel jbButons=new JPanel();


        jpcalc.setLayout(new FlowLayout(FlowLayout.LEFT));
        jpcenter.setLayout(new GridLayout(3,2,1,4));


        jpcenter.add(jfirstN);
        jpcenter.add(jtext);
        jpcenter.add(jSecondN);
        jpcenter.add(jtext1);
        jpcenter.add(jresult);
        jpcenter.add(jresult1);
        jbButons.add(jbSub);
        jbButons.add(jbDiv);
        Container c=f.getContentPane();
        c.add(jpcalc,BorderLayout.NORTH);
        c.add(jpcenter,BorderLayout.CENTER);
        c.add(jbButons,BorderLayout.SOUTH);
        f.pack();
        f.setVisible(true);
        jbSub.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                int x=Integer.parseInt(jtext.getText());
                int y=Integer.parseInt(jtext1.getText());
                jresult1.setText(String.valueOf(x-y));
            }});

        jbDiv.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                int x=Integer.parseInt(jtext.getText());
                int y=Integer.parseInt(jtext1.getText());
                jresult1.setText(String.valueOf(x/y));
            }});
    }

}