package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class ConnectionManager {
	public static Connection c = null;
    private static void connect() throws ClassNotFoundException 
    { 
    	try {
    		Class.forName("org.sqlite.JDBC");
    		c = DriverManager.getConnection("jdbc:sqlite:C:mailDliver");
    		c.setAutoCommit(false);
    		Database.getDB();
    		//c.close();
    	}
    	catch(SQLException e) {
				e.printStackTrace();
    	}
    } 
  
    public static Connection getInstance() throws ClassNotFoundException, SQLException 
    { 
        if (c == null || c.isClosed()) {
        	connect();
        }
        return c; 
    }
    
    
    
} 
