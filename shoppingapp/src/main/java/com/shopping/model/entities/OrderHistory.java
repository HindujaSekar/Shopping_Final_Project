package com.shopping.model.entities;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="orderhistory")
public class OrderHistory {
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	
	private String productName;
	private String storeName;
	private String deliveredaddress;
	private LocalDate date;
	public OrderHistory(String productName, String storeName, String deliveredaddress,
			LocalDate date) {
	
		this.productName = productName;
		this.storeName = storeName;
		this.deliveredaddress = deliveredaddress;
		this.date = date;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getStoreName() {
		return storeName;
	}
	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}
	public String getDeliveredaddress() {
		return deliveredaddress;
	}
	public void setDeliveredaddress(String deliveredaddress) {
		this.deliveredaddress = deliveredaddress;
	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	public OrderHistory() {}

}
