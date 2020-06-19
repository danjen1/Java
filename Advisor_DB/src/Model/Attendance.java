package Model;

import Other.IdGenerator;
import Storage.Records;
import apple.laf.JRSUIConstants;

import java.io.IOException;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Attendance implements Serializable {

    private String name, type, comments, completed;
    private LocalDate date;
    private double hours;

    private int ID;


    public Attendance(int ID, String name, String date, String type, double hours, String comments, boolean completed) throws IOException {
        DateTimeFormatter mdy = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        setName(name);
        setDate(LocalDate.parse(date, mdy));
        setType(type);
        setHours(hours);
        setComments(comments);
        setCompleted(completed);
        Records.updateAttend(ID, this);
        System.out.println("Attendance Updated " + ID);
    }

    public Attendance(String name, String date, String type, double hours, String comments, boolean completed) throws IOException {
        DateTimeFormatter mdy = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        setName(name);
        setDate(LocalDate.parse(date, mdy));
        setType(type);
        setComments(comments);
        setName(name);
        setCompleted(completed);
        setHours(hours);
        Records.addAttend(name, this);
        System.out.println("Attendance Added (NEW)" + this.ID);

    }

    public Attendance() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Double getHours() {
        return hours;
    }

    public void setHours(Double hours) {
        this.hours = hours;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getCompleted() {

        return completed;
    }

    public void setCompleted(boolean status) {
        if (!status) {
            completed = "Pending";
        } else {
            completed = "Complete";
        }
    }

    public int getID() {
        return ID;
    }

    public void setID(int i) {
        this.ID = i;
    }
}



