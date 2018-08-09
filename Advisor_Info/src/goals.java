public class goals
{
    private String date;
    private String[] attribute = {"Assure", "Knowledge", "Guidance", "Professionalism", "Holds",
                                "Case Duration", "Logging", "Tools", "Appeasements & Refunds",
                                "Consultations", "Ownership", "Compliance"};
    private String root_cause;
    private String goal;
    private String due_date;
    private int num_reviewed;
    private float success_rate;
    private String comments;
    private Boolean completed;
    private String[] quarter = {"FY18Q4", "FY19Q1", "FY19Q2", "FY19Q3"};
    private String[] cat = {"Teamowrk", "Innovation", "Results"};


    public String getDate()
    {
        return date;
    }

    public void setDate(String date)
    {
        this.date = date;
    }

    public String[] getAttribute()
    {
        return attribute;
    }

    public void setAttribute(String[] attribute)
    {
        this.attribute = attribute;
    }

    public String getRoot_cause()
    {
        return root_cause;
    }

    public void setRoot_cause(String root_cause)
    {
        this.root_cause = root_cause;
    }

    public String getGoal()
    {
        return goal;
    }

    public void setGoal(String goal)
    {
        this.goal = goal;
    }

    public String getDue_date()
    {
        return due_date;
    }

    public void setDue_date(String due_date)
    {
        this.due_date = due_date;
    }

    public int getNum_reviewed()
    {
        return num_reviewed;
    }

    public void setNum_reviewed(int num_reviewed)
    {
        this.num_reviewed = num_reviewed;
    }

    public float getSuccess_rate()
    {
        return success_rate;
    }

    public void setSuccess_rate(float success_rate)
    {
        this.success_rate = success_rate;
    }

    public String getComments()
    {
        return comments;
    }

    public void setComments(String comments)
    {
        this.comments = comments;
    }

    public Boolean getCompleted()
    {
        return completed;
    }

    public void setCompleted(Boolean completed)
    {
        this.completed = completed;
    }

    public String[] getQuarter()
    {
        return quarter;
    }

    public void setQuarter(String[] quarter)
    {
        this.quarter = quarter;
    }

    public String[] getCat()
    {
        return cat;
    }

    public void setCat(String[] cat)
    {
        this.cat = cat;
    }



}
