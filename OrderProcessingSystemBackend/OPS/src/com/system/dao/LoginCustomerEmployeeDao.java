package com.system.dao;

import java.sql.SQLException;

import com.system.exception.NoSuchEmployeeFoundException;
import com.system.exception.NoSuchCustomerFoundException;
import com.system.model.Customer;
import com.system.model.Employee;

public interface LoginCustomerEmployeeDao {
	public boolean customerLogin(int id, String Password ) throws NoSuchCustomerFoundException, SQLException;
	public boolean employeeLogin(int id, String Password) throws NoSuchEmployeeFoundException, SQLException;

}
