import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class db {
    public static void connect()
    {
        Connection conn = null;
        try
        {
            // db parameters
            String url = "jdbc:sqlite:/Users/danieljenkins/Projects/Java/T2_Consult/database.sqlite";
            // create a connection to the database
            conn = DriverManager.getConnection(url);

        } catch (SQLException e)
        {
            System.out.println(e.getMessage());
        } finally
        {
            try
            {
                if (conn != null)
                {
                    conn.close();
                }
            } catch (SQLException ex)
            {
                System.out.println(ex.getMessage());
            }
        }
    }
}
