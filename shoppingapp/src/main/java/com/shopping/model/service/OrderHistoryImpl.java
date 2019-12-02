package com.shopping.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.shopping.model.dao.OrderHistoryRepository;
import com.shopping.model.entities.OrderHistory;

@Service
@Transactional
public class OrderHistoryImpl implements OrderHistoryService{
	@Autowired
	private OrderHistoryRepository repo;

	@Override
	public List<OrderHistory> getAllOrderHistory() {
	
		return repo.findAll();
	}

}
