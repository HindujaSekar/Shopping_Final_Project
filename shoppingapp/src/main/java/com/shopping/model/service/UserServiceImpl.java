package com.shopping.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.shopping.model.dao.UserRepository;
import com.shopping.model.entities.User;
@Service
@Transactional
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserRepository repo;

	@Override
	public User getUser(String email) {
		
		return repo.findByEmail(email);
	}

	@Override
	public User registerUser(User user) {
		return repo.save(user);
	}

}
