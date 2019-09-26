import java.util.Random;
 
public class NightSky {
 
    private double density;
    private int width;
    private int height;
    private int starsInLastPrint;
 
    public NightSky(double density) {
        this(density, 20, 10);
    }
 
    public NightSky(int width, int height) {
        this(0.1, width, height);
    }
 
    public NightSky(double density, int width, int height) {
        this.density = density;
        this.width = width;
        this.height = height;
    }
 
    public void print() {
        this.starsInLastPrint = 0;
 
        for (int y = 0; y < this.height; y++) {
            printLine();
        }
    }
 
    public void printLine() {
        Random random = new Random();
 
        for (int x = 0; x < this.width; x++) {
            double randomValue = random.nextDouble();
 
            if (randomValue > this.density) {
                System.out.print(" ");
            } else {
                System.out.print("*");
                this.starsInLastPrint++;
            }
        }
 
        System.out.println("");
    }
 
    public int starsInLastPrint() {
        return starsInLastPrint;
    }
}
 