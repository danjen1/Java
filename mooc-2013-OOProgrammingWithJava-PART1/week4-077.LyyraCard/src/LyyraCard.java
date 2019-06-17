/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author dan
 */
public class LyyraCard {
    private double balance;
    
    public LyyraCard(double balanceAtStart){
        this.balance = balanceAtStart;
    }
    
    @Override
    public String toString(){
         String a = "The card has " + balance + " euros";
         return a;
    }
    
    public void payEconomical() {
        if (balance >= 2.50) {
            balance -= 2.50;
        }
}

public void payGourmet() {
        if (balance >= 4) {
            balance -= 4;
        }
}

public void loadMoney(double amount) {
    if (amount < 0){
        
    }else if (balance + amount < 150) {
        balance += amount;
    }else{
    balance = 150;
}
}
}
