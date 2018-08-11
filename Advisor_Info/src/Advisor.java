import java.io.Serializable;
import java.util.*;

class Advisor implements Serializable
{
    private String name, surname, email, sched, mobile, t_zone, DSID, EID, address1, address2, status, city, state, zip, hire_date;
    private Boolean diff;
    private ArrayList<Events> events = new ArrayList<>();
    private ArrayList<Coaching> coaching = new ArrayList<>();
    private ArrayList<Goals> goals = new ArrayList<>();

    //Constructors
    public Advisor()
    {

    }
    //Constructor with all args
    public Advisor(String name, String surname, String email, Boolean diff, String mobile, String status, String sched, String t_zone, String DSID, String EID,
                        String address1, String address2,  String city, String state, String zip, String hire_date)
    {
        setName(name); setSurname(surname); setEmail(email); setSched(sched); setDiff(diff); setMobile(mobile); setT_zone(t_zone); setDSID(DSID);
        setEID(EID); setAddress1(address1); setAddress2(address2); setStatus(status); setCity(city); setState(state); setZip(zip);
        setHire_date(hire_date);
        events = null; coaching = null; goals = null;
    }


    //PRINT METHODS
    public void printAdvAll()
    {
        System.out.print("Emp ID: " + getEID() + "\nName: " + getName() + " " + getSurname() + "\nEmail: " +
                getEmail() + "\nMobile: " + getMobile() + "\nDiff: " + isDiff() + "\nDSID: " + getDSID() + "\nSched: " + getSched() + "\nTime Zone: " + getT_zone() + "\nHire Date: " + getHire_date() +
                "\nAdress: " + getAddress1() + " " + getAddress2() + "\n\t\t" + getCity() + ", " + getState() + " " + " " + getZip() + "\n");
        for (Events items : this.events )
        {
            System.out.println("Attendance Eents:" + "\nDate: " + items.getDate() + "\tType: " + items.getType() + "\tHours: " + items.getHours() + "\tSubmitted: " + items.getSubmitted() +
                    "\nComments: " + items.getComments());
        }
    }

    public void printAdvInfo()
    {
        System.out.print("Emp ID: " + getEID() + "\nName: " + getName() + " " + getSurname() + "\nEmail: " +
                getEmail() + "\nMobile: " + getMobile() + "\nDiff: " + isDiff() + "\nDSID: " + getDSID() + "\nSched: " + getSched() + "\nTime Zone: " + getT_zone() + "\nHire Date: " + getHire_date() +
                "\nAdress: " + getAddress1() + " " + getAddress2() + "\n\t\t" + getCity() + ", " + getState() + " " + " " + getZip() + "\n" + "\n");
    }

    /* Getters and Setters */
    public String getName() {

        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setSched(String sched)
    {
        this.sched = sched;
    }

    public String getSched()
    {
        return sched;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isDiff() {
        return diff;
    }

    public void setDiff(boolean diff) {
        this.diff = diff;
    }

    public String getMobile()
    {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getT_zone() {
        return t_zone;
    }

    public void setT_zone(String t_zone) {
        this.t_zone = t_zone;
    }

    public String getDSID() {
        return DSID;
    }

    public void setDSID(String DSID) {
        this.DSID = DSID;
    }

    public String getEID() {
        return EID;
    }

    public void setEID(String EID) {
        this.EID = EID;
    }

    public String getAddress1() {
        return address1;
    }

    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    public String getAddress2() {
        return address2;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    public String getStatus() {
        return status;
    }

    public Boolean getDiff()
    {
        return diff;
    }

    public void setDiff(Boolean diff)
    {
        this.diff = diff;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getHire_date() {
        return hire_date;
    }

    public void setHire_date(String hire_date) {
        this.hire_date = hire_date;
    }

    public ArrayList<Events> getEvents() {
        return events;
    }


    public void setEvents(ArrayList<Events> events)
    {
        this.events = events;
    }

    public ArrayList<Coaching> getCoaching() {
        return coaching;
    }

    public void setCoaching(ArrayList<Coaching> coaching) {
        this.coaching = coaching;
    }
    public void addCoaching(Coaching coaching) {
        this.coaching.add(coaching);
    }

    public ArrayList<Goals> getGoals()
    {
        return goals;
    }

    public void setGoals(ArrayList<Goals> goals)
    {
        this.goals = goals;
    }

    public void addGoals(Goals goals) {
        this.goals.add(goals);
    }



   /* public void print()
    {
        //grades = getGrades();
        System.out.print("ID: " + getID() + "\tFirst Name: " + getFirstName() + "\tLast Name: " +
                getLastName() + "\temail: " + getEmail() + "\tAge: " + getAge());
        System.out.print("\tGrades: {");
        //System.out.println(grades[0] + ", " + grades[1] + ", " + grades[2] + ", " + grades[3] + ", " + grades[4] + "}");
    }
    */
}

