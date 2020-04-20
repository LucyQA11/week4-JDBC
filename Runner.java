package sqlConnect.qa.com;

import java.sql.*;


public class Runner {
	
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost:3306/game?useSSL=false";
	static final String USER = "root";
	static final String PASS = "C0mmunic@t10n";
	
	public static void main(String[] args) {
		Connection conn= null;
		Statement stmt = null;
		int id = 5;
		String name ="'Customer3'";
		String address ="'89A Windmere Rd'";
		String tableName ="Customers";
		int age =34;
		
	
		
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Starting connection to db");
		
		try {
			conn = DriverManager.getConnection(DB_URL,USER,PASS);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Connected!");
		
		
		
		System.out.println("Starting insert statement");
		try {
			stmt = conn.createStatement();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	
		String sqlInsert= "INSERT INTO " +tableName+ " VALUES ("+id+","+name+","+address+","+age+")";
		try {
			stmt.executeUpdate(sqlInsert);
			System.out.println("Record Inserted");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("Creating select statement");
		try {
			stmt = conn.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String sql2 = "Select id,name,address from "+tableName;
		ResultSet rs =null;
		try {
			rs =stmt.executeQuery(sql2);
//			System.out.println("what does RS print?" +rs);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			while (rs.next()) {
				int id1= rs.getInt("id");
				String name1 =rs.getString("name");
				String address1 =rs.getString("address");
				System.out.println("ID: "+id1+" Name: "+name1+" Address: "+address1);
				}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Update statement");
		try {
			stmt =conn.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		String sql3 ="update "+tableName+ "set age = 30 where id=1;";
//		try {
//			stmt.executeUpdate(sql3);
//			System.out.println("Record has been updated");
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			
//			e.printStackTrace();
//		}
		System.out.println("Delete record");
		try {
			stmt =conn.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String sql4="Delete From Customers WHERE id=3";
		try {
			stmt.executeUpdate(sql4);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	
	}
}

