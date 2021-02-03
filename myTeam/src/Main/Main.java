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

public class
Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("/View_Controller/Overview.fxml"));
        primaryStage.setTitle("Team Info");
        root.getStylesheets().add("CSS/OverviewMenu.css");
        primaryStage.setScene(new Scene(root, 1540, 740));
        primaryStage.setResizable(false);
        primaryStage.show();
    }


    public static void main(String[] args) throws IOException {
        new Advisor("Sue Goodwin", "123456", "999999999", "sue_goodwin@mail.com", "Leave", "5x8", "8:30-8:00 SMRF", "801-300-0056", "EST", "05/22/2017","5/28", "425 Ferry Road Philadelphia, PA 11111" );
        new Advisor("Hakeem Olujawon", "012345", "888888888", "hakeem_olajuwon@mail.com", "Loan", "Split", "9:30-9:30 YTWRF",  "435-578-7899", "PST", "05/22/2017", "8/30", "435 East Blvd, New Springs, FL 99999");
        new Advisor("Michael Jordan", "234567", "777777777", "mike_jordan@mail.com", "Leave", "4x10", "8:30-8:00 SMRF",  "385-789-1234", "EST", "05/22/2017", "3/19", "245 Tehama Blvd, San Fancisco CA 00000");
        new Advisor("Clyde Drexler", "345678", "66666666", "clyde_drexler@mail.com", "Active", "5x8", "7:30-7:30 SMTWR", "801-987-1234", "EST", "5/22/2017", "11/15", "98512 Hyde Jekyl Ln, Raleigh, NC 33333");
        new Advisor("Joseph Smith", "456789", "555555555", "joseph_smith@mail.com", "Leave", "5x8", "8:30-8:00 SMRF", "385-254-1238", "EST", "5/18/2013","5/28", "1325 State St Apt 100 Seattla, WA 44444" );
        new Advisor("Donald Trump", "567890", "444444444", "donald_trump@potus.com", "Loan", "Split", "9:30-9:30 YTWRF", "435-435-9012", "PST", "05/22/2017", "8/30", "435687 E Fake Road #2057, Protland, OR 55555");
        new Advisor("Joe Biden", "678901", "333333333", "joe_biden@dementia.com", "Leave", "4x10", "8:30-8:00 SMRF", "412-854-7803", "EST", "05/22/2017", "3/19", "747 Evergreen Terrace, Springfield, MO 66666");
        new Advisor("Mike Pence", "789012", "222222222", "mike_pence@vpotus.com", "Active", "5x8", "7:30-7:30 SMTWR", "987-952-9632", "EST", "5/22/2017", "11/15", "456 W Paper St, E Lansing, MI 77777");
        new Advisor("Tucker Carlson", "891023", "111111111", "tucker_carlson@mail.com", "Leave", "5x8", "8:30-8:00 SMRF", "874-520-1287", "EST", "5/18/2013","5/28", "W 84th St S Lake, Witchita, KS 88888" );
        new Advisor("Hillary Clinton", "910234", "000000000", "hillary_clinton@jail.com", "Loan", "Split", "9:30-9:30 YTWRF", "888-456-1234", "PST", "05/22/2017", "8/30", "31945 E Tree Road, Jackson, MS 01234");
        new Advisor("Barack Obama", "312456", "000111000", "barack_obama@mail.com", "Leave", "4x10", "8:30-8:00 SMRF", "499-999-9999", "EST", "05/22/2017", "3/19", "12 N 24568 East Blvd, Colorado Springs, CO 12345");
        new Advisor("George Bush", "987654", "111222111", "george_bush@iraqwar.com", "Active", "5x8", "7:30-7:30 SMTWR", "123-014-7890", "EST", "5/22/2017", "11/15", "1700 Pennsylvania Ave, Washington D.C. 45678");
        new Advisor("Thomas Jefferson", "876543", "222333222", "thomas_jefferson@founders.com", "Leave", "5x8", "8:30-8:00 SMRF", "012-456-3698", "EST", "5/18/2013","5/28", "12345 E 19482 W Orange, FL 52089" );
        new Advisor("Henry Ford", "765432", "333444333", "henry_ford@cars.com", "Loan", "Split", "9:30-9:30 YTWRF", "546-987-3210", "PST", "05/22/2017", "8/30", "West 48th St, Nashville, TN 45287");
        new Advisor("Elon Musk", "654321", "444555444", "elon_musk@tesla.com", "Leave", "4x10", "8:30-8:00 SMRF", "111-222-3456", "EST", "05/22/2017", "3/19", "22345 East Torrential Road, Madison, WI 63584");
        new Advisor("Nikola Tesla", "543210", "666555444", "nikola_tesla@electric.com", "Active", "5x8", "7:30-7:30 SMTWR", "987-456-0127", "EST", "5/22/2017", "11/15", "4567 W 5467 N Lake, Billings, MT 01258");

        new Advisor("Daniel Jenkins", "123455", "553432", "dan@dan.com", "Active", "8x5", "M-F 9-5", "333-741-9630", "EST", "05/13/2013", "8/15", "5400 S 2800 E Tree, Boston, MA 22258");
        new Advisor("Madison Jenkins", "123455", "553432", "maddy@maddy.com", "Active", "8x5", "SMTWF 9:00am - 6:00pm", "801-360-8888", "EST", "05/13/2013", "8/15", "34563 Eastern Ln, Boise, ID 47136");
        new Attendance("Madison Jenkins", "2018-04-20", "Approved", 8, "Test Model.Attendance 2", false);
        new Attendance("Madison Jenkins", "2018-04-20", "VTO", 8, "Test Model.Attendance 2", true);
        new Attendance("Madison Jenkins", "2018-04-20", "Comp Down Time", 8, "Test Model.Attendance 2",true);
        /*new Attendance("Madison Jenkins", "4/13/20", "Early or Late Out", 8, "Test Model.Attendance 2",true);
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
        */
       // new Coaching( "Daniel Jenkins", "2020-06-10", "1x1", "Great job 1");
        new Coaching( "Daniel Jenkins", "2020-05-10", "1x1", "Great job 1");
        new Coaching( "Daniel Jenkins","2020-05-10", "Check-in", "Great job 1");
        new Coaching("Daniel Jenkins", "2020-05-10", "AUX", "Great job 1");
        new Coaching("Daniel Jenkins", "2020-05-10", "Follow Up", "Great job 1");
        new Coaching("Madison Jenkins", "2020-05-10", "1x1", "Great job 1");
        new Coaching("Madison Jenkins", "2020-05-10", "Check-in", "Great job 1");
        new Coaching("Madison Jenkins", "2020-05-10", "AUX", "Great job 1");
        new Coaching("Madison Jenkins", "2020-05-10", "Follow Up", "Great job 1");
        new Attendance("Daniel Jenkins", "2020-05-10", "Full Day Sick", 8, "Test2",true);
        new Attendance("Daniel Jenkins", "2020-04-10", "Full Day Sick", 8, "Test2",true);
        new Attendance("Daniel Jenkins", "2020-03-10", "Full Day Sick", 8, "Test2",true);
        new Attendance("Daniel Jenkins", "2020-02-10", "Full Day Sick", 8, "Test2",true);
        new Attendance("Daniel Jenkins", "2020-01-10", "Full Day Sick", 8, "Test2",true);
        new Attendance("Daniel Jenkins", "2019-12-10", "Full Day Sick", 8, "Test2",true);
        new Attendance("Daniel Jenkins", "2019-11-10", "Full Day Sick", 8, "Test2",true);
        new Attendance("Daniel Jenkins", "2019-10-10", "Full Day Sick", 8, "Test2",true);
        new Attendance("Daniel Jenkins", "2019-09-10", "Full Day Sick", 8, "Test2",true);
        new Attendance("Daniel Jenkins", "2019-08-10", "Full Day Sick", 8, "Test2",true);
        new Attendance("Daniel Jenkins", "2019-07-10", "Full Day Sick", 8, "Test2",true);
        new Attendance("Daniel Jenkins", "2019-06-10", "Full Day Sick", 8, "Test2",true);
        new Attendance("Daniel Jenkins", "2019-05-10", "Full Day Sick", 8, "Test2",true);
        new Attendance("Daniel Jenkins", "2019-04-10", "Full Day Sick", 8, "Test2",true);
        new Attendance("Daniel Jenkins", "2019-03-10", "Full Day Sick", 8, "Test2",true);
        new Attendance("Daniel Jenkins", "2019-02-10", "Full Day Sick", 8, "Test2",true);
        new Coaching( "Daniel Jenkins", "2020-04-10", "1x1", "Great job 1");
        new Coaching( "Daniel Jenkins","2020-03-10", "Check-in", "Great job 1");
        new Coaching("Daniel Jenkins", "2020-02-10", "AUX", "Great job 1");
        new Coaching("Daniel Jenkins", "2020-01-10", "Follow Up", "Great job 1");
        new Coaching( "Daniel Jenkins", "2019-12-10", "1x1", "Great job 1");
        new Coaching( "Daniel Jenkins","2019-11-10", "Check-in", "Great job 1");
        new Coaching("Daniel Jenkins", "2019-10-10", "AUX", "Great job 1");
        new Coaching("Daniel Jenkins", "2019-09-10", "Follow Up", "Great job 1");
        new Coaching( "Daniel Jenkins", "2019-08-10", "1x1", "Great job 1");
        new Coaching( "Daniel Jenkins","2019-07-10", "Check-in", "Great job 1");
        new Coaching("Daniel Jenkins", "2019-06-10", "AUX", "Great job 1");
        new Coaching("Daniel Jenkins", "2019-05-10", "Follow Up", "Great job 1");
        new Coaching("Daniel Jenkins", "2016-05-10", "Follow Up", "Great job 1");
        new Coaching("Daniel Jenkins", "2020-06-15", "1x1", "Great job 1");
        new Coaching("Daniel Jenkins", "2020-06-15", "Check-in", "Great job 1");
        new Coaching("Daniel Jenkins", "2020-06-15", "NorthStar", "Great job 1");
        new Attendance("Daniel Jenkins", "2020-06-15", "ROD", 8, "Test2",true);
        new Attendance("Daniel Jenkins", "2020-05-10", "ROD", 8, "Test2",true);
        new Attendance("Daniel Jenkins", "2020-04-10", "ROD", 8, "Test2",true);
        new Attendance("Daniel Jenkins", "2020-03-10", "ROD", 8, "Test2",true);
        new Attendance("Daniel Jenkins", "2020-02-10", "ROD", 8, "Test2",true);
        new Attendance("Daniel Jenkins", "2020-01-10", "ROD", 8, "Test2",true);
        new Attendance("Daniel Jenkins", "2019-12-10", "ROD", 8, "Test2",true);
        new Attendance("Daniel Jenkins", "2019-11-10", "ROD", 8, "Test2",true);
        new Attendance("Daniel Jenkins", "2019-10-10", "ROD", 8, "Test2",true);
        new Attendance("Daniel Jenkins", "2019-09-10", "ROD", 8, "Test2",true);
        new Attendance("Daniel Jenkins", "2019-08-10", "ROD", 8, "Test2",true);
        new Attendance("Daniel Jenkins", "2019-07-10", "ROD", 8, "Test2",true);
        new Attendance("Daniel Jenkins", "2019-06-10", "ROD", 8, "Test2",true);
        new Attendance("Daniel Jenkins", "2019-05-10", "ROD", 8, "Test2",true);
        new Attendance("Daniel Jenkins", "2019-04-10", "ROD", 8, "Test2",true);
        new Attendance("Daniel Jenkins", "2019-03-10", "ROD", 8, "Test2",true);
        new Attendance("Daniel Jenkins", "2019-02-10", "ROD", 8, "Test2",true);
        new Attendance("Daniel Jenkins", "2020-06-15", "NTF", 8, "Test2",true);
        new Attendance("Daniel Jenkins", "2020-05-10", "NTF", 8, "Test2",true);
        new Attendance("Daniel Jenkins", "2020-04-10", "NTF", 8, "Test2",true);
        new Attendance("Daniel Jenkins", "2020-03-10", "NTF", 8, "Test2",true);
        new Attendance("Daniel Jenkins", "2020-02-10", "NTF", 8, "Test2",true);
        new Attendance("Daniel Jenkins", "2020-01-10", "NTF", 8, "Test2",true);
        new Attendance("Daniel Jenkins", "2019-12-10", "NTF", 8, "Test2",true);
        new Attendance("Daniel Jenkins", "2019-11-10", "NTF", 8, "Test2",true);
        new Attendance("Daniel Jenkins", "2019-10-10", "NTF", 8, "Test2",true);
        new Attendance("Daniel Jenkins", "2019-09-10", "NTF", 8, "Test2",true);
        new Attendance("Daniel Jenkins", "2019-08-10", "NTF", 8, "Test2",true);
        new Attendance("Daniel Jenkins", "2019-07-10", "NTF", 8, "Test2",true);
        new Attendance("Daniel Jenkins", "2019-06-10", "NTF", 8, "Test2",true);
        new Attendance("Daniel Jenkins", "2019-05-10", "NTF", 8, "Test2",true);
        new Attendance("Daniel Jenkins", "2019-04-10", "NTF", 8, "Test2",true);
        new Attendance("Daniel Jenkins", "2019-03-10", "NTF", 8, "Test2",true);
        new Attendance("Daniel Jenkins", "2019-02-10", "NTF", 8, "Test2",true);
        new Attendance("Daniel Jenkins", "2020-06-15", "Home DownTime", 8, "Test2",true);
        new Attendance("Daniel Jenkins", "2020-05-10", "Home DownTime", 8, "Test2",true);
        new Attendance("Daniel Jenkins", "2020-04-10", "Home DownTime", 8, "Test2",true);
        new Attendance("Daniel Jenkins", "2020-03-10", "Home DownTime", 8, "Test2",true);
        new Attendance("Daniel Jenkins", "2020-02-10", "Home DownTime", 8, "Test2",true);
        new Attendance("Daniel Jenkins", "2020-01-10", "Home DownTime", 8, "Test2",true);
        new Attendance("Daniel Jenkins", "2019-12-10", "Home DownTime", 8, "Test2",true);
        new Attendance("Daniel Jenkins", "2019-11-10", "Home DownTime", 8, "Test2",true);
        new Attendance("Daniel Jenkins", "2019-10-10", "Home DownTime", 8, "Test2",true);
        new Attendance("Daniel Jenkins", "2019-09-10", "Home DownTime", 8, "Test2",true);
        new Attendance("Daniel Jenkins", "2019-08-10", "Home DownTime", 8, "Test2",true);
        new Attendance("Daniel Jenkins", "2019-07-10", "Home DownTime", 8, "Test2",true);
        new Attendance("Daniel Jenkins", "2019-06-10", "Home DownTime", 4.25, "Test2",true);
        new Attendance("Daniel Jenkins", "2019-05-10", "Home DownTime", 4.25, "Test2",true);
        new Attendance("Daniel Jenkins", "2019-04-10", "Home DownTime", 4.25, "Test2",true);
        new Attendance("Daniel Jenkins", "2019-03-10", "Home DownTime", 4.25, "Test2",true);
        new Attendance("Daniel Jenkins", "2019-02-10", "Home DownTime", 4.25, "Test2",true);
        new Attendance("Daniel Jenkins", "2020-06-15", "KinCare", 4.25, "Test2",true);
        new Attendance("Daniel Jenkins", "2020-05-10", "KinCare", 4.25, "Test2",true);
        new Attendance("Daniel Jenkins", "2020-04-10", "KinCare", 4.25, "Test2",true);
        new Attendance("Daniel Jenkins", "2020-03-10", "KinCare", 4.25, "Test2",true);
        new Attendance("Daniel Jenkins", "2020-02-10", "KinCare", 4.25, "Test2",true);
        new Attendance("Daniel Jenkins", "2020-01-10", "KinCare", 4.25, "Test2",true);
        new Attendance("Daniel Jenkins", "2019-12-10", "KinCare", 4.25, "Test2",true);
        new Attendance("Daniel Jenkins", "2019-11-10", "KinCare", 5.26, "Test2",true);
        new Attendance("Daniel Jenkins", "2019-10-10", "KinCare", 5.26, "Test2",true);
        new Attendance("Daniel Jenkins", "2019-09-10", "KinCare", 5.26, "Test2",true);
        new Attendance("Daniel Jenkins", "2019-08-10", "KinCare", 5.26, "Test2",true);
        new Attendance("Daniel Jenkins", "2019-07-10", "KinCare", 5.26, "Test2",true);
        new Attendance("Daniel Jenkins", "2019-06-10", "KinCare", 5.26, "Test2",true);
        new Attendance("Daniel Jenkins", "2019-05-10", "KinCare", 5.26, "Test2",true);
        new Attendance("Daniel Jenkins", "2019-04-10", "KinCare", 5.26, "Test2",true);
        new Attendance("Daniel Jenkins", "2019-03-10", "KinCare", 5.26, "Test2",true);
        new Attendance("Daniel Jenkins", "2019-02-10", "KinCare", 5.26, "Test2",true);


        launch(args);
    }
}