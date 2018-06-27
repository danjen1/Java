public class CarLoan {
    public static void main(String[] args) {
        int carLoan = 17000;
        int loanLength = 6;
        int interestRate = 5;
        int downPayment = 0;

        if(loanLength <=0||interestRate <=0){
            System.out.println("Error! You must take out a valid car loan!");
        } else if (downPayment >= carLoan) {
            System.out.println("The car can be paid in full");
        } else {
            int remainnigBalance = carLoan - downPayment;
            int months = loanLength * 12;
            int monthlyBalance = remainnigBalance / months;
            int interest = monthlyBalance * interestRate / 100;
            int monthlyPayment = monthlyBalance + interest;
            System.out.println(monthlyPayment);
        }

    }
}

