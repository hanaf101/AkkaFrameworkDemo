package demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


public class PostgreSQLJDBC {
    public static void main( String args[] )
    {
        Connection c = null;
        Statement stmt = null,stm1=null;
        try {
            Class.forName("org.postgresql.Driver");
            c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/stock_data", "hanaf", "root");
            c.setAutoCommit(false);
            System.out.println("Opened database successfully");
            stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery( "SELECT * FROM stock_sources;" );
            while ( rs.next() ) {
                String address = rs.getString("url");
                ;
                String name = rs.getString("name");
                String shortname = rs.getString("shortname");
                String id = rs.getString("id");
                System.out.println("ID = " + id);
                System.out.println("NAME = " + name);
                System.out.println("short = " + shortname);
                System.out.println("url = " + address);


            }
            rs.close();
            stmt.close();
            c.close();
        } catch ( Exception e ) {
            System.err.println( e.getClass().getName()+": "+ e.getMessage() );
            System.exit(0);
        }
        System.out.println("Operation done successfully");
    }
}