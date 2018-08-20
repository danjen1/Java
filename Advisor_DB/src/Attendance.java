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
        setHours(hours);
        setComments(comments);
        DB.add(name, this);
    }


    /*public double[][] getAttendTotals()
    {
        DateTimeFormatter mdy = DateTimeFormatter.ofPattern("M/dd/yy");
        LocalDate today = LocalDate.now();
        LocalDate thirty = today.minusDays(30);
        LocalDate sixty = today.minusDays(60);
        LocalDate ninety = today.minusDays(90);
        LocalDate oneEighty = today.minusDays(180);
        double sum30 = 0;
        double sum60 = 0;
        double sum90 = 0;
        double sum180 = 0;
        double sumTotal = 0;
        double[][] totals = new double[9][5];
        for (Attendance item : getAttendance())
        {
            if (item.getType().equals("Full Day"))
            {
                if (item.getDate().isBefore(today) && item.getDate().isAfter(thirty))
                {
                    sum30 += item.getHours();
                }
                if (item.getDate().isBefore(thirty) && item.getDate().isAfter(sixty))
                {
                    sum60 += item.getHours();

                }
                if (item.getDate().isAfter(ninety) && item.getDate().isBefore(sixty))
                {
                    sum90 += item.getHours();

                }
                if (item.getDate().isAfter(oneEighty) && item.getDate().isBefore(ninety))
                {
                    sum180 += item.getHours();
                }
                sumTotal += item.getHours();
                totals[0][0] = sum30;
                totals[0][1] = sum60;
                totals[0][2] = sum90;
                totals[0][3] = sum180;
                totals[0][4] = sumTotal;
            }
        }
        return totals;
    }

*/


    public void printSumm(double[][] totals)
    {

    }
    public void print()
    {
        DateTimeFormatter mdy = DateTimeFormatter.ofPattern("M/dd/yy");
        String rowData = String.format(".\t%-12s%-15s%-7s%-17s", getDate().format(mdy), getType(), getHours(), getComments());
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

