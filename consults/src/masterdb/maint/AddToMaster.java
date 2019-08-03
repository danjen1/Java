package masterdb.maint;
import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

class AddToMaster
{

    private void dbLoop()
    {
        Connection c;
        File dir = new File("/Users/danieljenkins/Desktop/Consults/Advisor_DBs");
        //File dir = new File("/Users/dan/Projects/Adisor_DBs");
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
                    //PreparedStatement pre = c.prepareStatement("ATTACH DATABASE '/Users/dan/Projects/Master_DB' AS Master");
                    pre.executeUpdate();

                    PreparedStatement prep = c.prepareStatement("INSERT INTO Master.consult (date, caseID, rsrc, reason, relevant, callBack, email, uname, time, comments)" +
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
        System.out.println();
    }
    public static void main (String[]args)
    {
        AddToMaster db = new AddToMaster();
        db.dbLoop();
    }
}
