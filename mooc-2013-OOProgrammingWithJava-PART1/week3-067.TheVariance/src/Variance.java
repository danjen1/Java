import java.util.ArrayList;
 
public class Variance {
    // Copy here sum from exercise 63 
    public static int sum(ArrayList<Integer> list) {
        int sum = 0;    
        for (int index : list){
                sum += index;
            }
        return sum;
    }
    
    // Copy here average from exercise 64 
    public static double average(ArrayList<Integer> list) {
        double sum = (double) sum(list);
       
        return sum / list.size();
    }
 
    public static double variance(ArrayList<Integer> list) {
        double variance = 0;
        double average = average(list);
 
        for (int num : list) {
            variance += Math.pow(num - average, 2);
        }
        
        variance /= (list.size() - 1);
        
        return variance;
    }
    
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(3);
        list.add(2);
        list.add(7);
        list.add(2);
        
        System.out.println("The variance is: " + variance(list));
    }
 
}