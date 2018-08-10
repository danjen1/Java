import java.nio.file.Path;
import java.util.ArrayList;

public class records_db {

    private ArrayList<advisor> records_db = new ArrayList<>();

    public records_db(ArrayList<advisor> records_db)
    {
        this.records_db = records_db;
    }
    public records_db(){

    }

    /*
    make getters / setters to pull down Advisor objects and edit variables including events Array
     */

    public ArrayList<advisor> getRecords_db() {
        return records_db;
    }

    public void setRecords_db(ArrayList<advisor> records_db) {
        this.records_db = records_db;
    }

    public void updateEmail(String name, String email)
    {
        for (advisor items : records_db){
            if (name.equals(items.getName())){
                items.setEmail(email);
            }
        }
    }




}
