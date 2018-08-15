import java.io.IOException;

public class Coaching
{
    private String name;


    private String date, type, comments;

    public Coaching(String name, String date, String comments) throws IOException
    {
        setName(name);
        setDate(date);
        setType(type);
        setComments(comments);
        DB.add(name, this);
    }

    public void print()
    {
        System.out.println("Date: " + getDate() + "\tComments: " + getComments());

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

    public String getType()
    {
        return type;
    }

    public void setType(String type)
    {
        this.type = type;
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
