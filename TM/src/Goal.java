public class Goal
{
    private String name;
    private String date;
    public Goal()
    {

        System.out.println("Goal Class Constructor");
        setDate("8/18");
        setName("Daniel");
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
