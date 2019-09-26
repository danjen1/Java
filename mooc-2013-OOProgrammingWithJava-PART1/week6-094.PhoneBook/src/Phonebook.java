
/**
 *
 * @author daniel
 */
import java.util.*;

public class Phonebook {

    private ArrayList<Person> phoneBook;

    public Phonebook(){
        phoneBook = new ArrayList<Person>();
    }
    public void add(String name, String number) {
        Person create = new Person(name, number);
        phoneBook.add(create);
    }

    public void printAll() {
        for (Person person : phoneBook) {
            System.out.println(person);
        }
    }

    public String searchNumber(String name) {
        for (Person person : phoneBook) {
            if (person.getName().equals(name)) {
                return person.getNumber();
            }
        }
        return "number not known";
    }
}
