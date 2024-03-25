package com.sathya.jdbc;

public class Employee 
{
	int EmpId;
	String EmpName;
	double EMPSALARY;
	
	public Employee(int empId, String empName, double eMPSALARY) {
		super();
		EmpId = empId;
		EmpName = empName;
		EMPSALARY = eMPSALARY;
	}
	
	public Employee()
	{
		
	}

	public int getEmpId() {
		return EmpId;
	}


	public void setEmpId(int empId) {
		EmpId = empId;
	}


	public String getEmpName() {
		return EmpName;
	}


	public void setEmpName(String empName) {
		EmpName = empName;
	}


	public double getEMPSALARY() {
		return EMPSALARY;
	}


	public void setEMPSALARY(double eMPSALARY) {
		EMPSALARY = eMPSALARY;
	}


	@Override
	public String toString() {
		return "Employee [EmpId=" + EmpId + ", EmpName=" + EmpName + ", EMPSALARY=" + EMPSALARY + "]";
	}
}
