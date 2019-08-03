package Chapter1;

public class BeerSong
{
    public static void main(String[] args)
    {
        int beerNum = 99;
        String word = "bottles";

        while (beerNum > 0)
        {
            if (beerNum == 1)
            {
                word = "bottle";
            }
            System.out.println(beerNum + " " + word + " of beer on the wall");
            System.out.println(beerNum + " " + word + " of beer");
            System.out.println("take one down");
            System.out.println("pass it around");
            beerNum--;
            if (beerNum > 0)
            {
                if (beerNum == 1)
                {
                    word = "bottle";
                    System.out.println(beerNum + " " + word + " of beer on the wall");
                    System.out.println();
                }
                else
                {
                    System.out.println(beerNum + " " + word + " of beer on the wall");
                    System.out.println();
                }

            }
            else
            {
                System.out.println();
                System.out.println("no more bottles of beer on the wall, you drank them all");
            }

        }
    }
}