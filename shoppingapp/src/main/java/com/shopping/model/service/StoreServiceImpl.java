package com.shopping.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.shopping.model.dao.StoreRepository;
import com.shopping.model.entities.Store;
import com.shopping.model.service.exceptions.StoreNotFoundException;

@Service
@Transactional
public class StoreServiceImpl implements StoreService {
	@Autowired
	private StoreRepository repo;

	@Override
	public List<Store> getAllStores() {
		return repo.findAll();
	}

	@Override
	public Store getStoreById(long id) {
		return repo.findById(id).orElseThrow(StoreNotFoundException::new);
	}

	@Override
	public Store giveRating(double rating, long storeId) {
		Store store=getStoreById(storeId);
		double changedRating=(rating+store.getRating())/2;
		store.setNumberOfPeopleRated(store.getNumberOfPeopleRated()+1);
		store.setRating(changedRating);
		repo.save(store);
		return store;
	}

}
