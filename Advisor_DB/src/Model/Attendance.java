package Model;

import Storage.Records;

import java.io.IOException;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Attendance implements Serializable {

    private String name, type, comments;
    private LocalDate date;
    private double hours;
    boolean completed;


    public Attendance(String name, String date, String type, double hours, String comments, boolean completed) throws IOException {
        DateTimeFormatter mdy = DateTimeFormatter.ofPattern("M/dd/yy");
        setName(name);
        setDate(LocalDate.parse(date, mdy));
        setType(type);
        setHours(hours);
        setComments(comments);
        setCompleted(completed);
        Records.addAttendance(name, this);
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

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }
}



