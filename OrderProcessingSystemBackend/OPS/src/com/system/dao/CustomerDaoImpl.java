package com.system.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import com.system.exception.NoSuchCustomerFoundException;
import com.system.exception.ProductAlreadyExistsException;
import com.system.exception.TechnicalException;
import com.system.model.Customer;

public class CustomerDaoImpl implements CustomerDao {

	private Connection connection = null;
	private Statement stmt = null;
	
//	Open Resource for JDBC Connection
	private void openResources() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/<Your DataBase Name>?useSSL=false", "root", "<Your password>");
		stmt = connection.createStatement();
	}
	
//	Close Resource for JDBC Connection
	private void closeResources() throws SQLException {
		stmt.close();
		connection.close();
	}

// Function to fetch customer detail by Id	
@Override
public Customer getCustomerById(int customerId) throws SQLException, NoSuchCustomerFoundException {
		
		try {
			openResources();
			
//			SQL Query to fetch customer using customerId
			String query = "select * from customer where Customer_Id=?";
			PreparedStatement pstmt = connection.prepareStatement(query);
			
			pstmt.setInt(1, customerId);
			ResultSet rs = pstmt.executeQuery(query);
			
			if(rs.next())
				return new Customer(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9));
			
			closeResources();
		}
		catch(ClassNotFoundException ex) {
			throw new TechnicalException("Technical Exception");
		}
		catch(SQLException ex) {
			throw new ProductAlreadyExistsException("Product already present in database.", ex);
		}
		throw new NoSuchCustomerFoundException("Customer not found or Invalid credentials");
	}

// Function to fetch customer detail by Name
@Override
public Customer getCustomerByName(String customerName) throws SQLException, NoSuchCustomerFoundException {
		try {
			openResources();
		
//			SQL Query to fetch customer using customerName
			String query = "select * from customer where Customer_Name=?";
			PreparedStatement pstmt = connection.prepareStatement(query);
			
			pstmt.setString(1, customerName);
			ResultSet rs = pstmt.executeQuery(query);
			
			if(rs.next())
				return new Customer(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9));
			
			closeResources();
		}
		catch(ClassNotFoundException ex) {
			throw new TechnicalException("Technical Exception");
		}
		catch(SQLException ex) {
			throw new ProductAlreadyExistsException("Product already present in database.", ex);
		}
		throw new NoSuchCustomerFoundException("Customer not found or Invalid credentials");
	}
}
