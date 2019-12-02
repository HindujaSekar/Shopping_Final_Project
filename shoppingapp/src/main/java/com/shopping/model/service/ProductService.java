package com.shopping.model.service;

import java.util.List;

import com.shopping.model.entities.Product;

public interface ProductService {
	List<Product> getAllProducts();
	List<Product> getSearchedProducts(String name);
	Product getProductById(long id);
	Product updateProduct(Product product);
	void removeProductById(long id);
	Product addProduct(Product product);
}
