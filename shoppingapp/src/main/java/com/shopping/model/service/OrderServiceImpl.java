package com.shopping.model.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.shopping.model.dao.OrderHistoryRepository;
import com.shopping.model.dao.OrderRepository;
import com.shopping.model.dao.ProductRepository;
import com.shopping.model.dao.StoreRepository;
import com.shopping.model.entities.Order;
import com.shopping.model.entities.OrderHistory;
import com.shopping.model.entities.Product;
import com.shopping.model.entities.Store;
import com.shopping.model.service.exceptions.OrderNotFoundException;

@Service
@Transactional
public class OrderServiceImpl implements OrderService{
	@Autowired
	private OrderRepository repo;
	
	@Autowired
	private ProductRepository pRepo;
	
	@Autowired
	private StoreRepository sRepo;
	
	@Autowired
	private OrderHistoryRepository ohRepo;

	@Override
	public List<Order> getAllOrders() {
		return repo.findAll();
	}

	@Override
	public Order getOrderById(long id) {
		return repo.findById(id).orElseThrow(OrderNotFoundException::new);
	}

	@Override
	public Order orderProduct(Product product, String address, Store store, int quantity) {
		Order order=new Order(address,quantity*product.getPrice(),quantity);
		product.setOrder(order);
		store.setOrder(order);
		order.setProduct(product);
		product.setQuantity(product.getQuantity()-quantity);
		repo.save(order);
		pRepo.save(product);
		sRepo.save(store);
		OrderHistory history=new OrderHistory
				( product.getName(), store.getStoreName(), 
						order.getDeliverAddress(), LocalDate.now());
		ohRepo.save(history);
		return order;
	}
	

}
