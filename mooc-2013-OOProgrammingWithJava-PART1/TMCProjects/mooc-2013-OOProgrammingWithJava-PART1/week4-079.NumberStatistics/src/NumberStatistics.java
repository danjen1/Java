
public class NumberStatistics {
    private int amountOfNumbers;
    private int sum;

    public NumberStatistics() {
        amountOfNumbers = 0;
    }

    public void addNumber(int number) {
        this.amountOfNumbers+= 1;
        this.sum += number;
    }

    public int amountOfNumbers() {
        return this.amountOfNumbers;
    }

    public int sum () {
        return this.sum;
    }

    public double average () {
         return (double)(sum) / (double)(amountOfNumbers);
    }
}
