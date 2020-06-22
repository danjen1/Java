package Model;

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
        this.ID = ID;
        System.out.println("Update Coaching Method ID: " + ID);
        Records.updateCoaching(ID, this);
        System.out.println("Update Coaching Method Ran ID: " + ID);

    }

    public Coaching(String name, String date, String type, String comments) throws IOException {
        DateTimeFormatter mdy = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        setName(name);
        setDate(LocalDate.parse(date, mdy));
        setType(type);
        setName(name);
        setComments(comments);
        setID();
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

    public void setID() throws IOException
    {
         ID = Records.getCoaching(this.getName()).size();
    }

    public void setID(int ID) throws IOException
    {
        ID = Records.getCoaching(this.getName()).size();
    }

}