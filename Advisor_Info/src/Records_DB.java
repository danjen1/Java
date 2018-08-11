import com.sun.prism.impl.Disposer;

import javax.swing.*;
import java.io.*;
import java.util.ArrayList;


public class Records_DB
{

    public  ArrayList<Advisor> records_db = new ArrayList<>();

    public Records_DB(){

    }

    public void printAll()
    {
        for (Advisor items : records_db)
        {
            items.printAdvAll();

        }
    }

    //modify Events Info



    //modify Goals Info

    //modify COachng Info


    //Modify Advisor Info
    public void remove_Adv()
    {
        String combined = JOptionPane.showInputDialog("Name of Advisor To Remove", "First Last");
        String[] splitted = combined.split("\\s+");
        String name = splitted[0];
        String surname = splitted[1];
        for (Advisor item : records_db)
        {
            if (name.equals(item.getName()))//&& item.getSurname().equals(surname))
            {

                records_db.remove(item);
                return;
            }
        }

    }

    public void add_Adv()
    {
        Advisor newAdv = new Advisor();
        String name = JOptionPane.showInputDialog("First Name:", "First");
        String surname = JOptionPane.showInputDialog("Surname:", "Last");
        String email = JOptionPane.showInputDialog("email", "@apple.com");
        String mobile = JOptionPane.showInputDialog("Mobile", "");
        String sched = JOptionPane.showInputDialog("Schedule:");
        String diffString = JOptionPane.showInputDialog("Shift Differential", "Yes / No");
        String t_zone = JOptionPane.showInputDialog("Time Zone", "EST, CST, MST, PST");
        String DSID = JOptionPane.showInputDialog("DSID", "");
        String EID = JOptionPane.showInputDialog("EID", "");
        String address1 = JOptionPane.showInputDialog("Address Line 1", "Street Address");
        String address2 = JOptionPane.showInputDialog("Address Line 2");
        String city = JOptionPane.showInputDialog("City");
        String state = JOptionPane.showInputDialog("State");
        String zip = JOptionPane.showInputDialog("Zip Code");
        String hire_date = JOptionPane.showInputDialog("Hire Date");

        newAdv.setName(name);
        newAdv.setSurname(surname);
        newAdv.setEmail(email);
        newAdv.setDiff(diffString.equals("Yes") || diffString.equals("Y") || diffString.equals("yes"));
        newAdv.setT_zone(t_zone);
        newAdv.setDSID(DSID);
        newAdv.setEID(EID);
        newAdv.setMobile(mobile);
        newAdv.setSched(sched);
        newAdv.setAddress1(address1);
        newAdv.setAddress2(address2);
        newAdv.setCity(city);
        newAdv.setState(state);
        newAdv.setZip(zip);
        newAdv.setHire_date(hire_date);
        newAdv.setEvents(null);
        newAdv.setCoaching(null);
        newAdv.setGoals(null);
        records_db.add(newAdv);

    }

    //read and write the file
    public void writeObject() throws IOException
    {
        FileOutputStream fos = new FileOutputStream("database.ser");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(records_db);
        oos.close();
    }

    public void readObject() throws IOException, ClassNotFoundException
    {
        FileInputStream fis = new FileInputStream("database.ser");
        ObjectInputStream ois = new ObjectInputStream(fis);
        records_db = (ArrayList<Advisor>) ois.readObject();
        ois.close();
    }


    //Getters & Setters
    public Records_DB(ArrayList<Advisor> records_db)
    {
        this.records_db = records_db;
    }

    public ArrayList<Advisor> getRecords_db() {
        return records_db;
    }

    public void setRecords_db(ArrayList<Advisor> records_db) {
        this.records_db = records_db;
    }

    public void updateEmail(String name, String email)
    {
        for (Advisor items : records_db){
            if (name.equals(items.getName())){
                items.setEmail(email);
            }
        }
    }

    public void updateName(String EID, String name)
    {
        for (Advisor items : records_db){
            if (EID.equals(items.getEID())){
                items.setSurname(name);
            }
        }
    }


}
