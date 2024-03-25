package productProject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Example
{

	public static void main(String[] args) throws ClassNotFoundException, SQLException 
	{
		Class.forName("oracle.jdbc.driver.OrcaleDriver");
		System.out.println("driver load succesfull");
		
		Connection connection=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","rajesh","rajesh");
		System.out.println("connection created successfully");
		
		connection.close();
		System.out.println("connection close successfull");

	}

}
