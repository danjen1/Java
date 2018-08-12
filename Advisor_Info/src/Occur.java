public class Occur
{
    private String date, cat, hours, comments;
    private Boolean submitted;

    public Occur(String date, String cat, String hours, Boolean submitted, String comments)
    {
        setDate(date);
        setCat(cat);
        setHours(hours);
        setComments(comments);
        setSubmitted(submitted);
    }


    /**********************
     * Getters and Setters*
     **********************/
    public String getDate()
    {
        return date;
    }

    public void setDate(String date)
    {
        this.date = date;
    }

    public String getCat()
    {
        return cat;
    }

    public void setCat(String cat)
    {
        this.cat = cat;
    }

    public String getHours()
    {
        return hours;
    }

    public void setHours(String hours)
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
}
