package com.system.services;

import java.sql.SQLException;

import com.system.exception.NoSuchCustomerFoundException;
import com.system.model.Customer;

public interface CustomerService {
	 public Customer fetchCustomerById(int customerId) throws SQLException, NoSuchCustomerFoundException;
     public Customer fetchCustomerByName(String customerName) throws SQLException, NoSuchCustomerFoundException;
}
