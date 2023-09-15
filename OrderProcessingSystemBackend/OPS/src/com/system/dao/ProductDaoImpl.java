package com.system.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;


import com.system.exception.ProductAlreadyExistsException;
import com.system.exception.TechnicalException;
import com.system.model.Product;

public class ProductDaoImpl implements ProductDao {

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

//	Function to fetch list of All products
@Override
	public List<Product> getAllProducts() throws SQLException {
		List<Product> productList = new ArrayList<>();
		try {
			openResources();
			String query = "select * from products";
			ResultSet rs = stmt.executeQuery(query);
			while(rs.next()) {
				productList.add(new Product(rs.getInt("Product_Id"),rs.getString("Product_Name"),rs.getFloat("Price"),rs.getInt("Product_Category"),rs.getInt("company_gst")));
			}
			closeResources();
		}
		catch(ClassNotFoundException ex) {
			throw new TechnicalException("Technical Exception");
		}
		catch(SQLException ex) {
			throw new ProductAlreadyExistsException("Product already present in database.", ex);
		}
		
		return productList;
}
	
// function to add Products
@Override
	public boolean addProducts(Product products) throws SQLException {
		
		try {
			openResources();
			connection.setAutoCommit(false);
			String query = "Insert into product(Product_Id, Product_Name, Price, Product_Category, company_gst) values(?, ?, ?, ?, ?)";
			PreparedStatement pstmt = connection.prepareStatement(query);
			pstmt.setInt(1, products.getProductId());
			pstmt.setString(2, products.getProductName());
			pstmt.setFloat(3, products.getProductPrice());
			pstmt.setInt(4, products.getProductCategory());
			pstmt.setInt(5, products.getCompanyId());
			pstmt.executeUpdate();
			connection.commit();
			closeResources();
		}
		catch(ClassNotFoundException ex) {
			throw new TechnicalException("Technical Exception");
		}
		catch(SQLException ex) {
			throw new ProductAlreadyExistsException("Product already present in database.", ex);
		}
		return false;
			
		}

}
