import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;

class Form extends javax.swing.JFrame
{
    public Form()
    {
        initComponents();
    }

    //Build GUI & Event Listeners
    private void initComponents()
    {

        assureButtonGroup = new javax.swing.ButtonGroup();
        cbButtonGroup = new javax.swing.ButtonGroup();
        emailButtonGroup = new javax.swing.ButtonGroup();
        contactNameButtonGroup = new javax.swing.ButtonGroup();
        JPanel consultPanel = new JPanel();
        JLabel caseIDLabel = new JLabel();
        caseTextField = new javax.swing.JTextField();
        JLabel rsrcLabel = new JLabel();
        rsrcTextField = new javax.swing.JTextField();
        JLabel reasonLabel = new JLabel();
        reasonCombo = new javax.swing.JComboBox();
        JLabel relevantLabel = new JLabel();
        assureYes = new javax.swing.JRadioButton();
        JRadioButton assureNo = new JRadioButton();
        JLabel cbLabel = new JLabel();
        cbYes = new javax.swing.JRadioButton();
        JRadioButton cbNo = new JRadioButton();
        JLabel emailLabel = new JLabel();
        emailYes = new javax.swing.JRadioButton();
        JRadioButton emailNo = new JRadioButton();
        JScrollPane commScrollPane = new JScrollPane();
        JLabel contactNameLabel = new JLabel();
        JRadioButton contactNameYes = new JRadioButton();
        JRadioButton contactNameNo = new JRadioButton();
        commTextArea = new javax.swing.JTextArea();
        JLabel commentsLabel = new JLabel();
        JButton quitButton = new JButton();
        JButton submitButton = new JButton();
        JButton emailButton = new JButton();
        JButton clearButton = new JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Behavior Tracker");

        consultPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Behavior Tracker"));

        caseIDLabel.setText("Case ID:");

        rsrcLabel.setText("Resource Used:");

        reasonLabel.setText("Resolution:");

        relevantLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        relevantLabel.setText("Assure:");

        assureButtonGroup.add(assureYes);
        assureYes.setText("Yes");
        assureYes.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        assureYes.setMargin(new java.awt.Insets(0, 0, 0, 0));

        assureButtonGroup.add(assureNo);
        assureNo.setText("No");
        assureNo.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        assureNo.setMargin(new java.awt.Insets(0, 0, 0, 0));

        cbLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        cbLabel.setText("Logging:");

        cbButtonGroup.add(cbYes);
        cbYes.setText("Yes");
        cbYes.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        cbYes.setMargin(new java.awt.Insets(0, 0, 0, 0));

        cbButtonGroup.add(cbNo);
        cbNo.setText("No");
        cbNo.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        cbNo.setMargin(new java.awt.Insets(0, 0, 0, 0));

        emailLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        emailLabel.setText("Knowledge:");

        emailButtonGroup.add(emailYes);
        emailYes.setText("Yes");
        emailYes.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        emailYes.setMargin(new java.awt.Insets(0, 0, 0, 0));

        emailButtonGroup.add(emailNo);
        emailNo.setText("No");
        emailNo.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        emailNo.setMargin(new java.awt.Insets(0, 0, 0, 0));

        commTextArea.setColumns(30);
        commTextArea.setRows(15);
        commScrollPane.setViewportView(commTextArea);

        commentsLabel.setText("Steps\nCompleted:");
        contactNameLabel.setHorizontalAlignment(SwingConstants.LEADING);
        contactNameLabel.setText("Screen Sharing:");

        contactNameButtonGroup.add(contactNameYes);
        contactNameYes.setText("Yes");
        contactNameYes.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        contactNameYes.setMargin(new java.awt.Insets(0, 0, 0, 0));

        contactNameButtonGroup.add(contactNameNo);
        contactNameNo.setText("No");
        contactNameNo.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        contactNameNo.setMargin(new java.awt.Insets(0, 0, 0, 0));

        reasonCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{"", "Resolved", "Unresolved - Solution Offered", "Unresolved - No Solution Offered", "Transfer to other Apple Dept", "Transfer 3rd Party", "Unable to Resolve Issue"}));


        javax.swing.GroupLayout consultPanelLayout = new javax.swing.GroupLayout(consultPanel);
        consultPanel.setLayout(consultPanelLayout);
        consultPanelLayout.setHorizontalGroup(
                consultPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(consultPanelLayout.createSequentialGroup()
                                .addContainerGap(7, Short.MAX_VALUE)
                                .addGroup(consultPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addGroup(consultPanelLayout.createSequentialGroup()
                                                .addGroup(consultPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(relevantLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(cbLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(emailLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(contactNameLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                .addGap(18, 18, 18)
                                                .addGroup(consultPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(consultPanelLayout.createSequentialGroup()
                                                                .addComponent(emailYes)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(emailNo))
                                                        .addGroup(consultPanelLayout.createSequentialGroup()
                                                                .addComponent(assureYes)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(assureNo))
                                                        .addGroup(consultPanelLayout.createSequentialGroup()
                                                                .addComponent(cbYes)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(cbNo))
                                                        .addGroup(consultPanelLayout.createSequentialGroup()
                                                                .addComponent(contactNameYes)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(contactNameNo))))
                                        .addGroup(consultPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(consultPanelLayout.createSequentialGroup()
                                                        .addGroup(consultPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                                .addComponent(reasonLabel)
                                                                .addComponent(rsrcLabel))
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addGroup(consultPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                                .addComponent(rsrcTextField)
                                                                .addComponent(reasonCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, consultPanelLayout.createSequentialGroup()
                                                        .addComponent(caseIDLabel)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(caseTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGroup(consultPanelLayout.createSequentialGroup()
                                                .addGap(26, 26, 26)
                                                .addComponent(commentsLabel)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(commScrollPane)))
                                .addContainerGap(8, Short.MAX_VALUE))
        );
        consultPanelLayout.setVerticalGroup(
                consultPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(consultPanelLayout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(consultPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(caseIDLabel)
                                        .addComponent(caseTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(consultPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(rsrcLabel)
                                        .addComponent(rsrcTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(consultPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(reasonLabel)
                                        .addComponent(reasonCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(consultPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(relevantLabel)
                                        .addComponent(assureYes)
                                        .addComponent(assureNo))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(consultPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(cbLabel)
                                        .addComponent(cbYes)
                                        .addComponent(cbNo))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(consultPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(emailLabel)
                                        .addComponent(emailNo)
                                        .addComponent(emailYes))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(consultPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(contactNameLabel)
                                        .addComponent(contactNameYes)
                                        .addComponent(contactNameNo))
                                .addGap(18, 18, 18)
                                .addGroup(consultPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(commentsLabel)
                                        .addComponent(commScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap())
        );

        clearButton.setText("Clear");
        clearButton.addActionListener(new clearListener());

        submitButton.setText("Submit");
        submitButton.addActionListener(new submitListener());

        emailButton.setText("Email");
        emailButton.addActionListener(new emailListener());

        quitButton.setText("Quit");
        quitButton.addActionListener(new quitListener());


        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(submitButton, javax.swing.GroupLayout.DEFAULT_SIZE, 78, Short.MAX_VALUE)
                                        .addComponent(emailButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(clearButton, javax.swing.GroupLayout.DEFAULT_SIZE, 76, Short.MAX_VALUE)
                                        .addComponent(quitButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(16, 16, 16))
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(consultPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addContainerGap())
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(consultPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(submitButton)
                                        .addComponent(clearButton))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(emailButton)
                                        .addComponent(quitButton))
                                .addGap(10, 10, 10))
        );

        pack();
    }

    class submitListener implements ActionListener
    {
        public void actionPerformed(ActionEvent a)
        {
            Connection c;
            sqlLiteConnect sql = new sqlLiteConnect();
            Statement stmt;
            String caseID = caseTextField.getText();
            String rsrc = rsrcTextField.getText();
            boolean Logging = cbYes.isSelected();
            boolean Assure = assureYes.isSelected();
            boolean Knowledge = emailYes.isSelected();
            boolean ScreenShare = emailYes.isSelected();
            String steps_completed = commTextArea.getText();
            String resolution = reasonCombo.getSelectedItem().toString();
            String uname = System.getProperty("user.name");

            if (caseID.isEmpty() || (rsrc.isEmpty()))
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
                c = sql.getConnection(System.getProperty("user.dir") + "/db/"
                         + uname + "_database");
                c.setAutoCommit(false);
                String sqlCreate = "CREATE TABLE IF NOT EXISTS behavior" +
                        "(" +
                        "    date DATETIME DEFAULT current_date," +
                        "    caseID VARCHAR(20)," +
                        "    rsrc VARCHAR(100)," +
                        "    resolution VARCHAR(75)," +
                        "    Assure BOOLEAN," +
                        "    Logging BOOLEAN," +
                        "    Knowledge BOOLEAN," +
                        "    ScreenShare BOOLEAN," +
                        "    time DATETIME DEFAULT current_time," +
                        "    steps_completed VARCHAR(500)" +
                        ");" +
                        "CREATE UNIQUE INDEX consult_pKey_uindex ON consult (time);";
                stmt = c.createStatement();
                stmt.execute(sqlCreate);

                PreparedStatement prep = c.prepareStatement("INSERT INTO behavior(caseID, rsrc, resolution, Assure, Logging   , " +
                        "Knowledge, ScreenShare, steps_completed) VALUES(?, ?, ?, ?, ?, ?, ?, ?)");
                prep.setString(1, caseID);
                prep.setString(2, rsrc);
                prep.setString(3, resolution);
                prep.setBoolean(4, Assure);
                prep.setBoolean(5, Logging);
                prep.setBoolean(6, Knowledge);
                prep.setBoolean(7, ScreenShare);
                prep.setString(8, steps_completed);

                prep.executeUpdate();
                prep.close();

                c.commit();
                c.close();
            } catch (Exception e)
            {
                System.err.println(e.getClass().getName() + ": " + e.getMessage());
                System.exit(0);
            }
            JOptionPane.showMessageDialog(null, "Success!");
            clear();
        }
    }

    class clearListener implements ActionListener
    {
        public void actionPerformed(ActionEvent a)
        {
            clear();
        }
    }

    class quitListener implements ActionListener
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

    class emailListener implements ActionListener
    {
        public void actionPerformed(ActionEvent a)
        {
            Desktop d = Desktop.getDesktop();
            try
            {
                d.open(new File(System.getProperty("user.home") + "/Library/Application Support/Behavior_Tracker/"));
            } catch (IOException e)
            {
                e.printStackTrace();
            }

            JOptionPane.showMessageDialog(null, "Share ~/Library/Application Support/Behavior_Tracker/Username_database\nfile with Mail from the Finder window that just opened.\n" +
                    "Email to: daniel_jenkins@apple.com");
        }
    }

    private void clear(){
        assureButtonGroup.clearSelection();
        cbButtonGroup.clearSelection();
        emailButtonGroup.clearSelection();
        contactNameButtonGroup.clearSelection();
        commTextArea.setText(null);
        caseTextField.setText(null);
        rsrcTextField.setText(null);
        reasonCombo.setSelectedIndex(0);
    }

    private javax.swing.ButtonGroup assureButtonGroup;
    private javax.swing.ButtonGroup cbButtonGroup;
    private javax.swing.ButtonGroup emailButtonGroup;
    private javax.swing.ButtonGroup contactNameButtonGroup;
    private javax.swing.JComboBox reasonCombo;
    private javax.swing.JRadioButton assureYes;
    private javax.swing.JRadioButton cbYes;
    private javax.swing.JRadioButton emailYes;
    private javax.swing.JTextArea commTextArea;
    private javax.swing.JTextField caseTextField;
    private javax.swing.JTextField rsrcTextField;
}
