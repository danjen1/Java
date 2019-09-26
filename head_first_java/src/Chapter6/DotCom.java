package Chapter6;
import java.util.*;

public class DotCom
{
    public String name;
    private ArrayList<String> locationCells;


    public void setLocationCells(ArrayList<String> locs)
    {
        locationCells = locs;
    }

    public void setName(String name)
    {
        this.name = name;
    }


    public String checkYourself(String userInput)
    {
        String result = "miss";
        int index = locationCells.indexOf((userInput)); //if input isn't in the ArrayList of Strings then it returns -1

        if (index >= 0)
        {
            locationCells.remove(index);

            if (locationCells.isEmpty())
            {
                result = "kill";
                System.out.println("Ouch! you sunk " + name + " : ( ");
            }else
            {
                result = "hit";
            }
        }
        return result;
    }
}