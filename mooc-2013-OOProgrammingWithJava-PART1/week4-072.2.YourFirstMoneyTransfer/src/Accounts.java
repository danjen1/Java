
public class Accounts {

    public static void main(String[] args) {
        // Code in Account.Java should not be touched!
        Account first = new Account("Matt's account", 1000.00);
        Account second = new Account("My account", 0.00);
        first.withdrawal(100.00);
        second.deposit(100.00);
        System.out.println(first + "\n" + second);
    }

}
