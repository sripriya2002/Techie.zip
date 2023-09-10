package com.system.model;

public class Employee {
	private int employeeId;
	private String employeeUserName;
	private String employeePassword;
	
//	Parameterized Constructor
	public Employee(int employeeId, String employeeUserName, String employeePassword) {
		super();
		this.employeeId = employeeId;
		this.employeeUserName = employeeUserName;
		this.employeePassword = employeePassword;
	}
	
//	Getter and Setter Method
	public int getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	public String getEmployeeUserName() {
		return employeeUserName;
	}
	public void setEmployeeUserName(String employeeUserName) {
		this.employeeUserName = employeeUserName;
	}
	public String getEmployeePassword() {
		return employeePassword;
	}
	public void setEmployeePassword(String employeePassword) {
		this.employeePassword = employeePassword;
	}
	
//	toString Method
	@Override
	public String toString() {
		return "Employee [employeeId=" + employeeId + ", employeeUserName=" + employeeUserName + ", employeePassword="
				+ employeePassword + "]";
	}

}
