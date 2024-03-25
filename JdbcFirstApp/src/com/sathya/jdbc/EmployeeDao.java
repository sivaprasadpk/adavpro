package com.sathya.jdbc;
import java.util.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class EmployeeDao 
{
	public int save(Employee emp) 
	{
		Connection connection=null;
		PreparedStatement preparedstatement=null;
		int count=0;
		try
		{
			connection=DbConnection.CreateConnection();
			preparedstatement=connection.prepareStatement("insert into emp values(?,?,?)");
			
			preparedstatement.setInt(1, emp.getEmpId());
			preparedstatement.setString(2, emp.getEmpName());
			preparedstatement.setDouble(3, emp.getEMPSALARY());
			
			count=preparedstatement.executeUpdate();
			
		}
		catch(SQLException e)
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
			if(preparedstatement!=null)
				try {
					preparedstatement.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
		return count;
	}
	public Employee findByAll(int EmpId)
	{
		Employee employee=null;
		try(Connection connection=DbConnection.CreateConnection();
			PreparedStatement preparedStatement=connection.prepareStatement
					("select * from emp where empid=?"))
		{
			preparedStatement.setInt(1, EmpId);
			
		ResultSet resultSet=preparedStatement.executeQuery();
		if(resultSet.next())
		{
			employee=new Employee();
			employee.setEmpId(resultSet.getInt(1));
			employee.setEmpName(resultSet.getString(2));
			employee.setEMPSALARY(resultSet.getDouble(3));
			
		}
		} catch (SQLException e)
		{
			e.printStackTrace();
		}
		return employee;
		
	}
	
	public int deleteById(int EmpId)
	{
		int count =0;
		
		try(Connection connection =DbConnection.CreateConnection();
			PreparedStatement preparedStatement=connection.prepareStatement("delete from emp where empid=?"))
		{
			preparedStatement.setInt(1, EmpId);
			count = preparedStatement.executeUpdate();
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return count;	
	}
	public int deleteBySalary(double EMPSALARY)
	{
		int count=0;
		try(Connection connection=DbConnection.CreateConnection();
			PreparedStatement preparedStatement=connection.prepareStatement
			("delete from emp where empsalary<?"))
		{
			preparedStatement.setDouble(1,EMPSALARY);
			
			count=preparedStatement.executeUpdate();
		} 
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		return count;
		
	}
	public List<Employee> findAll()
	{
		List <Employee> emps=new  ArrayList();
		try(Connection connection=DbConnection.CreateConnection();
			Statement statement=connection.createStatement())
		{
			ResultSet resultSet=statement.executeQuery("select * from emp");
			while(resultSet.next())
			{
				Employee employee=new Employee();
				employee.setEmpId(resultSet.getInt(1));
				employee.setEmpName(resultSet.getString(2));
				employee.setEMPSALARY(resultSet.getDouble(3));
				
				emps.add(employee);
			}
		} catch (SQLException e)
		{
			e.printStackTrace();
		}
		
		return emps;
	}
	public int updateSalary(double currentsalary,double incsalary)
	{
		int count=0;
		try(Connection connection=DbConnection.CreateConnection();
			PreparedStatement preparedStatement=
					connection.prepareStatement("update emp set EMPSALARY=EMPSALARY + ? where EMPSALARY > ? "))
		{
			preparedStatement.setDouble(1, incsalary);
			preparedStatement.setDouble(2, currentsalary);
			
			count = preparedStatement.executeUpdate();
			
		} 
		catch (SQLException e) {
		
			e.printStackTrace();
		}
		return count;
		
	}
}

	


