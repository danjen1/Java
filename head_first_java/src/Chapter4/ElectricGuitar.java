package Chapter4;

public class ElectricGuitar
{
    String brand;
    int numOfPickups;
    boolean rockStarUses;

    String getBrand()
    {
        return brand;
    }
    void setBrand(String aBrand)
    {
        brand = aBrand;
    }
    int getNumOfPickups()
    {
        return numOfPickups;
    }
    void setNumOfPickups(int num)
    {
        numOfPickups = num;
    }
    boolean getRockStarUsesIt()
    {
        return rockStarUses;
    }
    void setRockStarUses(boolean yesOrNo)
    {
        rockStarUses = yesOrNo;
    }
}
