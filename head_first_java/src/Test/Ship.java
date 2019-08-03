package Test;
import Chapter6.GameHelper;

import java.util.*;


public class Ship
{
    private ArrayList<String> shipCoords = new ArrayList<String>();
    private String name;


    public Ship(String name)
    {
        setName(name);
    }

    public void setShipCoords(ArrayList<String> loc)
    {
        this.shipCoords = loc;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String checkShipCoords(String input)
    {
        String result = "miss";
        int index = shipCoords.indexOf(input);

        if (index >= 0)
        {
            shipCoords.remove(input);
            if (shipCoords.isEmpty())
            {
                result = "kill";
                System.out.println("You destroyed ship " + name + "!");
            } else
            {
                result = "hit";
            }
            System.out.println(result);
        }
        return result;
    }
}
