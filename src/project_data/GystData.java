package project_data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class GystData {
	Connection connection;
	Statement statement;
	
	public GystData() {
		//Bring in the driver
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		
		//Establish a connection 
				try {
					connection = DriverManager.getConnection
							("jdbc:mysql://localhost:3306/mydb", "root", "root");
					System.out.println("Database connected!");
				} catch (SQLException ex) {
					ex.printStackTrace();
				}
		//Create the statement object
				try {
					statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
					System.out.println("Statement object created!");
				} catch (SQLException ex) {
					ex.printStackTrace();
				}
	}
	
	public void close() {
		try {
			connection.close();
			System.out.println("Database closed!");
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}
}
