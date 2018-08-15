public class Coaching
{
    private String name;


    private String date;
    private String type;
    private String comments;

    public Coaching(String name, String date, String type)
    {
        setName(name);
        setDate(date);
        setType(type);
    }

    public void print()
    {
        System.out.println("Date: " + getDate() + "\tComments: " + getComments());
        System.out.println();
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
