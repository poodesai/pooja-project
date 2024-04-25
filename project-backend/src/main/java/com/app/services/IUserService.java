package com.app.services;

import java.util.List;

import com.app.entity.User;

public interface IUserService {
	List<User> getAllUsers();
	User createUser(User user);
	User updateUser(Long uId, User user);
	void deleteUser(Long uId);

}
