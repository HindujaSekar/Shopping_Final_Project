package com.shopping.model.service;

import java.util.List;

import com.shopping.model.entities.Store;

public interface StoreService {
	List<Store> getAllStores();
	Store getStoreById(long id);
	Store giveRating(double rating, long storeId);
}
