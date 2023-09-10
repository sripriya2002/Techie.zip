package com.system.services;

import java.sql.SQLException;

import com.system.dao.LoginCustomerEmployeeDao;
import com.system.exception.NoSuchCustomerFoundException;
import com.system.exception.NoSuchEmployeeFoundException;
import com.system.model.Customer;
import com.system.model.Employee;

public class LoginEmployeeCustomerServiceImpl implements LoginEmployeeCustomerService {
	private LoginCustomerEmployeeDao Dao;

	@Override
	public Customer loginCustomer(int id, String Password) throws SQLException, NoSuchCustomerFoundException {
		return Dao.customerLogin(id, Password);
	}

	@Override
	public Employee loginEmployee(int id, String Password) throws SQLException, NoSuchEmployeeFoundException {
		return Dao.employeeLogin(id, Password);
	}

}
