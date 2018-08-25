import java.io.IOException;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Goal implements Serializable
{
    private String name;
    private String goal;
    private String comments;
    private ArrayList<String> update = new ArrayList<>();
    private String due;
    private String type;
    private String cat;
    private int rvwd;
    private String[] types = {"On-Call", "QDR/APR", "Contribution"};
    String[] cats = {"Teamwork", "Innovation", "Resulst", "Assure", "Knowledge", "Guidance", "Professionalism",
    "Holds", "Case Duration", "Logging", "Tools", "Appeasements", "Consultations", "Ownership", "Compliance"};
    private double success;
    private Boolean completed;
    private LocalDate date;




    //default constructor for QDR / APR GOal
    public Goal(String name, String date, String type, String cat, String due, String goal, Boolean completed, String update) throws IOException
    {
        DateTimeFormatter mdy = DateTimeFormatter.ofPattern("M/dd/yy");
        setName(name);
        setDate(LocalDate.parse(date, mdy));
        setDue(due);
        setGoal(goal);
        setType(type);
        setCat(cat);
        setCompleted(completed);
        setUpdate(update);
        DB.add(name, this);
    }

    public void print()
    {
        DateTimeFormatter mdy = DateTimeFormatter.ofPattern("M/dd/yy");
        String rowData = String.format(". %-11s%-10s%-10s%-10s%-95s%-7s", getDate().format(mdy), getType(), getCat(), getDue(), getGoal(), getCompleted());
        System.out.println(rowData);
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

    public void setUpdate(String update)
    {
        int i = this.update.size();
        this.update.add(i, update);
    }

    public ArrayList<String> getUpdate()
    {
        return update;
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


    public String getType()
    {
        return type;
    }

    public void setType(String type)
    {
        this.type = type;
    }


    public String getGoal()
    {

        return goal;
    }

    public void setGoal(String goal)
    {
        this.goal = goal;
    }

    public String getCat()
    {
        return cat;
    }

    public void setCat(String cat)
    {
        this.cat = cat;
    }




}
