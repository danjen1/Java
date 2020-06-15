package model;

public class Dog extends Animal
{
    private String special;


    public Dog(int id, String breed, int lifespan, String behavior, double price, boolean isVacc, String special)
    {
        super(id, breed, lifespan, behavior, price, isVacc);
        this.special = special;
    }

    public String getSpecial()
    {
        return special;
    }

    public void setSpecial(String special)
    {
        this.special = special;
    }
}
