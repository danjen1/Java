package Chapter15;

class BankAccount
{
    private int balance = 5000;

    public int getBalance()
    {
        return balance;
    }

    public void withdraw(int amt)
    {
        balance -= amt;
    }
}
