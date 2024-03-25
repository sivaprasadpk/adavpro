package BatchProcessing;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Example1
{
	public static void main(String[] args) throws ClassNotFoundException, SQLException 
	{
	Class.forName("oracle.jdbc.driver.OracleDriver");
	Connection connection=DriverManager.getConnection
			("jdbc:oracle:thin:@localhost:1521:xe","rajesh","rajesh");
	Statement statement=connection.createStatement();
	
	statement.addBatch("create table stu(id number,name varchar2(20))");
	
	statement.addBatch("insert into stu values(111,'ratan')");
	statement.addBatch("insert into stu values(112,'siva')");
	statement.addBatch("insert into stu values(113,'bharath')");
	statement.addBatch("insert into stu values(114,'rishi')");
	statement.addBatch("delete from stu where id in(111)");
	statement.addBatch("drop table stu");
	
	int[] res=statement.executeBatch();
	for(int re:res)
		System.out.println(re);
	
	connection.close();

	}

}
