import javax.swing.*;
import java.io.*;
import java.util.ArrayList;

import static java.lang.System.out;


public class Records_DB implements Serializable
{

    public  ArrayList<Advisor> records_db = new ArrayList<>();

    public Records_DB(){

    }


    public void add_Adv()
    {
        Advisor newAdv = new Advisor("Daniel", "Jenkins", "dan_jenkins1@protonmail.com", true,
                "801-300-0056", "Active", "M-F 9am-6pm", "EST",
                "123456789", "123456", "3182 College Ct", "","Elko",
                "NV", "89801", "03/13/2018");
        /*
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
        */
        records_db.add(newAdv);

    }

    public void updateEmail(String name, String email)
    {
        for (Advisor items : this.records_db){
            if (name.equals(items.getName())){
                items.setEmail(email);
            }
        }
        try
        {
            this.writeObject();
        } catch (IOException e)
        {
            e.printStackTrace();
        }

    }

    public void updateName(String EID, String name)
    {
        for (Advisor items : records_db){
            out.println(items.getEID() + items.getName() + items.getSurname());
            if (EID.equals(items.getEID())){
                items.setName(name);
            }
        }
        try
        {
            this.writeObject();
        } catch (IOException e)
        {
            e.printStackTrace();
        }

    }



    //read and write the db file
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



}
