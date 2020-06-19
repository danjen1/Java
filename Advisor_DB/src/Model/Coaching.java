package Model;

import Other.IdGenerator;
import Storage.Records;

import java.io.IOException;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Coaching implements Serializable {

    private String name, type, comments;
    private LocalDate date;
    private  int ID;


    public Coaching(int ID, String Name, String date, String type, String comments) throws IOException {
        DateTimeFormatter mdy = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        setName(Name);
        setDate(LocalDate.parse(date, mdy));
        setType(type);
        setComments(comments);
        setName(Name);
        Records.updateCoaching(ID, this);
    }

    public Coaching(String name, String date, String type, String comments) throws IOException {
        DateTimeFormatter mdy = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        setName(name);
        setDate(LocalDate.parse(date, mdy));
        setType(type);
        setName(name);
        setComments(comments);
        Records.addCoaching(name, this);
        System.out.println(ID);


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

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public int getID() {
        return ID;
    }

    public void setID(int i) {
        this.ID = i;
    }

}