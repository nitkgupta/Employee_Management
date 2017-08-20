package connection;

import java.sql.Connection;
import java.sql.DriverManager;

public class MyConnection {
	private static Connection con;
	static {
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","981120");
		}
		catch(Exception e)
		{
			System.out.println("Error..."+e);
		}
	}
	public static Connection getConnection() {
		return con;
	}

}
