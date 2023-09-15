package com.system.dao;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.system.exception.OrderNotFoundException;
import com.system.model.Order;
import com.system.model.Product;

public interface OrderDao {
  public List<Order> getAllOrdersWithoutProductList() throws SQLException;

  public List<Order> getOrdersWithoutProductListByCustomerId(int customerId) throws SQLException;

   public  List<Order> getOrdersByOrderId(int orderId) throws SQLException;
}
