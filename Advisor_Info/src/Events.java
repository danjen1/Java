import java.io.Serializable;

public class Events implements Serializable
{
    private Boolean submitted;
    private String date, comments, type;
    private double hours;
    private String[] categories = {"Full Day","Early Out / Late In","Tardy","Late from Lunch","Apple DT","Home DT",
                                "Vacation","KinCare","RSL","LOA","SSD","Bereav","JA","Parental"};

    //Contrsuctors
    public Events(String date, String type, double hours, String comments)
    {
        setDate(date); setType(type); setHours(hours); setComments(comments);
    }



    public Boolean getSubmitted() {
        return submitted;
    }

    public void setSubmitted(Boolean submitted) {
        this.submitted = submitted;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public double getHours() {
        return hours;
    }

    public void setHours(double hours) {
        this.hours = hours;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }









    /*private static void remove(String ID)
    {
        for (Advisor item : Events)
        {
            if (ID.equals(item.getID()))
            {
                Records_DB.remove(item);
               return;
            }
        }
        System.out.println("Advisor not found, no ID match");
    }

    private static void printAll()
    {
        for (Advisor item : Records_DB)
        {
            item.print();
        }
        System.out.println();
    }
    private static void print_average_grade(String ID)
    {
        for (Advisor item : Records_DB)
        {

            if (ID.equals(item.getID()))
            {
                double total = 0;
                //for (double grade : item.getGrades())
                {
                    //total += grade;
                }
                //total = total / item.getGrades().length;
               // System.out.print("Advisor ID " + item.getID() + ": average of " + item.getEvents().length + " grades for " + item.getFirstName() + " is: ");
                System.out.printf("%.2f", total);
                System.out.println("\n");
                return;
            }
        }
        System.out.println("Advisor ID not found");
        System.out.println();
    }
    private static void print_invalid_emails()
    {
        for (Advisor item : Records_DB)
        {
            if (!(item.getEmail().contains("@")) || (item.getEmail().contains(" ") || (!(item.getEmail().contains(".")))))
            {
                System.out.println("Advisor " + item.getFirstName() + " email is invalid: " + item.getEmail());
                System.out.println();
                return;
            }

        }
        System.out.println("All eMails are correct");
        System.out.println();
    }
     */
    private static void add(String ID, String firstName, String lastName, String Email, int age, double grade1, double grade2, double grade3, double grade4, double grade5)
    {
        double grades[] = {grade1, grade2, grade3, grade4, grade5};
       // Advisor newStud = new Advisor(ID, firstName, lastName, Email, age, grades);
        //Records_DB.add(newStud);
    }

    public static void main(String[] args)
    {
        /*
        Make both records and Records_DB
        */

        add("001", "IG", "Horowitz", "Horowitz@protonmail.com", 36, 91.91, 92.92, 93.93, 94.94, 75.75);
        add("002", "Rod", "Rosenstein", "rod_roddy@icloud.com", 37, 98.78, 89.98, 93.45, 99.89, 100);
        add("003", "Jeff", "Sessions", "who_knows @icloud.com", 10, 100, 89.75, 95.85, 99.89, 100);

       /*
        printAll();
        print_average_grade("001");
        print_average_grade("002");
        print_average_grade("003");
        print_invalid_emails();
        */

    }
}
