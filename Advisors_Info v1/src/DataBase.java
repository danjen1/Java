import java.beans.XMLEncoder;
import java.io.*;
import java.util.ArrayList;

public class DataBase
{


    ArrayList<Advisor> advDB = new ArrayList<>();

    XMLEncoder e = new XMLEncoder(new BufferedOutputStream(new FileOutputStream("Test.xml")));
       e.
               e.close();

    public DataBase() throws FileNotFoundException
    {
    }




        /*******************
         Getters and Setters
         *******************/
    public ArrayList<Advisor> getAdvDB()
    {
        return advDB;
    }

    public void setAdvDB(ArrayList<Advisor> advDB)
    {
        this.advDB = advDB;
    }
}


