package com.system.ui;
import java.sql.SQLException;
import java.util.List;

import com.system.exception.NoSuchCustomerFoundException;
import com.system.exception.NoSuchEmployeeFoundException;
import com.system.exception.NoSuchInvoiceFound;
import com.system.exception.OrderNotFoundException;
import com.system.exception.ProductAlreadyExistsException;
import com.system.model.Customer;
import com.system.model.Invoice;
import com.system.model.Order;
import com.system.model.Product;
import com.system.services.CustomerServiceImpl;
import com.system.services.InvoiceServiceImpl;
import com.system.services.LoginEmployeeCustomerServiceImpl;
import com.system.services.OrderServiceImpl;
import com.system.services.ProductServiceImpl;
import com.system.util.GSTType;
import com.system.util.InvoiceStatus;

public class OrderProcessingSystemApplication {
	public static void main(String[] args) {
		
		
LoginEmployeeCustomerServiceImpl service1=new LoginEmployeeCustomerServiceImpl();
		try {
			if(service1.loginCustomer(12345676, "Sripriya@12"))
				System.out.println("Login Successful");
		} catch (NoSuchCustomerFoundException | SQLException ex) {
			
			System.out.println("Wrong Credentials");
		}
		
		try {
			if(service1.loginEmployee(15673456, "Shruthi@123"))
				System.out.println("Login Successful");
		} catch (NoSuchEmployeeFoundException | SQLException ex) {
			
			System.out.println("Wrong Credentials");
		}
		
		
				
CustomerServiceImpl service2 = new CustomerServiceImpl();		 
     	try {
				Customer result = service2.fetchCustomerById(10);
				System.out.println(result);
			} catch (NoSuchCustomerFoundException | SQLException ex) {
				
				System.out.println("No Customer with this Id");
			}
			
			try {
				Customer result = service2.fetchCustomerByName("Shruti");
				System.out.println(result);
			} catch (NoSuchCustomerFoundException | SQLException ex) {
				
				System.out.println("No Customer with this Name");
			}
			
		

InvoiceServiceImpl service3 = new InvoiceServiceImpl();
		try {
			Invoice result = service3.fetchInvoiceByOrderId(10023459);
			System.out.println(result);
		} catch (NoSuchInvoiceFound | SQLException ex) {
			
			System.out.println("No Invoice for OrderId ");
		}
		
		try {
			if(service3.addInvoice(104, 14/03/2001, 10023460, 12345679, 65467589,GSTType.INTER_STATE , 80000, InvoiceStatus.paid));
			System.out.println("Invoice is Added");
		} catch (NoSuchInvoiceFound| SQLException ex) {
			
			System.out.println("No such Invoice is present");
		}
	
		
OrderServiceImpl service4=new OrderServiceImpl();
        try {
        	List<Order> result= service4.fetchAllOrdersWithoutProductList();
        	System.out.println(result);
        	} catch (OrderNotFoundException | SQLException ex) {
	        System.out.println("Order not found");
         }
         try {
        	 List<Order> result=service4.fetchOrdersWithoutProductListByCustomerId(12345676);
        	 System.out.println(result);
          } catch (OrderNotFoundException| SQLException ex) {
        	  System.out.println("Order not found");
          }
         try {
        	 List<Order> result=service4.getOrdersByOrderId(10023459);
        	 System.out.println(result);
          } catch (OrderNotFoundException| SQLException ex) {
        	  System.out.println("Order not found");
          }
ProductServiceImpl service5= new ProductServiceImpl();
          try {
        	  if(service5.addProducts(10010011,"HandWash" , 20000, 3, 65656589)) {
        	  System.out.println("Product is Added");
        	  } catch (ProductAlreadyExistsException | SQLException ex) {
        		  System.out.println("Product Already Exist");
        	  }
          try {
        	  List<Product> result=service5.fetchAllProducts();
        	  System.out.println(result);
        	  } catch (SQLException ex) {
        		  System.out.println("SQL Exceptio");
        	  }

	}
}
