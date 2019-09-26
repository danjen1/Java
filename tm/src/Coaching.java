import java.io.IOException;
import java.io.Serializable;

public class Coaching implements Serializable
{
    private String name;
    private String date;

    public Coaching(String name, String date) throws IOException
    {
        setName(name);
        setDate(date);
        DB.add(name, this);

    }




    /*
    Gettters and Setters
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
