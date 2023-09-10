package com.system.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.system.exception.NoSuchEmployeeFoundException;
import com.system.exception.NoSuchCustomerFoundException;
import com.system.model.Customer;
import com.system.model.Employee;

public class LoginCustomerEmployeeDaoImpl implements LoginCustomerEmployeeDao {
     private static PreparedStatement loginId;
	
     
     @Override
     public Customer customerLogin(int id, String Password ) throws SQLException, NoSuchCustomerFoundException {
    	 loginId.setInt(1, id);
 		loginId.setString(2, Password);
 		ResultSet rs = loginId.executeQuery();
 		if(rs.next())
 			return new Customer(rs.getInt(1),rs.getString(2),rs.getString(4),rs.getString(5),rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9));
 		throw new NoSuchCustomerFoundException("Customer not found or Invalid credentials");

	}


	@Override
	public Employee employeeLogin(int id, String Password) throws SQLException,NoSuchEmployeeFoundException {
		loginId.setInt(1, id);
		loginId.setString(2, Password);
		ResultSet rs = loginId.executeQuery();
		if(rs.next())
			return new Employee(rs.getInt(1),rs.getString(2),rs.getString(3));
		throw new NoSuchEmployeeFoundException("Employee not found or Invalid credentials");
	}



}
