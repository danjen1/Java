package Chapter4;

public class PoorDog
{
    private int size;
    private String name;

    public int getSize()
    {
        return size;
    }

    public String getName()
    {
        return name;
    }

}

/*
Instance variables are declared inside a class but not inside a method
Class Horse(){
private double height = 15.2;
private String breed;
}


Local variables are declared within a method
Class AddThing(){
int a;
int b= 12;

public int add(){
int total = a + b;
return total;
}

Local Variables must be initialized before use
Public Class Foo(){
public void g0(){
int x;
int z = x + 3;
*/