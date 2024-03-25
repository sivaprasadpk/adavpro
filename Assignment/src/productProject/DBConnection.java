package productProject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection 
{
	public static Connection createconnection()
	{
		Connection connection=null;
		try
		{
		Class.forName("oracle.jdbc.driver.OrcaleDriver");
		 connection=DriverManager
		.getConnection("jdbc:oracle:thin:@localhost:1521:xe","rajesh","rajesh");
		}
		catch (ClassNotFoundException | SQLException e) 
		{
			e.printStackTrace();
		}
		return connection;
	}
}
