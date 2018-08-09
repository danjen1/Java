import java.util.*;

class advisor
{
    private String name;
    private String surname;
    private String email;
    private boolean diff;
    private String schedule;
    private String mobile;
    private String t_zone;
    private String DSID;
    private String EID;
    private String address1;
    private String address2;
    private String status;
    private String city;
    private String state;
    private String zip;
    private String hire_date;
    private ArrayList<events> events = new ArrayList<>();
    private ArrayList<coaching> coaching = new ArrayList<>();
    private ArrayList<goals> goals = new ArrayList<>();


    public advisor(String name, String surname, String email, Boolean diff, String mobile, String t_zone, String DSID, String EID,
                   String address1, String address2, String city, String state, String zip, String hire_date) {
        setName(name);
        setSurname(surname);
        setEmail(email);
        setDiff(diff);
        setMobile(mobile);
        setT_zone(t_zone);
        setDSID(DSID);
        setEID(EID);
        setAddress1(address1);
        setAddress2(address2);
        setCity(city);
        setState(state);
        setZip(zip);
        setHire_date(hire_date);
    }




    public String getName() {

        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    private void setSurname(String surname) {
        this.surname = surname;
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

    private void setDiff(boolean diff) {
        this.diff = diff;
    }

    public String getSchedule() {
        return schedule;
    }

    public void setSchedule(String schedule) {
        this.schedule = schedule;
    }

    public String getMobile() {
        return mobile;
    }

    private void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getT_zone() {
        return t_zone;
    }

    private void setT_zone(String t_zone) {
        this.t_zone = t_zone;
    }

    public String getDSID() {
        return DSID;
    }

    private void setDSID(String DSID) {
        this.DSID = DSID;
    }

    public String getEID() {
        return EID;
    }

    private void setEID(String EID) {
        this.EID = EID;
    }

    public String getAddress1() {
        return address1;
    }

    private void setAddress1(String address1) {
        this.address1 = address1;
    }

    public String getAddress2() {
        return address2;
    }

    private void setAddress2(String address2) {
        this.address2 = address2;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCity() {
        return city;
    }

    private void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    private void setState(String state) {
        this.state = state;
    }

    public String getZip() {
        return zip;
    }

    private void setZip(String zip) {
        this.zip = zip;
    }

    public String getHire_date() {
        return hire_date;
    }

    private void setHire_date(String hire_date) {
        this.hire_date = hire_date;
    }

    public ArrayList<events> getEvents() {
        return events;
    }

    public void setEvents(ArrayList<events> events) {
        this.events = events;
    }

    public ArrayList<coaching> getCoaching() {
        return coaching;
    }

    public void setCoaching(ArrayList<coaching> coaching) {
        this.coaching = coaching;
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

