import java.io.IOException;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Coaching implements Serializable
{

    private String name;
    private String type;
    private String comments;
    private String qrtr;
    private String due;
    private String cat;
    private LocalDate date;


    public Coaching(String name, String date, String type, String comments) throws IOException
    {
        DateTimeFormatter mdy = DateTimeFormatter.ofPattern("M/dd/yy");
        setName(name);
        setDate(LocalDate.parse(date, mdy));
        setType(type);
        setQrtr(qrtr);
        setDue(due);
        setComments(comments);
        DB.add(name, this);
    }

    public void print()
    {

        DateTimeFormatter mdy = DateTimeFormatter.ofPattern("M/dd/yy");
        String rowData = String.format(".\t%-12s%-26s%-40s", getDate().format(mdy), getType(), getComments());
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

    public LocalDate getDate()
    {
        return date;
    }

    public void setDate(LocalDate date)
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

    public String getQrtr()
    {
        return qrtr;
    }

    public void setQrtr(String qrtr)
    {
        this.qrtr = qrtr;
    }

    public String getDue()
    {
        return due;
    }

    public void setDue(String due)
    {
        this.due = due;
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
