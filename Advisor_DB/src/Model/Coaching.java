package Model;

import Storage.Records;

import java.io.IOException;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Coaching implements Serializable {

    private String name, type, comments;
    private LocalDate date;
    private double hours;
    private boolean completed;


    public Coaching(String name, String date, String type, String comments, boolean completed, double hours) throws IOException {
        DateTimeFormatter mdy = DateTimeFormatter.ofPattern("M/dd/yy");
        setName(name);
        setDate(LocalDate.parse(date, mdy));
        setType(type);
        setComments(comments);
        setCompleted(completed);
        setHours(hours);
        Records.addCoaching(name, this);
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

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public boolean getCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public double getHours() {
        return hours;
    }

    public void setHours(double hours) {
        this.hours = hours;
    }

}
