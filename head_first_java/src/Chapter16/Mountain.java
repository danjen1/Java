package Chapter16;

public class Mountain
{
    String name;
    int height;

    public Mountain(String name, int height)
    {
        this.name = name;
        this.height = height;
    }

    public String toString()
    {
        return name + " " + height;
    }
}
