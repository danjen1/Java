package Chapter2;

public class GuessGame
{
    static int target = (int)(Math.random() * 10);
    static boolean gameOver = false;

    public void runGame()
    {
        System.out.println("The number to guess is " + target);
        System.out.println();
        Player P1 = new Player();
        Player P2 = new Player();
        Player P3 = new Player();

        while (gameOver == false)
        {
            P1.guess();
            P2.guess();
            P3.guess();
            if (gameOver == false)
            {
                System.out.println("Nobody guessed right, Guess AGAIN!");
            }
            System.out.println();
            }
            System.out.println("We have a winner!");
            if (P1.isRight && P2.isRight && P3.isRight)
            {
            System.out.println("We have a three way tie! All 3 players guessed right!");
            System.out.println();
            } else if (P1.isRight && P2.isRight)
        {
            System.out.print("Player 1 & Player 2 guessed right!\n");
        } else if (P2.isRight && P3.isRight)
        {
            System.out.println("Player 2 & Player 3 guessed right\n");
        } else if (P3.isRight && P1.isRight)
        {
            System.out.println("Player 1 & Player 3 guessed right\n");
        }
        else if (P1.isRight)
        {
            System.out.println("Player 1 guessed right\n");
        } else if (P2.isRight)
        {
            System.out.println("Player 2 guessed right\n");
        }
        else
        {
            System.out.println("Player 3 guessed right\n");
        }
        System.out.println("Game Over");
    }

    public static void main(String[] args)
    {
        GuessGame one = new GuessGame();
        one.runGame();
    }
}
