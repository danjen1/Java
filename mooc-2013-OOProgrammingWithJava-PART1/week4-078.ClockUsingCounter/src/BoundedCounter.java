/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author daniel
 */
public class BoundedCounter {
    private int value = 0;
    private int upperLimit;

    public BoundedCounter(int upperLimit) {
        this.upperLimit = upperLimit;
       
    }

    public void next() {
        if (value < upperLimit){
            value += 1;
        }else {
            value = 0;
        }
    }

    public String toString() {
         String st;
        
        if (value < 10){
            st = "0";
        } else {
            st = "";
        }
        return st + value; 
    }
    
    public int getValue() {
    return this.value;
}
    
    public void setValue(int value) {
       if (value > 0 && value <= upperLimit){
           this.value = value;
       } 
    }

}
    