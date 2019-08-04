package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;


public class Database    
{
	
	private static Database db;

	   private Database()   //design pattern singelton//constractor
	   {
		   packageDB();
	   }
	   
	   public static Database getDB()  // נקודת קריאה ראשונית
	   {
		   if(db == null)
		   {
		       db = new Database();
		       InsertDB.insert();
		     
		   }
		   return db;
	    }
	   
	   public static Database status()
	   {
		   return db;
	   }

	   public void packageDB() 
	   {
		   
		    Statement stmt = null;     
		      try {
		         Connection c = ConnectionManager.getInstance();
		         System.out.println("Opened database successfully");
		         stmt = c.createStatement();
		         String query = "CREATE TABLE IF NOT EXISTS tbl" +
		                        "(name         	CHAR(10) , " +
		                        "id		     	CHAR(9), " +
		                        "numpackage      CHAR (10) , " + 
		                        "branch           CHAR(10),"+
		                        "istaken      CHAR(10),"+
		                        "month      CHAR(2),"+
		                        "year      CHAR(4)) ";

		         stmt.executeUpdate(query);
		         stmt.close();
		         System.out.println("closed");
		      } 
		      catch ( Exception e )
		      {
		         System.out.println( e );
		         System.exit(0);
		      }
		      System.out.println("Table created successfully");
	   }
	  
	   
	   }