package com.system.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import com.system.exception.NoSuchEmployeeFoundException;
import com.system.exception.ProductAlreadyExistsException;
import com.system.exception.TechnicalException;
import com.system.exception.NoSuchCustomerFoundException;
import com.system.model.Customer;
import com.system.model.Employee;

public class LoginCustomerEmployeeDaoImpl implements LoginCustomerEmployeeDao {
   
	
	private Connection connection = null;
	private Statement stmt = null;
	
//	Open Resource for JDBC Connection
	private void openResources() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/<Your DataBase Name>?useSSL=false", "root", "<Your Password>");
		stmt = connection.createStatement();
	}
	
//	Close Resource for JDBC Connection	
	private void closeResources() throws SQLException {
		stmt.close();
		connection.close();
	}

//Function for login customer using Id and password	
@Override
     public boolean customerLogin(int id, String password ) throws SQLException, NoSuchCustomerFoundException {
		
    	 
    	 try {
 			openResources(); 			
 			String query = "select * from customer";
 			ResultSet rs = stmt.executeQuery(query);
 			Customer result = null;
 			while(rs.next()) {
 				
 				result = new Customer(rs.getInt("Customer_Id"), 
						rs.getString("Customer_Name"),
						rs.getString("GST_Number"),
						rs.getString("Address"),
						rs.getString("City"),
						rs.getString("Email"),
						rs.getString("Phone"),
						rs.getString("Pincode"),
						rs.getString("customer_password")
						);
 				if(result.getCustomerId()==id && result.getCustomerPassword().equals(password)) {
 					return true;
 				}
 			}
 			closeResources();
 		}
 		catch(ClassNotFoundException ex) {
 			throw new TechnicalException("Technical Exception");
 		}
 		catch(SQLException ex) {
 			throw new ProductAlreadyExistsException("Product already present in database.", ex);
 		}
 		throw new NoSuchCustomerFoundException("There is No Such Customer");
}


// function for login Employee using Id and password
@Override
public boolean employeeLogin(int id, String password) throws SQLException,NoSuchEmployeeFoundException {
		
		
		try {
 			openResources();
 			//connection.setAutoCommit(false);
 			
 			String query = "select * from employee";
 			ResultSet rs = stmt.executeQuery(query);
 			Employee result = null;
 			while(rs.next()) {
 				
 				result = new Employee(rs.getInt("Employee_Id"), 
						rs.getString("Employee_Username"),
						rs.getString("Employee_Password")
						);
 				if(result.getEmployeeId()==id && result.getEmployeePassword().equals(password)) {
 					return true;
 				}
 			}
 			closeResources();
 		}
 		catch(ClassNotFoundException ex) {
 			throw new TechnicalException("Technical Exception");
 		}
 		catch(SQLException ex) {
 			throw new ProductAlreadyExistsException("Product already present in database.", ex);
 		}
 		throw new NoSuchEmployeeFoundException("There is No Such Employee");
	}



}
