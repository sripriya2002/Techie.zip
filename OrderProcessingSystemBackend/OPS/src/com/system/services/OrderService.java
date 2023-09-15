package com.system.services;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.system.exception.OrderNotFoundException;
import com.system.model.Order;
import com.system.model.Product;

public interface OrderService {
	 public List<Order> fetchOrdersWithoutProductListByCustomerId(int customerId) throws SQLException;

	  public List<Order> fetchAllOrdersWithoutProductList() throws SQLException;

	   public  List<Order> getOrdersByOrderId(int orderId) throws SQLException;
}
