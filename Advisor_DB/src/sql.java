import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class sql {
    public static void main(String[] args) {

        // creates three different Connection objects
        Connection conn1 = null;
        Connection conn2 = null;
        Connection conn3 = null;

        try {
            // connect way #1
            String url1 = "jdbc:mysql://localhost:3306/DB_Test?useSSL=false";
            String user = "root";
            String password = "Ghi456jkl!";

            conn1 = DriverManager.getConnection(url1, user, password);
            if (conn1 != null) {
                System.out.println("Connected to the database DB_Test1");
            }

            // connect way #3
            String url3 = "jdbc:mysql://localhost:3306/DB_Test?useSSL=false";
            Properties info = new Properties();
            info.put("user", "root");
            info.put("password", "Ghi456jkl!");

            conn3 = DriverManager.getConnection(url3, info);
            if (conn3 != null) {
                System.out.println("Connected to the database DB_Test3");
            }
        } catch (SQLException ex) {
            System.out.println("An error occurred. Maybe user/password is invalid");
            ex.printStackTrace();
        }
    }
}