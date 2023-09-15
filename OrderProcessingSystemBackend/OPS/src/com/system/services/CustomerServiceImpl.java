package com.system.services;

import java.sql.SQLException;

import com.system.dao.CustomerDao;
import com.system.exception.NoSuchCustomerFoundException;
import com.system.model.Customer;

public class CustomerServiceImpl implements CustomerService {
    private CustomerDao Dao;
	@Override
	public Customer fetchCustomerById(int customerId) throws SQLException, NoSuchCustomerFoundException {
		return Dao.getCustomerById(customerId);
	}

	@Override
	public Customer fetchCustomerByName(String customerName) throws SQLException, NoSuchCustomerFoundException {
		return Dao.getCustomerByName(customerName);
	}

}
