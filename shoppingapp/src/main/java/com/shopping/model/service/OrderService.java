package com.shopping.model.service;

import java.util.List;

import com.shopping.model.entities.Order;
import com.shopping.model.entities.Product;
import com.shopping.model.entities.Store;

public interface OrderService {
	List<Order> getAllOrders();
	Order getOrderById(long id);
	Order orderProduct(Product product,String address, Store store, int quantity);
}
