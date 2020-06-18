package Model;

import Other.IdGenerator;
import Storage.Records;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.IOException;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Advisor implements Serializable {

    private String DOH, name, EID, email, DSID, status, shift_type, shift, phone, t_zone, BDay, address, RTW, medDue, comments, contactType;

    private int ID;


    private ObservableList<Coaching> coach = FXCollections.observableArrayList();

    private String[] types = {"Approved", "VTO", "Apple DownTime", "Home DownTime", "Inclement Weather", "Full Day Sick", "Mid Day Sick",
            "Early or Late Out", "Personal", "No Call No Show", "Pending Protected Time", "Tardy or Left Early", "Late From Lunch",
            "KinCare", "Regional Sick", "Bereavement", "Parental Time", "Jury Duty", "LOA", "iLOA", "Job Accommodation", "Total"};

    private LocalDate today = LocalDate.now();
    private LocalDate thirty = today.minusDays(30);
    private LocalDate sixty = today.minusDays(60);
    private LocalDate ninety = today.minusDays(90);
    private LocalDate oneEighty = today.minusDays(180);


    public Advisor(int ID, String name, String EID, String DSID, String email, String status, String shift_type,
                   String shift,  String phone, String t_zone, String DOH, String bDay,
                   String address) throws IOException {
        ObservableList<Attendance> attend = FXCollections.observableArrayList();
        ObservableList<Coaching> coach = FXCollections.observableArrayList();
        DateTimeFormatter mdy = DateTimeFormatter.ofPattern("M/dd/yyyy");

        this.ID = ID;
        setName(name);
        setEID(EID);
        setDSID(DSID);
        setEmail(email);
        setStatus(status);
        setShift_type(shift_type);
        setShift(shift);
        setPhone(phone);
        setT_zone(t_zone);
        setDOH(DOH);
        setBDay(bDay);
        setAddress(address);
        setCoach(coach);
        setAttendance(attend);
        System.out.println("Adding " + name + " to the database.");
        Records.updateAdvisor(this.getID(), this);
        System.out.println("Advisor Added 1st Constructor" + " " + this.getID());
    }

    public Advisor(String name, String EID, String DSID, String email, String status, String shift_type,
                   String shift,  String phone, String t_zone, String DOH, String bDay,
                   String address) throws IOException {
        ObservableList<Attendance> attend = FXCollections.observableArrayList();
        ObservableList<Coaching> coach = FXCollections.observableArrayList();
        DateTimeFormatter mdy = DateTimeFormatter.ofPattern("M/dd/yyyy");

        setID(ID);
        setName(name);
        setEID(EID);
        setDSID(DSID);
        setEmail(email);
        setStatus(status);
        setShift_type(shift_type);
        setShift(shift);
        setPhone(phone);
        setT_zone(t_zone);
        setDOH(DOH);
        setBDay(bDay);
        setAddress(address);
        setCoach(coach);
        setAttendance(attend);
        System.out.println("Adding " + name + " to the database.");
        Records.addAdvisor(getID(), this);
        System.out.println("Advisor Added 2nd Constructor" + " " + this.getID());
    }

    public double[][] getAttendTotals() {

        double[][] totals = new double[23][5];
        for (Attendance item : getAttendance()) {
            double sum30 = 0, sum60 = 0, sum90 = 0, sum180 = 0, sumTotal = 0;
            for (int i = 0; i < 22; i++) {
                if (item.getType().equals(types[i])) {
                    System.out.println("found: " + types[i]);

                    if (item.getDate().isAfter(thirty) && item.getDate().isBefore(today.plusDays(1))) {

                        sum30 += item.getHours();
                    }
                    if (item.getDate().isBefore(thirty) && item.getDate().isAfter(sixty)) {
                        sum60 += item.getHours();
                    }
                    if (item.getDate().isAfter(ninety) && item.getDate().isBefore(sixty)) {
                        sum90 += item.getHours();
                    }
                    if (item.getDate().isAfter(oneEighty) && item.getDate().isBefore(ninety)) {
                        sum180 += item.getHours();
                    }
                    sumTotal = sum30 + sum60 + sum90 + sum180;
                    totals[i][0] += sum30;
                    totals[i][1] += sum60;
                    totals[i][2] += sum90;
                    totals[i][3] += sum180;
                    totals[i][4] += sumTotal;
                }
            }
            for (int i = 0; i < 4; i++) {
                sum30 += totals[i][0];
                sum60 += totals[i][1];
                sum90 += totals[i][2];
                sum180 += totals[i][3];
                sumTotal += totals[i][4];
            }
            totals[5][0] = sum30;
            totals[5][1] = sum60;
            totals[5][2] = sum90;
            totals[5][3] = sum180;
            totals[5][4] = sumTotal;
        }

        return totals;
    }
    private ObservableList<Attendance> attendance = FXCollections.observableArrayList();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getID() {
        return ID;
    }

    public int setID(int id) {
        new IdGenerator(this);
        return this.ID = IdGenerator.getAdvisorID();
    }

    public String getEID() {
        return EID;
    }

    public void setEID(String EID) {
        this.EID = EID;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDSID() {
        return DSID;
    }

    public void setDSID(String DSID) {
        this.DSID = DSID;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getShift_type() {
        return shift_type;
    }

    public void setShift_type(String shift_type) {
        this.shift_type = shift_type;
    }

    public String getShift() {
        return shift;
    }

    public void setShift(String shift) {
        this.shift = shift;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getT_zone() {
        return t_zone;
    }

    public void setT_zone(String t_zone) {
        this.t_zone = t_zone;
    }

    public String getBDay() {
        return BDay;
    }

    public void setBDay(String BDay) {
        this.BDay = BDay;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getRTW() {
        return RTW;
    }

    public void setRTW(String RTW) {
        this.RTW = RTW;
    }

    public String getMedDue() {
        return medDue;
    }

    public void setMedDue(String medDue) {
        this.medDue = medDue;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public String getContactType() {
        return contactType;
    }

    public void setContactType(String contactType) {
        this.contactType = contactType;
    }

    public String getDOH() {
        return DOH;
    }

    public void setDOH(String DOH) {
        this.DOH = DOH;
    }

    public ObservableList<Attendance> getAttendance() {
        return attendance;
    }

    public void setAttendance(ObservableList<Attendance> attendance) {
        this.attendance = attendance;
    }

    public ObservableList<Coaching> getCoach() {
        return coach;
    }

    public void setCoach(ObservableList<Coaching> coach) {
        this.coach = coach;
    }

}
