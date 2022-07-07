package db_Demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class RetrieveInfoFromDB {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		//jdbc:mysql://hostname:3306/hibernatedb?autoReconnect=true&useSSL=false
		String dbUrl= "jdbc:mysql://localhost:3306/Amazon?autoReconnect=true&useSSL=false";
		String username = "root";
		String password = "admin";
		String query = "Select * from Products;"; //the sql query to fetch table records
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection(dbUrl,username,password);
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery(query);
		
		while(rs.next()) {
			System.out.print("Brand:" + rs.getString("Brand") + "\t");
			System.out.print("Model:" + rs.getString("Model") + "\t");
			System.out.print("Price:" + rs.getString("Price") + "\t");
			System.out.println();
		}
	}

}
