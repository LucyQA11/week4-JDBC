package sqlConnect.qa.com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Random {
	
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost:3306/game?useSSL=false";
	static final String USER = "root";
	static final String PASS = "C0mmunic@t10n";
	
    public Connection conn = null;
    public Statement stmt = null;
	
	  public void DB() {
	        try {
	            Class.forName(JDBC_DRIVER);
	        } catch (ClassNotFoundException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        }
	        try {
	            conn = DriverManager.getConnection(DB_URL,USER,PASS);
	            System.out.println("Database connected");
	        } catch (SQLException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        }
	        try {
	            stmt = conn.createStatement();
	        } catch (SQLException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        }
	    }
	  
	  public void viewDB(String table) {

	        String sql = "SELECT * FROM "+table;
	        ResultSet rs = null;
	        try {
	            rs = stmt.executeQuery(sql);
	        } catch (SQLException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        }
	        try {
	            while(rs.next()) {
	                int id = rs.getInt("id");
	                String name = rs.getString("name");
	                System.out.println("ID: "+id+" Name: "+name);
	            }
	        } catch (SQLException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        }
	        
	        
	    }
	  public String create(String Table, int id, String Name, String Address, int Age) {
	    	String sql = "INSERT INTO " +Table+ " VALUES ("+id+",'"+Name+"','"+Address+"',"+Age+")";
	    	try {
				stmt.executeUpdate(sql);
				System.out.println("Record Inserted");
	
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return sql;
	  }
	  public String update(String Table, int id, String Address) {
		  String sql2 ="UPDATE "+Table+ " SET address = '" +Address+ "' WHERE id = "+id;
		  try {
				stmt.executeUpdate(sql2);
				System.out.println("Record updated");
	
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return sql2;
		  
	  }
	  
	  public void deleteCustomer(String table, int id) {
	        String sql = "DELETE FROM " + table + " WHERE id=" + id;

	 

	        try {
	            stmt.executeUpdate(sql);
	            System.out.println("Deleted record " + id + " from " + table);
	        } catch (SQLException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	            System.out.println("Error deleting record, check that " + id + " exists in table " + table);
	        }
	    }
}

	    	
	    	
	    
	  
	
	  




