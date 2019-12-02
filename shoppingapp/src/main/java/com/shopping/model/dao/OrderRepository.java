package com.shopping.model.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.shopping.model.entities.Order;
@Repository
public interface OrderRepository extends JpaRepository<Order, Long>{
	
}
