import java.io.IOException;
import java.io.Serializable;

public class Goal implements Serializable
{
    private String name, date, comments;


    public Goal(String name, String date, String comments) throws IOException
    {
        setName(name);
        setDate(date);
        setComments(comments);
        DB.add(name, this);
    }

    public void print()
    {
        System.out.println("Date: " + getDate() + "\tGoal Comments: " + getComments());
    }


    /*
    Getters and Setters
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

    public String getComments()
    {
        return comments;
    }

    public void setComments(String comments)
    {
        this.comments = comments;
    }
}
