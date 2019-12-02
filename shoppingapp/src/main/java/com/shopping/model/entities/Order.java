package com.shopping.model.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="order_table")
public class Order {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	private String deliverAddress;
	private double total;
	private int quantity;
	@JsonIgnore
	@OneToOne(mappedBy="order")
	private Store store;
	
	public Store getStore() {
		return store;
	}

	public void setStore(Store store) {
		this.store = store;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	@JsonIgnore
	@OneToOne(mappedBy="order")
	private Product product;
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getDeliverAddress() {
		return deliverAddress;
	}

	public void setDeliverAddress(String deliverAddress) {
		this.deliverAddress = deliverAddress;
	}

	
	public Product getProduct(){
		return product;
	}
	public void setProduct(Product product){
		this.product=product;
	}
	

	public Order() {}

	public Order(String deliverAddress, double total, int quantity) {
		super();
		this.deliverAddress = deliverAddress;
		this.total = total;
		this.quantity = quantity;
	}

	
}
