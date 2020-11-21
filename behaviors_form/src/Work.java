import javax.swing.*;
import javax.swing.text.DefaultEditorKit;
import java.awt.event.KeyEvent;
import java.io.File;

class Work
{
    public static void main(String args[])
    {

        String FileFolder = System.getenv("APPDATA") + "\\" + "Launcher";
        System.out.println("Searching for database file");
        String os = System.getProperty("os.name").toUpperCase();

        if (os.contains("WIN")) {
            FileFolder = System.getenv("APPDATA") + "\\" + "Launcher";
            System.out.println("Found windows");
        }
                if (os.contains("NUX")) {
            FileFolder = System.getProperty("user.dir") + "/db/" ;
            System.out.println("Found linux");
        }

        if (os.contains("MAC")) {
            FileFolder = System.getProperty("user.home") + "/Library/Application " + "Support/"
                    + "Behavior_Tracker";
            System.out.println("Found mac");
        }


        System.out.println("Searching for database folder");
        File directory = new File(FileFolder);

        if (directory.exists()) {
            System.out.println("Found folder");
        }

        if (!directory.exists()) {
            directory.mkdir();
            System.out.println("Could not find database folder so created it");
        }

        try {

            javax.swing.UIManager.LookAndFeelInfo[] installedLookAndFeels=javax.swing.UIManager.getInstalledLookAndFeels();
            for (UIManager.LookAndFeelInfo installedLookAndFeel : installedLookAndFeels)
                if ("GTK+".equals(installedLookAndFeel.getName()))
                {
                    UIManager.setLookAndFeel(installedLookAndFeel.getClassName());
                    break;
                }
        } catch (ClassNotFoundException | UnsupportedLookAndFeelException | IllegalAccessException | InstantiationException ex) {
            java.util.logging.Logger.getLogger(Form.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        InputMap im = (InputMap) UIManager.get("TextField.focusInputMap");
        im.put(KeyStroke.getKeyStroke(KeyEvent.VK_C, KeyEvent.META_DOWN_MASK), DefaultEditorKit.copyAction);
        im.put(KeyStroke.getKeyStroke(KeyEvent.VK_V, KeyEvent.META_DOWN_MASK), DefaultEditorKit.pasteAction);
        im.put(KeyStroke.getKeyStroke(KeyEvent.VK_X, KeyEvent.META_DOWN_MASK), DefaultEditorKit.cutAction);
        java.awt.EventQueue.invokeLater(() -> new Form().setVisible(true));
    }
}
