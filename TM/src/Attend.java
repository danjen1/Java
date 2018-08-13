import java.util.ArrayList;

public class Attend
{

    private String advisor;
    private String date;
    private String type;
    private String comments;
    private double hours;
    private Boolean submitted;

    /*
    Constructors
     */
    public Attend()
    {

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
