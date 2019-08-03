package Chapter5;

public class SimpleDotComTestDrive
{
    public static void main(String[] args)
    {
        int numOfGuess = 0;

        SimpleDotCom theDotcom = new SimpleDotCom();
        GameHelper helper = new GameHelper();
        int randomNum = (int)(Math.random() * 5);
        int[] locations = {randomNum, randomNum+1, randomNum+2};
        theDotcom.setLocationCells(locations);
        boolean isAlive = true;

        while (isAlive == true)
        {
            String result = theDotcom.checkYourself(helper.getUserInput("Enter your Guess Here:"));
            numOfGuess++;
            if (result.equals("kill"))
            {
                isAlive = false;
                System.out.println();
                System.out.println("You took " + numOfGuess + " guesses");
            }
        }
    }
}


