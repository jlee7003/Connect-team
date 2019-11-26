package kr.co.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class connect
{
	static String aa = "jdbc:mysql://localhost:3307/connect?useSSL=false";
	static String bb = "root";
	static String cc = "1234";

	public static Connection getConnection() throws SQLException {
		Connection conn = DriverManager.getConnection(aa, bb, cc);

		return conn;
	}

}
