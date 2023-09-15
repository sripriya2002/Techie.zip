package com.system.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.system.exception.OrderNotFoundException;
import com.system.exception.ProductAlreadyExistsException;
import com.system.exception.TechnicalException;
import com.system.model.Order;
import com.system.model.Product;

import com.system.util.orderStatus;

public class OrderDaoImpl implements OrderDao{
	private Connection connection = null;
	private Statement stmt = null;
	
//	Open Resource for JDBC Connection
private void openResources() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/<Your DataBase Name>?useSSL=false", "root", "<Your password>");
		stmt = connection.createStatement();
	}
	
//Close Resource for JDBC Connection	
private void closeResources() throws SQLException {
		stmt.close();
		connection.close();
	}


//Function to fetch All Orders without ProductList
@Override
public List<Order> getAllOrdersWithoutProductList() throws SQLException {
		List<Order> orderList = new ArrayList<>();
		try {
			openResources();
			String query = "select * from orders";
			ResultSet rs = stmt.executeQuery(query)
			while(rs.next()) {
				orderList.add(new Order(rs.getInt(1),rs.getDate(2),rs.getInt(3),rs.getString(4), rs.getInt(5),(float)rs.getDouble(6),(float)rs.getInt(7),orderStatus.valueOf(rs.getString(8))));
			}
			closeResources();
		}
		catch(ClassNotFoundException ex) {
			throw new TechnicalException("Technical Exception");
		}
		catch(SQLException ex) {
			throw new ProductAlreadyExistsException("Product already present in database.", ex);
		}
		return orderList;
		
	}

// Function to fetch product list using customer Id
@Override
public List<Order> getOrdersWithoutProductListByCustomerId(int customerId) throws SQLException {
		
		List<Order> orderList = new ArrayList<>();
		
		try {
			openResources();
			String query = "select * from orders where Customer_Id="+customerId;
			ResultSet rs = stmt.executeQuery(query);
			while(rs.next()) {
				orderList.add(new Order(rs.getInt(1),rs.getDate(2),rs.getInt(3),rs.getString(4), rs.getInt(5),(float)rs.getDouble(6),(float)rs.getInt(7),orderStatus.valueOf(rs.getString(8))));
			}
			closeResources();
		}
		catch(ClassNotFoundException ex) {
			throw new TechnicalException("Technical Exception");
		}
		catch(SQLException ex) {
			throw new ProductAlreadyExistsException("Product already present in database.", ex);
		}
		return orderList;
}
	
// function to fetch order using orderId
@Override
public List<Order> getOrdersByOrderId(int orderId) throws SQLException {
List<Order> orderList = new ArrayList<>();
		
		try {
			openResources();			
			String query = "select * from orders where Order_Id="+orderId;
			
			ResultSet rs = stmt.executeQuery(query);
			while(rs.next()) {
				orderList.add(new Order(rs.getInt(1),rs.getDate(2),rs.getInt(3),rs.getString(4), rs.getInt(5),(float)rs.getDouble(6),(float)rs.getInt(7),orderStatus.valueOf(rs.getString(8))));
			}
			closeResources();
		}
		catch(ClassNotFoundException ex) {
			throw new TechnicalException("Technical Exception");
		}
		catch(SQLException ex) {
			throw new ProductAlreadyExistsException("Product already present in database.", ex);
		}
		
		return orderList;
		
	}

}
