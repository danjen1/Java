
import java.util.Scanner;

public class Main {

    public static String ask(Scanner in, String command) {
        System.out.print(command + " ");
        return in.nextLine();
    }

    public static void add(Scanner in, BirdDatabase db) {
        String name = ask(in, "Name: ");
        String latinName = ask(in, "Latin Name: ");
        db.addBird(name, latinName);
    }

    public static void observation(Scanner in, BirdDatabase db) {
        String name = ask(in, "Name: ");
        boolean success = db.observed(name);
        if (!success) {
            System.out.println("Is not a bird!");
        }
    }

    public static void show(Scanner in, BirdDatabase db) {
        String name = ask(in, "Name: ");
        String answer = db.showBird(name);
        if (answer == null) {
            System.out.println("Is not a bird");
        } else {
            System.out.println(answer);
        }
    }

    public static void statistics(Scanner in, BirdDatabase db) {
        System.out.println(db.statistics());
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BirdDatabase db = new BirdDatabase();

        while (true) {
            String command = ask(scanner, "?");

            if (command.equals("Quit")) {
                break;
            } else if (command.equals("Add")) {
                add(scanner, db);
            } else if (command.equals("Observation")) {
                observation(scanner, db);
            } else if (command.equals("Show")) {
                show(scanner, db);
            } else if (command.equals("Statistics")) {
                statistics(scanner, db);
            } else {
                System.out.println("Unknown Command");
            }
        }
    }

}
