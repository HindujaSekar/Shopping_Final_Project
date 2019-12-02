package com.shopping.model.service;

import com.shopping.model.entities.User;

public interface UserService {
	User getUser(String email);
	User registerUser(User user);
}
