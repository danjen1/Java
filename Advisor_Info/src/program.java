import java.util.ArrayList;

public class program {
    public static void main(String[] args) {
        //load array from saved file
        ArrayList<advisor> main = new ArrayList<>();
        advisor one = new advisor();
        one.setName("Daniel");
        one.setEmail("daniel_jenkins@apple.com");
        main.add(one);
        records_db def = new records_db();
        def.setRecords_db(main);
        main.add(one);
        System.out.println(main.get(0).getName());
        System.out.println(main.get(0).getEmail());




        /*
        check to see if there's a file saved on the machine if yes provide an alert confirming opening of prior save,
        if not user message indicating they need to add Advisor information in order to use the app.
        create the records_db array array and ask for user input of Advisor Info and events.
        Program Outline:
        What Would you like to do?
        1. Add / Delete / Update Advisor Info
            1: Which Advisor would you like to update:? (Pop Up Window)
                Name
            2: Which category?
                1: surname 2: email 3: diff 4: schedule 5: mobile 6: t_zone 7: DSID
                8: EID 9: address1 10: address2 11: city 12: state 13: zip  14: hire_date
                1: "Full Day", 2: "Early Out / Late In", 3: "Tardy", 4: "Late from Lunch", 5:"Apple DT", 6:"Home DT",
                7:"Vacation", 8:"KinCare", 9:"RSL", 10:"LOA", 11:"SSD", 12:"Bereav", 13:"JA", 14:"Parental"
            2: Updated Info:
        2. Add / Delete / Update Attendance Events
        3. Run Reports

        1: "Full Day", 2: "Early Out / Late In", 3: "Tardy", 4: "Late from Lunch", 5:"Apple DT", 6:"Home DT",
                7:"Vacation", 8:"KinCare", 9:"RSL", 10:"LOA", 11:"SSD", 12:"Bereav", 13:"JA", 14:"Parental"

         */
    }
}
