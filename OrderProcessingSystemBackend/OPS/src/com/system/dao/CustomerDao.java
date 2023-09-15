package com.system.dao;

import java.sql.SQLException;

import com.system.exception.NoSuchCustomerFoundException;
import com.system.model.Customer;

public interface CustomerDao {
	 public Customer getCustomerById(int customerId) throws SQLException, NoSuchCustomerFoundException;
     public Customer getCustomerByName(String customerName) throws SQLException, NoSuchCustomerFoundException;
}
