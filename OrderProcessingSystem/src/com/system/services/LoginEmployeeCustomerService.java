package com.system.services;

import java.sql.SQLException;

import com.system.exception.NoSuchEmployeeFoundException;
import com.system.exception.NoSuchCustomerFoundException;
import com.system.model.Customer;
import com.system.model.Employee;

public interface LoginEmployeeCustomerService {
	Customer loginCustomer(int id, String password) throws SQLException, NoSuchCustomerFoundException;
	Employee loginEmployee(int id, String password) throws SQLException, NoSuchEmployeeFoundException;

}
