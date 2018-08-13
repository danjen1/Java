import java.util.ArrayList;
import java.util.Scanner;

public class Attend
{

    private String advisor;
    private String date;
    private String type;
    private String comments;
    private double hours;
    private Boolean submitted = false;

    /*
    Constructors
     */
    public Attend()
    {
        Scanner in = new Scanner(System.in);
        Boolean go = true;
        while (go)
        {
            System.out.println("Advisor: ");
            advisor = in.nextLine();
            System.out.println("Date: ");
            date = in.nextLine();
            System.out.println("Type: ");
            type = in.nextLine();
            System.out.println("Hours: ");
            hours = in.nextDouble();
            System.out.println("Comments: ");
            comments = in.nextLine();
            System.out.println("Submitted?: (Y/N)");
            if (in.nextLine().equals("Y") || in.nextLine().equals("Yes") || in.nextLine().equals("yes"))
            {
                submitted = true;
            }
            go = false;
        }
        setAdvisor(advisor);
        setDate(date);
        setType(type);
        setHours(hours);
        setSubmitted(submitted);
    }

    public Attend(String advisor, String date, String type, double hours, String comments, Boolean submitted)
    {
        setAdvisor(advisor);
        setDate(date);
        setType(type);
        setHours(hours);
        setComments(comments);
        setSubmitted(submitted);

    }

    /*****************
     **Print Methods**
     *****************/

    public void print()
    {
        System.out.print("Date: " + getDate() + "\tCategory: " +
                getType() + "\tHours: " + getHours() + "\tSubmitted: "
                + getSubmitted() + "\tComments: " + getComments() + "\n");
        System.out.println();
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

    public double getHours()
    {
        return hours;
    }

    public void setHours(double hours)
    {
        this.hours = hours;
    }

    public String getComments()
    {
        return comments;
    }

    public void setComments(String comments)
    {
        this.comments = comments;
    }

    public Boolean getSubmitted()
    {
        return submitted;
    }

    public void setSubmitted(Boolean submitted)
    {
        this.submitted = submitted;
    }

    public String getAdvisor()
    {
        return advisor;
    }

    public void setAdvisor(String advisor)
    {
        this.advisor = advisor;
    }

}
