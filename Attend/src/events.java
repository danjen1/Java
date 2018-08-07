public class events
{
    /*private static void remove(String ID)
    {
        for (advisor item : events)
        {
            if (ID.equals(item.getID()))
            {
                records_db.remove(item);
               return;
            }
        }
        System.out.println("advisor not found, no ID match");
    }

    private static void printAll()
    {
        for (advisor item : records_db)
        {
            item.print();
        }
        System.out.println();
    }
    private static void print_average_grade(String ID)
    {
        for (advisor item : records_db)
        {

            if (ID.equals(item.getID()))
            {
                double total = 0;
                //for (double grade : item.getGrades())
                {
                    //total += grade;
                }
                //total = total / item.getGrades().length;
               // System.out.print("advisor ID " + item.getID() + ": average of " + item.getEvents().length + " grades for " + item.getFirstName() + " is: ");
                System.out.printf("%.2f", total);
                System.out.println("\n");
                return;
            }
        }
        System.out.println("advisor ID not found");
        System.out.println();
    }
    private static void print_invalid_emails()
    {
        for (advisor item : records_db)
        {
            if (!(item.getEmail().contains("@")) || (item.getEmail().contains(" ") || (!(item.getEmail().contains(".")))))
            {
                System.out.println("advisor " + item.getFirstName() + " email is invalid: " + item.getEmail());
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
       // advisor newStud = new advisor(ID, firstName, lastName, Email, age, grades);
        //records_db.add(newStud);
    }

    public static void main(String[] args)
    {
        /*
        Make both records and records_db
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
