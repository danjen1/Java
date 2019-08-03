package Chapter4;

public class GoodDogTestDrive
{
    public static void main(String[] args)
    {
        GoodDog one = new GoodDog();
        one.setSize(70);
        GoodDog two = new GoodDog();
        two.setSize(8);
        System.out.println("Dog one: " + one.getSize());
        System.out.println("Dog two: " + two.getSize());
        one.bark();
        two.bark();

        GoodDog[] pets;
        pets = new GoodDog[7];
        pets[0] = new GoodDog();
        pets[1] = new GoodDog();
        pets[2] = new GoodDog();

        pets[2].setSize(90);
        int x = pets[2].getSize();
        System.out.println(x);
        pets[0].setSize(98);

        System.out.println(pets[0].getSize());
    }
}
