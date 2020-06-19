package Storage;

import Model.Advisor;
import Model.Attendance;
import Model.Coaching;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Comparator;
import java.util.Scanner;

public class Records {
    private static ObservableList<Advisor> advisorDB = FXCollections.observableArrayList();

    private LocalDate date;

    public Records() throws IOException, ClassNotFoundException
    //default contstructor
    {
        // Records.readObject();
        // Main.Nav.menuMaker("main");

    }


    /**********************************************************************
     *                     Records Management                             *
     **********************************************************************/

    public static void addAdvisor(int ID, Advisor adv) throws IOException {
        boolean found = false;
        for (Advisor item : advisorDB) {
            if (ID == item.getID()) {
                found = true;
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Information Dialog");
                alert.setHeaderText("Error");
                alert.setContentText("Advisor Already Included");
                break;
            }
        }
        if (!found) {
            advisorDB.add(adv);
            System.out.println("Advisor Added" + " " + adv.getID());

            // writeObject()
        }
    }

    public static void updateAdvisor(int ID, Advisor adv) throws IOException {

        advisorDB.set(ID - 1, adv);
        System.out.println("Advisor Added" + " " + adv.getID());

    }
    public static void updateCoaching(int ID, Coaching coach) throws IOException {

        Records.getCoaching(coach.getName()).set(ID - 1, coach);
        System.out.println("Advisor Added" + " " + coach.getID());

    }

    public static void updateAttend(int ID, Attendance attend) throws IOException {

        Records.getAttendance(attend.getName()).set(ID - 1, attend);
        System.out.println("Advisor Added" + " " + attend.getID());

    }


    public static void addAttend(String name, Attendance attend) throws IOException {
        String msg = "Your Model.Attendance Event was added successfully";
        for (Advisor item : advisorDB) {
            if (item.getName().equals(name)) {
                System.out.println(name + " found.  Adding Model.Attendance Event ");
                item.setAttendID();
                attend.setID(item.getAttendID());
                item.getAttendance().add(attend);
                item.getAttendance().sort(Comparator.comparing(Attendance::getDate).reversed());
                //  writeObject();
                System.out.println(msg);

            }
        }
    }

    public static void addCoaching(String name, Coaching coach) throws IOException {
        String msg = "Your Model.Coaching Notes were added successfully";
        for (Advisor item : advisorDB) {
            if (item.getName().equals(name)) {
                System.out.println(name + " found.  Adding Model.Coaching Notes ");
                item.setCoachID();
                coach.setID(item.getCoachID());

                System.out.println("printing AddCoaching ID" + item.getCoachID());
                item.getCoach().add(coach);
                item.getCoach().sort(Comparator.comparing(Coaching::getDate).reversed());
                // writeObject();
                System.out.println(msg);
                //item.print();
            }
        }
    }

    public static ObservableList<Coaching> getCoaching(String name) throws IOException {
        for (Advisor item : advisorDB) {
            if (item.getName().equals(name)) {
                System.out.println(name + " found.  Adding Model.Coaching Notes ");
                return item.getCoach();
            }
        }
        return null;
    }

    public static ObservableList<Attendance> getAttendance(String name) throws IOException {
        for (Advisor item : advisorDB) {
            if (item.getName().equals(name)) {
                System.out.println(name + " found.  Adding Attendance Info ");
                return item.getAttendance();
            }
        }
        return null;
    }





    public void rmvCoaching(String name, String date, String type) throws IOException {
        DateTimeFormatter mdy = DateTimeFormatter.ofPattern("M/dd/yy");
        LocalDate input = LocalDate.parse(date, mdy);
        for (Advisor item : advisorDB) {
            if (item.getName().equals(name)) {

            }
        }
    }


    public static ObservableList<Advisor> getAdvisorDB() {
        return advisorDB;
    }


    public static void setAdvisorDB(ObservableList<Advisor> advisorDB) {
        Records.advisorDB = advisorDB;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

}



  /*
    /**********************************************************************
     *                     Database Load / Save                           *
     *********************************************************************

  public static void writeObject() throws IOException
    {
        FileOutputStream fos = new FileOutputStream("database.ser");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(advisorDB);
        oos.close();
    }

    public static void readObject() throws IOException, ClassNotFoundException
    {
        FileInputStream fis = null;
        try
        {
            fis = new FileInputStream("database.ser");
            ObjectInputStream ois = new ObjectInputStream(fis);
            advisorDB = (ObservableList<Advisor>) ois.readObject();
            System.out.println("Saved Database Loaded");
            ois.close();
        } catch (FileNotFoundException e)
        {
            //JOptionPane.showMessageDialog(null, "You're new here\nLet's get started");
            System.out.println("file not found, saving the database");
            writeObject();
        }

    }
*/
