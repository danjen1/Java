import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.sql.*;

public class Form extends javax.swing.JFrame {

    public Form() {
        initComponents();
    }

    private void initComponents() {


        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        buttonGroup3 = new javax.swing.ButtonGroup();
        buttonGroup4 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jRadioButton2 = new javax.swing.JRadioButton();
        jRadioButton1 = new javax.swing.JRadioButton();
        jButton7 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jButton6 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jRadioButton3 = new javax.swing.JRadioButton();
        jRadioButton4 = new javax.swing.JRadioButton();
        jLabel4 = new javax.swing.JLabel();
        jRadioButton5 = new javax.swing.JRadioButton();
        jRadioButton6 = new javax.swing.JRadioButton();
        jLabel5 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jRadioButton7 = new javax.swing.JRadioButton();
        jRadioButton8 = new javax.swing.JRadioButton();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("T2 Consult Form");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(" Consult Info "));

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel1.setText("Case ID:");

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("KBASE:");

        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel7.setText("Relevant KBASE:");

        buttonGroup1.add(jRadioButton2);
        jRadioButton2.setText("No");
        jRadioButton2.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        jRadioButton2.setMargin(new java.awt.Insets(0, 0, 0, 0));

        buttonGroup1.add(jRadioButton1);
        jRadioButton1.setText("Yes");
        jRadioButton1.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        jRadioButton1.setMargin(new java.awt.Insets(0, 0, 0, 0));

        jButton7.setText("Clear");
        jButton7.addActionListener(new clearListener());

        jTextArea1.setColumns(30);
        jTextArea1.setRows(5);
        jScrollPane2.setViewportView(jTextArea1);

        jButton6.setText("Submit");
        jButton6.addActionListener(new submitListener());

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("Callback #:");

        buttonGroup2.add(jRadioButton3);
        jRadioButton3.setText("Yes");

        buttonGroup2.add(jRadioButton4);
        jRadioButton4.setText("No");

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("Contact Email:");
        buttonGroup3.add(jRadioButton5);
        jRadioButton5.setText("No");
        buttonGroup3.add(jRadioButton6);
        jRadioButton6.setText("Yes");

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setText("Comments:");

        jButton1.setText("Email");
        jButton1.addActionListener(new emailListener());

        jButton2.setText("Quit");
        jButton2.addActionListener(new quitListener());


        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Resource-Locating", "Resource-Confusion", "Gain Agreement", "Soft Skills", "Positioning", "Other" }));
        jComboBox1.setVisible(true);
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel8.setText("Consult Reason:");
        jLabel8.setVisible(true);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(341, 341, 341)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jButton6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jButton7))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                                .addGap(0, 7, 7)
                                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(0, 6, Short.MAX_VALUE))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 92, Short.MAX_VALUE)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                .addGap(6, 6, 6)))
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                                .addComponent(jRadioButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(jRadioButton4))
                                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                                .addComponent(jRadioButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(jRadioButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                        .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                                .addGap(6, 6, 6)
                                                                .addComponent(jRadioButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(jRadioButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                        .addComponent(jLabel5)
                                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 471, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jRadioButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jRadioButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel1)
                                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel2))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jRadioButton1)
                                        .addComponent(jRadioButton2)
                                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel3)
                                        .addComponent(jRadioButton3)
                                        .addComponent(jRadioButton4))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel4)
                                        .addComponent(jRadioButton6)
                                        .addComponent(jRadioButton5))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel6)
                                        .addComponent(jRadioButton7)
                                        .addComponent(jRadioButton8)
                                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel8))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 19, Short.MAX_VALUE)
                                .addComponent(jLabel5)
                                .addGap(2, 2, 2)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jButton6)
                                        .addComponent(jButton7))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jButton1)
                                        .addComponent(jButton2))
                                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jPanel1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addContainerGap())
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(10, Short.MAX_VALUE))
        );

        jPanel1.getAccessibleContext().setAccessibleName(" Case ");

        pack();
    }

    public class submitListener implements ActionListener
    {
        public void actionPerformed(ActionEvent a)
        {
            Connection c;
            Statement stmt;
            String caseID = jTextField1.getText();
            String kBase = jTextField2.getText();
            Boolean yKbase = jRadioButton1.isSelected();
            Boolean ycallBack = jRadioButton3.isSelected();
            Boolean ycontactEmail = jRadioButton6.isSelected();
            String comments = jTextArea1.getText();
            Boolean validConsult = jRadioButton7.isSelected();
            String reason = jComboBox1.getSelectedItem().toString();
            String uname = System.getProperty("user.name");


           if (caseID.isEmpty() || (kBase.isEmpty()))
            {
                if (JOptionPane.showConfirmDialog(
                        new JFrame(),
                        "Not all fields are complete. Are you sure you want to submit?",
                        "Please confirm",
                        JOptionPane.YES_NO_OPTION) == JOptionPane.NO_OPTION)
                {
                    return;
                }

            }
                try
                {
                    Class.forName("org.sqlite.JDBC");
                    String path = System.getProperty("user.home") + "/Library/Application " + "Support/"
                            + "Consults/";
                    c = DriverManager.getConnection("jdbc:sqlite:" + path + uname + "database");
                    c.setAutoCommit(false);
                    String sqlCreate = "CREATE TABLE IF NOT EXISTS consult" +
                            "(" +
                            "    date DATETIME DEFAULT current_date," +
                            "    caseID VARCHAR(20)," +
                            "    Kbase VARCHAR(50)," +
                            "    correctKbase BOOLEAN," +
                            "    callback BOOLEAN," +
                            "    contactEmail BOOLEAN," +
                            "    validConsult BOOLEAN," +
                            "    reason VARCHAR(35)," +
                            "    uname VARCHAR(20)," +
                            "    time DATETIME DEFAULT current_time," +
                            "    comments VARCHAR(500)" +
                            ");" +
                            "CREATE UNIQUE INDEX consult_pKey_uindex ON consult (time);";
                    stmt = c.createStatement();
                    stmt.execute(sqlCreate);

                    PreparedStatement prep = c.prepareStatement("INSERT INTO consult(caseID, Kbase, correctKbase, callback, contactEmail, validConsult, reason, uname, comments) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?)");
                    prep.setString(1, caseID);
                    prep.setString(2, kBase);
                    prep.setBoolean(3, yKbase);
                    prep.setBoolean(4, ycallBack);
                    prep.setBoolean(5, ycontactEmail);
                    prep.setBoolean(6, validConsult);
                    prep.setString(7, reason);
                    prep.setString(8, uname);
                    prep.setString(9, comments);


                    prep.executeUpdate();

                    prep.close();
                    c.commit();
                    c.close();
                } catch (Exception e)
                {
                    System.err.println(e.getClass().getName() + ": " + e.getMessage());
                    System.exit(0);
                }
                JOptionPane.showMessageDialog(null, "Record Submitted Successfully");
                clear();
            }
            }

    public class clearListener implements ActionListener
    {
        public void actionPerformed(ActionEvent a)
        {
            clear();
        }
    }
    public class quitListener implements ActionListener
    {
        public void actionPerformed(ActionEvent a)
        {
            if (JOptionPane.showConfirmDialog(
                    new JFrame(),
                    "Are you sure you want to quit?",
                    "Please confirm",
                    JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION
            )
            {
                System.exit(0);
            }
        }
    }
    public class emailListener implements ActionListener
    {
        public void actionPerformed(ActionEvent a)
        {
            Desktop d = Desktop.getDesktop();
            try
            {
                d.open(new File(System.getProperty("user.home") + "/Library/Application Support/Consults/"));
            } catch (IOException e)
            {
                e.printStackTrace();
            }

            JOptionPane.showMessageDialog(null, "Share 'database' with Mail from the Finder window that just opened.\n" +
                    "Email to: daniel_jenkins@apple.com");
        }
    }


    public void clear(){
        buttonGroup1.clearSelection();
        buttonGroup2.clearSelection();
        buttonGroup3.clearSelection();
        buttonGroup4.clearSelection();
        jComboBox1.setVisible(true);
        jLabel8.setVisible(false);
        jTextArea1.setText(null);
        jTextField1.setText(null);
        jTextField2.setText(null);

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.ButtonGroup buttonGroup3;
    private javax.swing.ButtonGroup buttonGroup4;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JRadioButton jRadioButton3;
    private javax.swing.JRadioButton jRadioButton4;
    private javax.swing.JRadioButton jRadioButton5;
    private javax.swing.JRadioButton jRadioButton6;
    private javax.swing.JRadioButton jRadioButton7;
    private javax.swing.JRadioButton jRadioButton8;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;

    // End of variables declaration//GEN-END:variables

}


