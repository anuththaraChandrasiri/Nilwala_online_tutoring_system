package Util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnectionUtil {
	
	private static Connection connection = null ;

	// This works according to singleton pattern
	private DBConnectionUtil() {
	}

	public static Connection getDBConnection() throws ClassNotFoundException, SQLException {
		
		Class.forName("com.mysql.jdbc.Driver");
		connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/nilwala_online_tutoring", "root", "");
		System.out.println("New db connected!");
		return connection ;
		
	}

}
