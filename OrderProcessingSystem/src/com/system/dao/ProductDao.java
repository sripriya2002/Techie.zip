package com.system.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Set;

import com.system.model.Product;

public interface ProductDao {
	public List<Product> getAllProducts()throws SQLException;
	public int addProducts(Set<Product>products)throws SQLException;

}
