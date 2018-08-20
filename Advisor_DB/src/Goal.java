import java.io.IOException;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Goal implements Serializable
{
    private String name, comments, update;


    private int rvwd;
    private String[] type = {"On-Call", "QDR/APR"};
    private double success;
    private Boolean completed;
    private LocalDate date;
    private String  due;

    public Goal(String date, String type, String name, String due, String comments) throws IOException
    {
        DateTimeFormatter mdy = DateTimeFormatter.ofPattern("M/dd/yy");
        setName(name);
        setDate(LocalDate.parse(date, mdy));
        setDue(due);
        setType(type);
        setComments(comments);

        DB.add(name, this);
    }

    public void print()
    {
        DateTimeFormatter mdy = DateTimeFormatter.ofPattern("M/dd/yy");
        System.out.println("Date: " + getDate().format(mdy) + "\tGoal Comments: " + getComments());
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

    public String getComments()
    {
        return comments;
    }

    public void setComments(String comments)
    {
        this.comments = comments;
    }

    public String getUpdate()
    {
        return update;
    }

    public void setUpdate(String update)
    {
        this.update = update;
    }

    public int getRvwd()
    {
        return rvwd;
    }

    public void setRvwd(int rvwd)
    {
        this.rvwd = rvwd;
    }

    public double getSuccess()
    {
        return success;
    }

    public void setSuccess(double success)
    {
        this.success = success;
    }

    public Boolean getCompleted()
    {
        return completed;
    }

    public void setCompleted(Boolean completed)
    {
        this.completed = completed;
    }

    public LocalDate getDate()
    {
        return date;
    }

    public void setDate(LocalDate date)
    {
        this.date = date;
    }

    public String getDue()
    {
        return due;
    }

    public void setDue(String due)
    {
        this.due = due;
    }


}
