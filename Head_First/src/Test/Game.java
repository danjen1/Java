package Test;
import Chapter6.GameHelper;
import java.util.*;

public class Game
{
    private ArrayList<Ship> gameBoard = new ArrayList<Ship>();
    private int numGuess = 0;
    GameHelper helper = new GameHelper();

    public void setupGame()
    {
        Ship one = new Ship(helper.getUserInput("Enter name of Ship1: "));
        Ship two = new Ship(helper.getUserInput("Enter name of Ship2: "));
        Ship three = new Ship(helper.getUserInput("Enter name of Ship3: "));

        gameBoard.add(one);
        gameBoard.add(two);
        gameBoard.add(three);

        System.out.println("Submit your guess in coordinate A-N 1-10 example: A7");

        for (Ship docked : gameBoard)
        {
            ArrayList<String> newLoc = helper.placeShip(3);
            docked.setShipCoords(newLoc);
        }
    }

    public void startGame()
    {
        while (!gameBoard.isEmpty())
        {
            checkGuess(helper.getUserInput("Enter your guess: "));
        }
        finishGame();
    }

    public void checkGuess(String input)
    {
        numGuess++;
        for (Ship docked : gameBoard)
        {
            String result = docked.checkShipCoords(input);
            if (result.equals("kill"))
            {
                gameBoard.remove(docked);
                if (gameBoard.isEmpty())
                {
                    break;
                }
                break;

            }
        }
    }

    public void finishGame()
    {
        System.out.println("It took you " + numGuess + "  guesses.");
    }

    public static void main(String[] args)
    {
        Game one = new Game();
        one.setupGame();
        one.startGame();
    }
}
