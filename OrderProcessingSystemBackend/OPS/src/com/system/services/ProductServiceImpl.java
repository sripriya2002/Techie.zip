package com.system.services;

import java.sql.SQLException;
import java.util.List;

import com.system.dao.ProductDao;
import com.system.model.Order;
import com.system.model.Product;

public class ProductServiceImpl implements ProductService {
    private ProductDao Dao;
	@Override
	public List<Product> fetchAllProducts() throws SQLException {
		return Dao.getAllProducts();
	}

	@Override
	public boolean addProducts(Product products) throws SQLException {
		return Dao.addProducts(products);
	}
}
