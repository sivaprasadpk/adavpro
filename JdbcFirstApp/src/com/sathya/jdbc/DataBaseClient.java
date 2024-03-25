package com.sathya.jdbc;

import java.util.List;

public class DataBaseClient 
{

	public static void main(String[] args)  
	{
		EmployeeDao employeeDao=new EmployeeDao();
//		int res1=employeeDao.save(new Employee(1001,"siva",116));
//		System.out.println("data insert success..."+res1);
//		int res2=employeeDao.save(new Employee(1002,"bharath",118));
//		System.out.println("data insert success..."+res2);
		
//		Employee res=employeeDao.findByAll(1001);
//		System.out.println(res);
		
//		int count=employeeDao.deleteById(1001);
//		if(count==1)
//			System.out.println("data delete successfully");
//		else
//			System.out.println("data delete fail");
		
//		int deletecount=employeeDao.deleteBySalary(120);
//		System.out.println("data delete successfull..."+deletecount);
	
//		List<Employee> s=employeeDao.findAll();
//		for(Employee h:s)
//			System.out.println(h);
		
		int count1=employeeDao.updateSalary(100,1000);
		System.out.println(count1);
	}

}
