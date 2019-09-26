
/**
 *
 * @author daniel
 */
public class Person {

    private String name, studID;

    public Person(String name, String id) {
        this.name = name;
        this.studID = id;
    }

    public String getName() {
        return this.name;
    }

    public String getNumber() {
        return this.studID;
    }

    public void changeNumber(String newNumber) {
        this.studID = newNumber;
    }

    @Override
    public String toString() {
        return this.name + " number: " + this.studID;
    }

}
