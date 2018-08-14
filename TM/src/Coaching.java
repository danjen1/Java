public class Coaching
{
    private String name;
    private String date;

    public Coaching()
    {
        setName("Daniel");
        setDate("8/18");
        System.out.println("Coaching Class Constructor");
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
