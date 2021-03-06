package Chapter15;
import java.io.*;
import java.net.*;
public class DailyAdviceServer
{
    String[] adviceList = {"Take smaller bites", "Go for the tight jeans no the do not make you look fat", "One word: inappropriate",
            "Just for today be honest, tell your boss what you *really* think", "You might want to rethink that haircult"};
    public void go()
    {
        try
        {
            ServerSocket serverSock = new ServerSocket(4242);

            while (true)
            {
                Socket socket = serverSock.accept();

                PrintWriter writer = new PrintWriter(socket.getOutputStream());
                writer.println(getAdvice());
                writer.close();
            }
        } catch (IOException ex)
        {
            ex.printStackTrace();
        }
    }

    private String getAdvice()
    {
        int random = (int) Math.random() * adviceList.length;
        return adviceList[random];
    }

    public static void main(String[] args)
    {
        DailyAdviceServer server = new DailyAdviceServer();
        server.go();
    }
}
