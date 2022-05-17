package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {
	static Connection conn;
	static {
		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// static method to create one single connection..and return same single connection all the time.
	static Connection makeconnection() throws SQLException {
		String connectionUrl = "jdbc:postgresql://localhost:5432/postgres";
		String userName = "postgres";
		String password = "$Argent1980";
		if (conn == null) {
			conn = DriverManager.getConnection(connectionUrl, userName, password);
		}
		return conn;

	}

}



