package productProject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class ProductDao 
{
	public int createProductTable()
	{
		int count=0;
		Connection connection=null;
		Statement   statement=null;
		try
		{
			connection=DBConnection.createconnection();
			statement=connection.createStatement();
			String q="create table pro(proId number(5),proName varcher2(20),proPrice number)";
			count=statement.executeUpdate(q);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
				if(connection!=null)
					try {
						connection.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
		}
		return count;
		
	}
}
