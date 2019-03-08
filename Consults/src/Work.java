import javax.swing.*;
import javax.swing.text.DefaultEditorKit;
import java.awt.event.KeyEvent;
import java.io.File;

public class Work
{
    public static void main(String args[])
    {
        String FileFolder = System.getenv("APPDATA") + "\\" + "Launcher";
        System.out.println("Searching for database file");
        String os = System.getProperty("os.name").toUpperCase();
        /*
        if (os.contains("WIN")) {
            FileFolder = System.getenv("APPDATA") + "\\" + "Launcher";
            System.out.println("Found windows");
        }
                if (os.contains("NUX")) {
            FileFolder = System.getProperty("user.dir") + ".Launcher";
            System.out.println("Found linux");
        }
        */
        if (os.contains("MAC")) {
            FileFolder = System.getProperty("user.home") + "/Library/Application " + "Support/"
                    + "Consults";
            System.out.println("Found mac");
        }


        System.out.println("Searching for database folder");
        File directory = new File(FileFolder);

        if (directory.exists()) {
            System.out.println("Found folder");
        }

        if (directory.exists() == false) {
            directory.mkdir();
            System.out.println("Could not find database folder so created it");
        }

       try {

            javax.swing.UIManager.LookAndFeelInfo[] installedLookAndFeels=javax.swing.UIManager.getInstalledLookAndFeels();
            for (int idx=0; idx<installedLookAndFeels.length; idx++)
                if ("GTK+".equals(installedLookAndFeels[idx].getName())) {
                    javax.swing.UIManager.setLookAndFeel(installedLookAndFeels[idx].getClassName());
                    break;
                }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Form.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Form.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Form.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Form.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        InputMap im = (InputMap) UIManager.get("TextField.focusInputMap");
        im.put(KeyStroke.getKeyStroke(KeyEvent.VK_C, KeyEvent.META_DOWN_MASK), DefaultEditorKit.copyAction);
        im.put(KeyStroke.getKeyStroke(KeyEvent.VK_V, KeyEvent.META_DOWN_MASK), DefaultEditorKit.pasteAction);
        im.put(KeyStroke.getKeyStroke(KeyEvent.VK_X, KeyEvent.META_DOWN_MASK), DefaultEditorKit.cutAction);
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Form().setVisible(true);
            }
        });
    }
}
