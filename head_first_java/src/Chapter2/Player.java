package Chapter2;

public class Player
{
    private static int playNum =1;
    private String name = "Player " + playNum;
    boolean isRight = false;

    public Player()
    {
        playNum++;
    }

    public void guess()
    {
        int number = (int) (Math.random() * 10);
        System.out.println(name + " is guessing " + number);
        if (number == GuessGame.target)
        {
            isRight = true;
            GuessGame.gameOver = true;
        }
    }
}
