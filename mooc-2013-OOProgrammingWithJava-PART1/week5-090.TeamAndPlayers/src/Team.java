
import java.util.ArrayList;

public class Team {

    private String name;
    private ArrayList<Player> list;
    private int size;

    public Team(String name) {
        this.name = name;
        this.list = new ArrayList<Player>();
        this.size = 16;
    }

    public String getName() {
        return this.name;
    }

    public void addPlayer(Player player) {
        if (this.size() >= this.size) {
            return;
        }
        this.list.add(player);
    }

    public void printPlayers() {
        for (Player player : this.list) {
            System.out.println(player);
        }
    }

    public void setMaxSize(int maxSize) {
        this.size = maxSize;
    }

    public int size() {
        return this.list.size();
    }

    public int goals() {
        int total = 0;
        for (Player player : list) {
            total += player.goals();
        }
        return total;
    }
}
