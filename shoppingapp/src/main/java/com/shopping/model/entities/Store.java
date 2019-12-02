package com.shopping.model.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;


import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="store_table")
public class Store {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	private String storeName;
	private String address;
	private String contactNumber;
	private double rating;
	private int numberOfPeopleRated;
	@JsonIgnore
	@ManyToMany(mappedBy="availableStores",cascade=CascadeType.ALL,fetch=FetchType.LAZY)
	private List<Product> products=new ArrayList<Product>();
	@JsonIgnore
	@OneToOne
	private Order order;
	
	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getStoreName() {
		return storeName;
	}

	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	public double getRating() {
		return rating;
	}

	public void setRating(double rating) {
		this.rating = rating;
	}

	public int getNumberOfPeopleRated() {
		return numberOfPeopleRated;
	}

	public void setNumberOfPeopleRated(int numberOfPeopleRated) {
		this.numberOfPeopleRated = numberOfPeopleRated;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	public Store(String storeName, String address, String contactNumber, double rating, int numberOfPeopleRated) {
		super();
		this.storeName = storeName;
		this.address = address;
		this.contactNumber = contactNumber;
		this.rating = rating;
		this.numberOfPeopleRated = numberOfPeopleRated;
	}

	public Store() {}

	@Override
	public String toString() {
		return "Store [id=" + id + ", storeName=" + storeName + ", address=" + address + ", contactNumber="
				+ contactNumber + ", rating=" + rating + ", numberOfPeopleRated=" + numberOfPeopleRated + "]";
	}

}
