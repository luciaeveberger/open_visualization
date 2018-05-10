package com.open_data_visualization.service;

import com.open_data_visualization.model.User;

public interface UserService {
	public User findUserByEmail(String email);
	public void saveUser(User user);
}
