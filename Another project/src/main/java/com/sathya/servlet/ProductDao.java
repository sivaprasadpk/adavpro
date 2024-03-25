package com.sathya.servlet;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class ProductDao 
{
	public int save(Product product)
	{
		int count=0;
		Connection connection=null;
		PreparedStatement preparedStatement=null;
		try
		{
			connection=DbConnection.CreateConnection();
			preparedStatement=connection.
			prepareStatement("insert into prod_data values(?,?,?,?,?,?,?,?,?,?)");
			
			preparedStatement.setString(1, product.getProId());
			preparedStatement.setString(2,product.getProName());
			preparedStatement.setDouble(3, product.getProPrice());
			preparedStatement.setString(4, product.getProBrand());
			preparedStatement.setString(5, product.getProMadein());
			preparedStatement.setDate(6, product.getProMfgDate());
			preparedStatement.setDate(7, product.getProExpDate());
			preparedStatement.setBytes(8, product.getProImage());
			preparedStatement.setBytes(9, product.getProAudio());
			preparedStatement.setBytes(10,product.getProVideo());
			
			count=preparedStatement.executeUpdate();
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{
				if(preparedStatement!=null)
					preparedStatement.close();
				if(connection!=null)
					connection.close();
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
	
		return count;
	}
	
	public List<Product> findAll()
	{
		List<Product> product=new ArrayList<Product>();
		
		//using try with resources because of resource will be closed automatically
		try(Connection connection=DbConnection.CreateConnection();
			Statement statement=connection.createStatement())
		{
			ResultSet resultSet=statement.executeQuery("select * from prod_data");
			while(resultSet.next())
			{
				Product pro=new Product();
				pro.setProId(resultSet.getString(1));
				pro.setProName(resultSet.getString(2));
				pro.setProPrice(resultSet.getDouble(3));
				pro.setProBrand(resultSet.getString(4));
				pro.setProMadein(resultSet.getString(5));
				pro.setProMfgDate(resultSet.getDate(6));
				pro.setProExpDate(resultSet.getDate(7));
				pro.setProImage(resultSet.getBytes(8));
				pro.setProAudio(resultSet.getBytes(9));
				pro.setProVideo(resultSet.getBytes(10));
				
				
				product.add(pro);
			}
		} catch (SQLException e)
		{
			e.printStackTrace();
		}
		
		return product;
	}
	public int deleteById(String proId) 
	{
			int count =0;
			
			try(Connection connection =DbConnection.CreateConnection();
				PreparedStatement preparedStatement=connection.prepareStatement("delete from prod_data where proId=?"))
			{
				preparedStatement.setString(1, proId);
				count = preparedStatement.executeUpdate();
			}
			catch(SQLException e)
			{
				e.printStackTrace();
			}
			return count;	
	}
	public int update(Product product) {
	    int count = 0;
	    try (Connection connection = DbConnection.CreateConnection();
	            PreparedStatement preparedStatement = connection.prepareStatement(
	                    "UPDATE prod_data SET proName=?, proPrice=?, proBrand=?, proMadein=?, MfgDate=?, Expiry=?, proImage=?, proAudio=?,proVideo=? WHERE proId=?")) {

	        preparedStatement.setString(1, product.getProName());
	        preparedStatement.setDouble(2, product.getProPrice());
	        preparedStatement.setString(3, product.getProBrand());
	        preparedStatement.setString(4, product.getProMadein());
	        preparedStatement.setDate(5, product.getProMfgDate());
	        preparedStatement.setDate(6, product.getProExpDate());
	        preparedStatement.setBytes(7, product.getProImage());
	        preparedStatement.setBytes(8, product.getProAudio());
	        preparedStatement.setBytes(9, product.getProVideo());
	        preparedStatement.setString(10, product.getProId());

	        count = preparedStatement.executeUpdate();
	    } catch (SQLException e) {
	        // Log or handle the exception appropriately
	        e.printStackTrace();
	    }

	    return count;
	}	public Product findById(String proId) {
		Product product = new Product();

		try (Connection connection = DbConnection.CreateConnection();
				PreparedStatement preparedStatement = connection
						.prepareStatement("select * from prod_data where proId=?")) {
			preparedStatement.setString(1, proId);
			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				product.setProId(resultSet.getString(1));
				product.setProName(resultSet.getString(2));
				product.setProPrice(resultSet.getDouble(3));
				product.setProBrand(resultSet.getString(4));
				product.setProMadein(resultSet.getString(5));
				product.setProMfgDate(resultSet.getDate(6));
				product.setProExpDate(resultSet.getDate(7));
				product.setProImage(resultSet.getBytes(8));
				product.setProAudio(resultSet.getBytes(9));
				product.setProVideo(resultSet.getBytes(10));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return product;
	}


}

