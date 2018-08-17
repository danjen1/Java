import java.io.IOException;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Attendance implements Serializable
{

    private String name;


    private String type;
    private String comments;
    private double hours;
    private LocalDate date;


    public Attendance(String name, String date, String type, double hours, String comments) throws IOException
    {
        DateTimeFormatter mdy = DateTimeFormatter.ofPattern("M/dd/yy");
        setName(name);
        setDate(LocalDate.parse(date, mdy));
        setType(type);
        setComments(comments);
        DB.add(name, this);
    }


    public void print(double[] totals)
    {
        System.out.println("Attendance Totals");
        String header ="Full Day \tEarly Out / Late in \t Vacation \t Home DT \t AppleDT \t iLOA \t LOA \t KinCare";
        System.out.println("***********************************************************************************************");
        System.out.println(header);
        System.out.println("***********************************************************************************************");
        System.out.println(totals[0] + "\t" + totals[1]);

        System.out.println("**********************************************************");

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

    public LocalDate getDate()
    {
        return date;
    }

    public void setDate(LocalDate date)
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
    public double getHours()
    {
        return hours;
    }

    public void setHours(double hours)
    {
        this.hours = hours;
    }

    public String getType()
    {
        return type;
    }

    public void setType(String type)
    {
        this.type = type;
    }

}

