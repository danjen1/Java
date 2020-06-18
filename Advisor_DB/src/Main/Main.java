package Main;
import Model.Advisor;
import Model.Attendance;
import Model.Coaching;
import Storage.Records;
import View_Controller.OverviewMenuController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("/View_Controller/Overview.fxml"));
        primaryStage.setTitle("Overview Menu");
        root.getStylesheets().add("CSS/OverviewMenu.css");
        primaryStage.setScene(new Scene(root, 1280, 680));
        primaryStage.show();


    }


    public static void main(String[] args) throws IOException {
        new Advisor("Christopher Cottrell", "519509", "973629301", "hakeem_anderson@apple.com", "LOA", "5x8", "8:30-8:00 SMRF", "801-300-0056", "EST", "05/22/2017","5/28", "4025 McGinnis Ferry Apt 208 Suwanee, GA 30024" );
        new Advisor("Hakeem Anderson", "520814", "973630904", "hakeem_anderson@apple.com", "Rotation", "Split", "9:30-9:30 YTWRF",  "530-227-5377", "PST", "05/22/2017", "8/30", "435 Northlake blvd #2057, Altamonte Springs, FL 32701");
        new Advisor("Blake Glasure", "513509", "973629301", "bglasure@apple.com", "LOA", "4x10", "8:30-8:00 SMRF",  "407-907-0738", "EST", "05/22/2017", "3/19", "2245 Tehama st, Redding CA 96001");
        new Advisor("Jasmine Mayham", "540139", "973630079", "jmayham@apple.com", "Active", "5x8", "7:30-7:30 SMTWR", "716-400-2026", "EST", "5/22/2017", "11/15", "9853 Hyde glen ct, Charlotte, NC 28262");
        new Advisor("Joseph Smith", "519209", "973629301", "hakeem_anderson@apple.com", "LOA", "5x8", "8:30-8:00 SMRF", "801-300-0056", "EST", "5/18/2013","5/28", "4025 McGinnis Ferry Apt 208 Suwanee, GA 30024" );
        new Advisor("Donald Trump", "520114", "973630904", "hakeem_anderson@apple.com", "Rotation", "Split", "9:30-9:30 YTWRF", "530-227-5377", "PST", "05/22/2017", "8/30", "435 Northlake blvd #2057, Altamonte Springs, FL 32701");
        new Advisor("Joe Biden", "519559", "973629301", "bglasure@apple.com", "LOA", "4x10", "8:30-8:00 SMRF", "407-907-0738", "EST", "05/22/2017", "3/19", "2245 Tehama st, Redding CA 96001");
        new Advisor("Mike Pence", "420139", "973630079", "jmayham@apple.com", "Active", "5x8", "7:30-7:30 SMTWR", "716-400-2026", "EST", "5/22/2017", "11/15", "9853 Hyde glen ct, Charlotte, NC 28262");
        new Advisor("Tucker Carlson", "515509", "973629301", "hakeem_anderson@apple.com", "LOA", "5x8", "8:30-8:00 SMRF", "801-300-0056", "EST", "5/18/2013","5/28", "4025 McGinnis Ferry Apt 208 Suwanee, GA 30024" );
        new Advisor("Hillary Clinton", "530814", "973630904", "hakeem_anderson@apple.com", "Rotation", "Split", "9:30-9:30 YTWRF", "530-227-5377", "PST", "05/22/2017", "8/30", "435 Northlake blvd #2057, Altamonte Springs, FL 32701");
        new Advisor("Barack Obama", "519209", "973629301", "bglasure@apple.com", "LOA", "4x10", "8:30-8:00 SMRF", "407-907-0738", "EST", "05/22/2017", "3/19", "2245 Tehama st, Redding CA 96001");
        new Advisor("George Bush", "560139", "973630079", "jmayham@apple.com", "Active", "5x8", "7:30-7:30 SMTWR", "716-400-2026", "EST", "5/22/2017", "11/15", "9853 Hyde glen ct, Charlotte, NC 28262");
        new Advisor("Thomas Jefferson", "519309", "973629301", "hakeem_anderson@apple.com", "LOA", "5x8", "8:30-8:00 SMRF", "801-300-0056", "EST", "5/18/2013","5/28", "4025 McGinnis Ferry Apt 208 Suwanee, GA 30024" );
        new Advisor("Henry Ford", "560814", "973630904", "hakeem_anderson@apple.com", "Rotation", "Split", "9:30-9:30 YTWRF", "530-227-5377", "PST", "05/22/2017", "8/30", "435 Northlake blvd #2057, Altamonte Springs, FL 32701");
        new Advisor("Elon Musk", "519509", "973629301", "bglasure@apple.com", "LOA", "4x10", "8:30-8:00 SMRF", "407-907-0738", "EST", "05/22/2017", "3/19", "2245 Tehama st, Redding CA 96001");
        new Advisor("Nikola Tesla", "501339", "973630079", "jmayham@apple.com", "Active", "5x8", "7:30-7:30 SMTWR", "716-400-2026", "EST", "5/22/2017", "11/15", "9853 Hyde glen ct, Charlotte, NC 28262");

        new Advisor("Daniel Jenkins", "123455", "553432", "dan@dan.com", "Active", "8x5", "M-F 9-5", "801-300-0056", "EST", "05/13/2013", "8/15", "3182 College Court Elko, NV 89801");
        new Advisor("Madison Jenkins", "123455", "553432", "maddy@maddy.com", "Active", "8x5", "SMTWF 9:00am - 6:00pm", "801-360-5225", "EST", "05/13/2013", "8/15", "3182 College Court Elko, NV 89801");
        new Attendance("Madison Jenkins", "5/16/20", "Approved", 8, "Test Model.Attendance 2", false);
        new Attendance("Madison Jenkins", "4/16/20", "VTO", 8, "Test Model.Attendance 2", true);
        new Attendance("Madison Jenkins", "4/16/20", "Apple Down Time", 8, "Test Model.Attendance 2",true);
        new Attendance("Madison Jenkins", "4/13/20", "Early or Late Out", 8, "Test Model.Attendance 2",true);
        new Attendance("Madison Jenkins", "4/16/20", "Personal", 8, "Test Model.Attendance 2",true);
        new Attendance("Madison Jenkins", "6/13/20", "Home DownTime", 8, "Test Model.Attendance 2",true);
        new Attendance("Madison Jenkins", "8/16/18",  "Inclement Weather", 8, "Test Model.Attendance 2",true);
        new Attendance("Madison Jenkins", "4/16/20",  "Full Day Sick", 8, "Test Model.Attendance 2",true);
        new Attendance("Madison Jenkins", "4/16/20",  "Full Day Sick", 8, "Test2",true);
        new Attendance("Madison Jenkins", "8/16/18", "Mid Day Sick", 8, "Test Model.Attendance 2",true);
        new Attendance("Madison Jenkins", "4/16/20", "Early or Late Out", 8, "Test Model.Attendance 2",true);
        new Attendance("Madison Jenkins", "7/16/18", "Early or Late Out", 8, "Test Model.Attendance 2",true);
        new Attendance("Madison Jenkins", "4/16/20", "Personal", 8, "Test Model.Attendance 2",true);
        new Attendance("Madison Jenkins", "4/16/20", "No Call No Show", 8, "Test Model.Attendance 2",true);
        new Attendance("Madison Jenkins", "6/13/18", "Pending Protected Time", 8, "Test Model.Attendance 2",true);
        new Attendance("Madison Jenkins", "4/16/20", "Tardy or Left Early", 8, "Test Model.Attendance 2",false);
        new Attendance("Madison Jenkins", "8/13/18", "Late From Lunch", 8, "Test Model.Attendance 2",false);
        new Attendance("Madison Jenkins", "4/16/20", "KinCare", 8, "Test2",false);
        new Attendance("Madison Jenkins", "4/16/20", "Regional Sick", 8, "Test Model.Attendance 2",false);
        new Attendance("Madison Jenkins", "4/16/20", "Bereavement", 8, "Test Model.Attendance 2",false);
        new Attendance("Madison Jenkins", "7/16/18", "Parental Time", 8, "Test Model.Attendance 2",false);
        new Attendance("Madison Jenkins", "4/16/20", "Jury Duty", 8, "Test Model.Attendance 2",false);
        new Attendance("Madison Jenkins", "4/16/20", "LOA", 8, "Test Model.Attendance 2",false);
        new Attendance("Madison Jenkins", "6/13/18", "iLOA", 8, "Test Model.Attendance 2",false);
        new Attendance("Madison Jenkins", "8/16/18", "Job Accommodation", 8, "Test Model.Attendance 2",false);
        new Attendance("Madison Jenkins", "8/13/18", "Bereavement", 8, "Test Model.Attendance 2",false);
        new Attendance("Madison Jenkins", "4/13/18", "iLOA", 8, "Test2",false);
        new Attendance("Daniel Jenkins", "4/16/20", "iLOA", 8, "Test Model.Attendance 2",false);
        new Attendance("Daniel Jenkins", "8/13/18", "Personal", 8, "Test Model.Attendance 2",false);
        new Attendance("Daniel Jenkins", "4/16/20", "Partial Day", 8, "Test Model.Attendance 2",false);
        new Attendance("Daniel Jenkins", "7/13/18", "Full Day", 8, "Test Model.Attendance 2",false);
        new Attendance("Daniel Jenkins", "6/16/18", "Full Day", 8, "Test Model.Attendance 2",false);
        new Attendance("Daniel Jenkins", "6/13/18", "Partial Day", 8, "Test Model.Attendance 2",false);
        new Attendance("Daniel Jenkins", "8/16/18", "Partial Day", 8, "Test Model.Attendance 2",false);
        new Attendance("Madison Jenkins", "4/16/20", "iLOA", 8, "Test Model.Attendance 2",false);
        new Attendance("Madison Jenkins", "4/13/18", "iLOA", 8, "Test2",true);
        new Attendance("Madison Jenkins", "8/16/18", "iLOA", 8, "Test Model.Attendance 2",true);
        new Attendance("Madison Jenkins", "8/13/18", "iLOA", 8, "Test Model.Attendance 2",true);
        new Attendance("Madison Jenkins", "7/16/18", "iLOA", 8, "Test Model.Attendance 2",true);
        new Attendance("Madison Jenkins", "7/13/18", "iLOA", 8, "Test Model.Attendance 2",true);
        new Attendance("Madison Jenkins", "6/16/18", "iLOA", 8, "Test Model.Attendance 2",true);
        new Attendance("Madison Jenkins", "6/13/18", "iLOA", 8, "Test Model.Attendance 2",true);
        new Attendance("Madison Jenkins", "8/16/18", "iLOA", 8, "Test Model.Attendance 2",true);
        new Attendance("Madison Jenkins", "8/13/18", "iLOA", 8, "Test Model.Attendance 2",true);
        new Attendance("Madison Jenkins", "4/13/18", "iLOA", 8, "Test2",true);
        new Attendance("Madison Jenkins", "8/16/18", "VTO", 8, "Test Model.Attendance 2",true);
        new Attendance("Madison Jenkins", "8/13/18", "VTO", 8, "Test Model.Attendance 2",true);
        new Attendance("Madison Jenkins", "7/16/18", "VTO", 8, "Test Model.Attendance 2",true);
        new Attendance("Madison Jenkins", "7/13/18", "VTO", 8, "Test Model.Attendance 2",true);
        new Attendance("Madison Jenkins", "6/16/18", "VTO", 8, "Test Model.Attendance 2",true);
        new Attendance("Madison Jenkins", "6/13/18", "VTO", 8, "Test Model.Attendance 2",true);
        new Attendance("Madison Jenkins", "8/16/18", "VTO", 8, "Test Model.Attendance 2",true);
        new Attendance("Madison Jenkins", "8/13/18", "VTO", 8, "Test Model.Attendance 2",true);
        new Attendance("Madison Jenkins", "4/13/18", "VTO", 8, "Test2",true);
        new Attendance("Daniel Jenkins", "8/16/18", "Pending Protected Time", 8, "Test Model.Attendance 2",false);
        new Attendance("Daniel Jenkins", "8/13/18", "Pending Protected Time", 8, "Test Model.Attendance 2",false);
        new Attendance("Daniel Jenkins", "7/16/18", "Pending Protected Time", 8, "Test Model.Attendance 2",false);
        new Attendance("Daniel Jenkins", "7/13/18", "Pending Protected Time", 8, "Test Model.Attendance 2",false);
        new Attendance("Daniel Jenkins", "6/16/18", "Pending Protected Time", 8, "Test Model.Attendance 2",false);
        new Attendance("Daniel Jenkins", "6/13/18", "Pending Protected Time", 8, "Test Model.Attendance 2",false);
        new Attendance("Daniel Jenkins", "8/16/18", "Pending Protected Time", 8, "Test Model.Attendance 2",false);
        new Attendance("Daniel Jenkins", "8/13/18", "Pending Protected Time", 8, "Test Model.Attendance 2",false);
        new Attendance("Daniel Jenkins", "4/13/18", "Pending Protected Time", 8, "Test2",false);
        new Attendance("Daniel Jenkins", "8/16/18", "Pending Protected Time", 8, "Test Model.Attendance 2",false);
        new Attendance("Daniel Jenkins", "8/13/18", "Approved", 8, "Test Model.Attendance 2",false);
        new Attendance("Daniel Jenkins", "7/16/18", "Approved", 8, "Test Model.Attendance 2",false);
        new Attendance("Daniel Jenkins", "7/13/18", "Approved", 8, "Test Model.Attendance 2",false);
        new Attendance("Daniel Jenkins", "6/16/18", "Approved", 8, "Test Model.Attendance 2",false);
        new Attendance("Daniel Jenkins", "6/13/18", "Approved", 8, "Test Model.Attendance 2",false);
        new Attendance("Daniel Jenkins", "8/16/18", "Approved", 8, "Test Model.Attendance 2",false);
        new Attendance("Daniel Jenkins", "8/13/18", "Approved", 8, "Test Model.Attendance 2",false);
        new Attendance("Daniel Jenkins", "4/13/18", "Approved", 8, "Test2",false);
        new Attendance("Daniel Jenkins", "8/16/18", "Approved", 8, "Test Model.Attendance 2",false);
        new Attendance("Daniel Jenkins", "8/13/18", "Approved", 8, "Test Model.Attendance 2",false);
        new Attendance("Daniel Jenkins", "7/16/18", "Early or Late Out", 8, "Test Model.Attendance 2",false);
        new Attendance("Daniel Jenkins", "7/13/18", "Early or Late Out", 8, "Test Model.Attendance 2",false);
        new Attendance("Daniel Jenkins", "6/16/18", "Early or Late Out", 8, "Test Model.Attendance 2",false);
        new Attendance("Daniel Jenkins", "6/13/18", "Early or Late Out", 8, "Test Model.Attendance 2",true);
        new Attendance("Daniel Jenkins", "8/16/18", "Early or Late Out", 8, "Test Model.Attendance 2",true);
        new Attendance("Daniel Jenkins", "8/13/18", "Early or Late Out", 8, "Test Model.Attendance 2",true);
        new Attendance("Daniel Jenkins", "4/13/18", "Early or Late Out", 8, "Test2",true);
        new Attendance("Daniel Jenkins", "8/16/18", "Early or Late Out", 8, "Test Model.Attendance 2",true);
        new Attendance("Daniel Jenkins", "8/13/18", "Early or Late Out", 8, "Test Model.Attendance 2",true);
        new Attendance("Daniel Jenkins", "7/16/18", "Early or Late Out", 8, "Test Model.Attendance 2",true);
        new Attendance("Daniel Jenkins", "7/13/18", "Early or Late Out", 8, "Test Model.Attendance 2",true);
        new Attendance("Daniel Jenkins", "6/16/18", "Early or Late Out", 8, "Test Model.Attendance 2",true);
        new Attendance("Daniel Jenkins", "6/13/18", "Early or Late Out", 8, "Test Model.Attendance 2",true);
        new Attendance("Daniel Jenkins", "8/16/18", "Early or Late Out", 8, "Test Model.Attendance 2",true);
        new Attendance("Daniel Jenkins", "8/13/18", "Early or Late Out", 8, "Test Model.Attendance 2",true);
        new Attendance("Daniel Jenkins", "4/13/18", "Early or Late Out", 8, "Test2",true);
        new Attendance("Daniel Jenkins", "8/16/18", "Full Day Sick", 8, "Test Model.Attendance 2",true);
        new Attendance("Daniel Jenkins", "8/13/18", "Full Day Sick", 8, "Test Model.Attendance 2",true);
        new Attendance("Daniel Jenkins", "7/16/18", "Full Day Sick", 8, "Test Model.Attendance 2",true);
        new Attendance("Daniel Jenkins", "7/13/18", "Full Day Sick", 8, "Test Model.Attendance 2",true);
        new Attendance("Daniel Jenkins", "6/16/18", "Full Day Sick", 8, "Test Model.Attendance 2",true);
        new Attendance("Daniel Jenkins", "6/13/18", "Full Day Sick", 8, "Test Model.Attendance 2",true);
        new Attendance("Daniel Jenkins", "8/16/18", "Full Day Sick", 8, "Test Model.Attendance 2",true);
        new Attendance("Daniel Jenkins", "8/13/18", "Full Day Sick", 8, "Test Model.Attendance 2",true);
        new Attendance("Daniel Jenkins", "5/10/20", "Full Day Sick", 8, "Test2",true);


        launch(args);
    }
}
