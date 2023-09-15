package com.system.services;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.system.dao.OrderDao;
import com.system.exception.OrderNotFoundException;
import com.system.model.Order;
import com.system.model.Product;

public class OrderServiceImpl implements OrderService{
    private OrderDao Dao;
	@Override
	public List<Order> fetchAllOrdersWithoutProductList() throws SQLException {
		return Dao.getAllOrdersWithoutProductList();
	}

	@Override
	public List<Order> fetchOrdersWithoutProductListByCustomerId(int customerId) throws SQLException {
		return Dao.getOrdersWithoutProductListByCustomerId(customerId);
	}

	@Override
	public List<Order> getOrdersByOrderId(int orderId) throws SQLException {
		// TODO Auto-generated method stub
		return Dao.getOrdersByOrderId(orderId);
	}

	


}
