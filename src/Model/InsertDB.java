package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;

public class InsertDB 
{
   public static void insert()
   {
      Statement stmt = null;
      String query;
      
      try {
    	 Connection c = ConnectionManager.getInstance();		
         stmt = c.createStatement();
         Client client;
         Integer[] ids= {369852147,963258741,912345608,912345678,369852147,789123456,678912345,369852147,567891234,456789123,345678912,369852147};
         String[] names= {"noam","aviv","yakov","ariel","noam","idan","tomer","noam","piper","alex","juli","noam"};
         String[] pacNum= {"12","52","63","54","85","96","32","51","47","85","36","58","14","22","31"};
         for (int i=0;i<12;i++)
         {
        	 client= new Client(names[i],ids[i]);
        	 Client.getClientList().add(client);
        	 client.create_new_parcel(pacNum[i], false, "tel-aviv");
        	 query="INSERT INTO tbl (name,id,numpackage,branch,istaken,month,year) " +
						"VALUES (?, ?, ?, ?, ?, ?, ?)";
 			Date date = new Date();
 			LocalDate localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
 			int month = localDate.getMonthValue();
 			int year=localDate.getYear();
 			String monthstr = "" + month;
 			String yearstr = "" + year;
        	PreparedStatement pst = c.prepareStatement(query);
 			pst.setString(1, names[i]);
 			pst.setString(2, ids[i].toString());
 			pst.setString(3, pacNum[i]);
 			pst.setString(4, "tel-aviv");
 			pst.setString(5, "No");
 			pst.setString(6, monthstr);
 			pst.setString(7, yearstr);
 			pst.execute();
         }
         stmt.close();
         c.commit();
         c.close();
      } 
      catch ( Exception e ) 
      {
         System.err.println( e.getClass().getName() + ": " + e.getMessage() );
         System.exit(0);
      }
      System.out.println("Records created successfully");
   }
}