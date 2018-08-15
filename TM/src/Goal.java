import java.io.IOException;
import java.io.Serializable;

public class Goal implements Serializable
{
    private String name;
    private String date;
    public Goal(String name, String date) throws IOException
    {

        setDate(name);
        setName(date);
        DB.add(name, this);

    }






    /*
    Getters & Setters
     */
    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getDate()
    {
        return date;
    }

    public void setDate(String date)
    {
        this.date = date;
    }
}
