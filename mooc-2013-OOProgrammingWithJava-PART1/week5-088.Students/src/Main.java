
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        ArrayList<Student> list = new ArrayList<Student>();
        Scanner in = new Scanner(System.in);
        while (true) {
            System.out.println("name: ");
            String name = in.nextLine();
            if (name.isEmpty()) {
                break;
            }
            System.out.println("studentnumber: ");
            String studID = in.nextLine();
            list.add(new Student(name, studID));
        }
        for (Student student : list){
            System.out.println(student);
        }
        System.out.println("");
        
        System.out.println("Give search term: ");
        String search = in.nextLine();
        System.out.println("Result: ");
        for (Student student : list) {
            if(student.getName().contains(search)){
                System.out.println(student);
            }
        }
    }
}
