import javax.swing.*;
import java.io.File;

public class FileChooser
{
    public FileChooser()
    {

        JFileChooser fileopen = new JFileChooser();
        int ret = fileopen.showDialog(null, "Open file");
        System.out.println("here");
        if (ret == JFileChooser.APPROVE_OPTION)
        {
            File file = fileopen.getSelectedFile();
            System.out.println(file);
        }
    }
}
