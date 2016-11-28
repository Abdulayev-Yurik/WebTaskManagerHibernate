package taskmanager;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by employee on 11/28/16.
 */
public class Main {
    public static void main(String[] args)
    {
        System.out.println("Checking if Driver is registered with DriverManager");
                //load the driver
        try
        {
            Class.forName("org.postgresql.Driver");
        }
        catch(ClassNotFoundException cnfe)
        {
            System.err.println(cnfe);
            System.out.println("Let's print a stack trace, and exit.");
            cnfe.printStackTrace();
            System.exit(1);
        }
        System.out.println("Registered the driver ok, making DB " +
                "connection now\n");
                Connection dbConn = null;
        try
        {
            dbConn =
                    DriverManager.getConnection("jdbc:postgresql://ec2-54-228-213-46.eu-west-1.compute.amazonaws.com:5432/ddrf0jp1nipo3i?sslmode=require"
                            ,"ghsnsszchyrwfi","gytAtNevQlIjLGgOCRD03XNUoJ");
        }
        catch(SQLException sqle)
        {
            System.out.println("Couldn't connect: print out a stack trace and exit.");
                    sqle.printStackTrace();
            System.exit(1);
        }

        if(dbConn != null)
            System.out.println("Hooray! We connected to the database!");
        else
            System.out.println("We should never get here.");
    }
}
