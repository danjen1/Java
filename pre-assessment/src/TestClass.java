class Base{
    public Object getValue(){ return new Object(); } //1
}

class Base2 extends Base{
    public String getValue(){ return "hello"; } //2
}

public class TestClass{
    public static void main(String[] args){
        Base b = new Base2();
        System.out.println(b.getValue()); //3

        int i = 1;
        int j = ++i;
        if( (i==++j) | (++ i== j) ){
            System.out.println(j);
            i+=j; //i = 1 + i (1) + j (3) = 5
        }
        System.out.println(i);
        boolean greenLight = true;
        boolean pedestrian = false;
        boolean rightTurn = true;
        boolean otherLane = false;

        if (( (rightTurn && !pedestrian || otherLane) || (otherLane && !pedestrian && greenLight ) )== true ){
            System.out.println(true);
        }




    }
}