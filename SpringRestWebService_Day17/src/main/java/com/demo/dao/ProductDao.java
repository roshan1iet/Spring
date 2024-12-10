package com.demo.dao;

import java.util.List;

import com.demo.beans.Product;

public interface ProductDao {

	List<Product> findAllProducts();

	boolean saveProduct(Product p);

	Product findById(int pid);

	

	boolean removeById(int pid);

	List<Product> findByCategory(int cid);

	boolean modifyProduct(Product p);

}
