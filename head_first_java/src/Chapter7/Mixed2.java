package Chapter7;

public class Mixed2
{
    public static void main(String[] args)
    {
        ClassA a = new ClassA();
        ClassB b = new ClassB();
        ClassC c = new ClassC();
        ClassA a2 = new ClassC();

        a2.m1();
        a2.m2();
        a2.m3();
    }
}
