package com.shopping.model.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.shopping.model.entities.OrderHistory;
@Repository
public interface OrderHistoryRepository extends JpaRepository<OrderHistory, Long>{

}
