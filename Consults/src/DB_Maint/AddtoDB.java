package DB_Maint;
        import java.io.File;
        import java.sql.Connection;
        import java.sql.DriverManager;
        import java.sql.PreparedStatement;
        import java.sql.Statement;

public class AddtoDB
{

    public void dbLoop()
    {
        int dbNum = 0;
        Connection c;
        Statement stmt;
        String caseID;
        String kBase;
        Boolean yKbase;
        Boolean ycallBack;
        Boolean ycontactEmail;
        String comments;
        Boolean validConsult;
        String invalidReason;

        File dir = new File("/Users/danieljenkins/Desktop/Consults/Advisor_DBs");
        File[] directoryListing = dir.listFiles();
        for (File child : directoryListing)
        {
            if (!child.isHidden())
            {
                System.out.println(child);

                try
                {
                    Class.forName("org.sqlite.JDBC");
                    c = DriverManager.getConnection("jdbc:sqlite:" + child);
                    c.setAutoCommit(false);

                PreparedStatement pre = c.prepareStatement("ATTACH DATABASE '/Users/danieljenkins/Desktop/Consults/Master_DB' AS Master");
                pre.executeUpdate();

                PreparedStatement prep = c.prepareStatement("INSERT INTO Master.consult (date, caseID, Kbase, correctKbase, callback, contactEmail, validConsult, invalidReason,uname, time, comments)" +
                        "SELECT * FROM main.consult");
                prep.executeUpdate();

                prep.close();
                c.commit();
                c.close();
                } catch (Exception e)
                {
                    System.err.println(e.getClass().getName() + ": " + e.getMessage());
                    System.exit(0);
                }
            }
        }
        System.out.println("");
    }

        public static void main (String[]args)
        {
            AddtoDB db = new AddtoDB();
            db.dbLoop();
        }
    }
