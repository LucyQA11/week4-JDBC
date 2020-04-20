package sqlConnect.qa.com;

import java.sql.*;


public class Database {
	
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
//    public String create(String Table, int id, String Name, String Address, int Age) {
//    	String sql = "INSERT INTO " +Table+ " VALUES ("+id+",'"+Name+"','"+Address+"',"+Age+")";
//    	try {
//			stmt.executeUpdate(sql);
//			System.out.println("Record Inserted");
//
//			
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return sql;
//    	
//    	
//    }
}
