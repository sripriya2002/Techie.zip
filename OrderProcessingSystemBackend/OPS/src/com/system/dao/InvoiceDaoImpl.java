package com.system.dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import com.system.exception.NoSuchInvoiceFound;
import com.system.exception.ProductAlreadyExistsException;
import com.system.exception.TechnicalException;
import com.system.model.Invoice;
import com.system.util.GSTType;
import com.system.util.InvoiceStatus;

public class InvoiceDaoImpl implements InvoiceDao{
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

// function to fetch Invoice by Id	
@Override
public Invoice getInvoiceByOrderId(int id) throws SQLException, NoSuchInvoiceFound {
		
		try {
			openResources();
			String query = "select * from invoice where Invoice_Id=?";
			PreparedStatement pstmt = connection.prepareStatement(query);
			
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery(query);
			
			if(rs.next())
				return(new Invoice(rs.getInt(1),rs.getDate(2),rs.getInt(3),rs.getInt(4),rs.getInt(5),GSTType.valueOf(rs.getString(6)),(float)rs.getDouble(7),InvoiceStatus.valueOf(rs.getString(8))));
			closeResources();
		}
		catch(ClassNotFoundException ex) {
			throw new TechnicalException("Technical Exception");
		}
		catch(SQLException ex) {
			throw new ProductAlreadyExistsException("Product already present in database.", ex);
		}
		
		return null;
	}

// Function to add Invoice
@Override
public boolean addInvoice(Invoice invoice) throws SQLException {		
		try {
			openResources();
			connection.setAutoCommit(false);
			
			String query = "Insert into invoice(Invoice_Id, Invoice_Date, Order_Id, Customer_Id, Product_Id, GST_Type, Total_Invoice_Value, Status) values(?, ?, ?, ?, ?, ?, ?, ?)";
			PreparedStatement pstmt = connection.prepareStatement(query);

			pstmt.setInt(1, invoice.getInvoiceId());
			pstmt.setDate(2, invoice.getInvoiceDate());
			pstmt.setInt(3, invoice.getOrderId());
			pstmt.setInt(4, invoice.getCustomerId());
			pstmt.setInt(5, invoice.getProductId());
			pstmt.setString(6, invoice.getTypeOfGST().name());
			pstmt.setDouble(7, (double)invoice.getTotalInvoiceValue());
			pstmt.setString(8, invoice.getStatus().name());
			pstmt.executeUpdate();
			
			// always implicitly commit
			connection.commit();
			closeResources();
		}
		catch(ClassNotFoundException ex) {
			throw new TechnicalException("Technical Exception");
		}
		catch(SQLException ex) {
			throw new ProductAlreadyExistsException("Product already present in database.", ex);
		}
		throw new TechnicalException("Technical Exception");
	}

}
