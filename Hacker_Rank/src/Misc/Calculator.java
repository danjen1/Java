package Misc;

public class Calculator {
    public void Calculator() {

    }

    public int add(int a, int b) {
        int answer = a + b;
        return answer;
    }

    public int subtract(int a, int b) {
        int answer = a - b;
        return answer;
    }

    public int multiply(int a, int b) {
        int answer = a * b;
        return answer;
    }

    public int divide(int a, int b) {
        if (b == 0) {
            System.out.println("Error! Dividing by zero is not allowed!");
            return 0;
        } else {
            int answer = a / b;
            return answer;
        }
    }
    public int modulo ( int a, int b){
            if (b == 0) {
                System.out.println("Error! Dividing by zero is not allowed!");
                return 0;
            } else {
                int answer = a % b;
                return answer;
            }
        }
    public static void main(String[] args) {
        Calculator myCalculator = new Calculator();
        System.out.println(myCalculator.add(5, 7));
        System.out.println(myCalculator.subtract(45, 11));
    }
}
