 
public class NumberStatistics {
    private int amountOfNumbers;
    private int sum;
 
    public NumberStatistics() {
       
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
        if (this.amountOfNumbers == 0){
            return 0.0;
        } else {
            return (double)(sum) / (double)(amountOfNumbers);   
          }
        }
    }
 