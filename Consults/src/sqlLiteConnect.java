import java.sql.*;

class sqlLiteConnect
{
    public Connection getConnection(String dir)
    {
        Connection c = null;
        try
        {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:" + dir);
            c.setAutoCommit(false);
        } catch (Exception e)
        {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        return c;
    }
}

