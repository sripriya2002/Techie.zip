package com.system.services;

import java.sql.SQLException;
import java.util.List;

import com.system.model.Product;

public interface ProductService {
 public List<Product>fetchAllProducts()throws SQLException;
 public boolean addProducts(Product products)throws SQLException;

}
