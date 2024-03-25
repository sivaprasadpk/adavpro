package ProcedureExamples;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.SQLType;
import java.sql.Types;

public class ProcedureExample1
{
	public static void main(String[] args) throws ClassNotFoundException, SQLException
	{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection connection=DriverManager.getConnection
							("jdbc:oracle:thin:@localhost:1521:xe","rajesh","rajesh");
		
		CallableStatement callableStatement=connection.prepareCall("{call getEmp(?,?,?,?)}");
		
		callableStatement.setInt(1, 1001);
		
		callableStatement.registerOutParameter(2,Types.INTEGER);
		callableStatement.registerOutParameter(3, Types.VARCHAR);
		callableStatement.registerOutParameter(4, Types.FLOAT);
		callableStatement.executeUpdate();
		
		System.out.println(callableStatement.getInt(2));
		System.out.println(callableStatement.getString(3));
		System.out.println(callableStatement.getFloat(4));
		
		connection.close();


	}

}