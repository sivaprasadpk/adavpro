package Transaction;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Example1 {

	public static void main(String[] args) throws SQLException 
	{
		Connection connection=null;
		Statement statement=null;
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			connection=DriverManager.getConnection
					("jdbc:oracle:thin:@localhost:1521:xe","rajesh","rajesh");
			
			statement=connection.createStatement();
//			connection.setAutoCommit(false);
//			statement.executeUpdate("insert into emp values(1003,'sachin',116)");
//			statement.executeUpdate("insert into emp values(1004,'rishi',118)");
			statement.executeUpdate("insert into emp values(1005,'jeshwin',120)");
//			statement.executeUpdate("delete from emp where empid=1005");
			connection.commit();
			System.out.println("Transsaction successfull");

		}
		catch(ClassNotFoundException | SQLException e)
		{
			connection.rollback();
			e.printStackTrace();
			System.out.println("Transaction fail");
			
		}
		finally
		{
			if(connection!=null)
				connection.close();
			if(statement!=null)
				statement.close();
		}

	}

}
