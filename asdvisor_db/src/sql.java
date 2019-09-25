import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class sql {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        // creates three different Connection objects

        Connection conn1 = null;
        Connection conn2 = null;
        Connection conn3 = null;

        try {

            // connect way #1
            String url1 = "jdbc:mysql://localhost/DB_Test?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC" ;
            String user = "root" ;
            String password = "gMake201%" ;


            conn1 = DriverManager.getConnection(url1, user, password);
            if (conn1 != null) {
                System.out.println("Connected to the database DB_Test");
            }
        } catch (SQLException ex) {
            System.out.println("An error occurred. Maybe user/password is invalid");
            ex.printStackTrace();
        }

    }
}