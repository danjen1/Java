package Chapter15;


public class RyanAndMonicaJob implements Runnable
{
    private BankAccount account = new BankAccount();

    public static void main(String[] args)
    {
        RyanAndMonicaJob theJob = new RyanAndMonicaJob();
        Thread one = new Thread(theJob);
        Thread two = new Thread(theJob);
        one.setName("Ryan");
        two.setName("Moncia");
        one.start();
        two.start();
    }

    public void run()
    {
        for (int i = 0; i < 10; i++)
        {
            makeWithdrawal(10);

            if (account.getBalance() < 0)
            {
                System.out.println("Overdrawn");
            }
        }
    }

    private synchronized void makeWithdrawal(int amt)
    {
        if (account.getBalance() >= 0)
        {
            System.out.println(Thread.currentThread().getName() + " is about to withdraw");
            try
            {
                System.out.println(Thread.currentThread().getName() + " is going to sleep");
                Thread.sleep(500);
            } catch (InterruptedException ex)
            {
                ex.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " woke up");
            account.withdraw(amt);
            System.out.println(Thread.currentThread().getName() + " completes withdrawal");
        } else
        {
            System.out.println("Sorry not enough for " + Thread.currentThread().getName());

        }
    }
}
