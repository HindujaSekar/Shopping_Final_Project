package com.shopping.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.shopping.model.dao.ProductRepository;
import com.shopping.model.entities.Product;
import com.shopping.model.service.exceptions.ProductNotFoundException;

@Service
@Transactional
public class ProductServiceImpl implements ProductService{
	@Autowired
	private ProductRepository repo;

	@Override
	public List<Product> getAllProducts() {
		return repo.findAll();
	}

	@Override
	public Product getProductById(long id) {
		return repo.findById(id).orElseThrow(ProductNotFoundException::new);
	}

	@Override
	public Product updateProduct(Product product) {
		repo.save(product);
		return product;
	}

	@Override
	public void removeProductById(long id) {
		repo.deleteById(id);
	}

	@Override
	public Product addProduct(Product product) {
		repo.save(product);
		return product;
	}

	@Override
	public List<Product> getSearchedProducts(String name) {
		return repo.findByNameLike(name);
	}

}
