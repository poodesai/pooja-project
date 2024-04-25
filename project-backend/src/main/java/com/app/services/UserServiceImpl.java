package com.app.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.entity.User;
import com.app.repository.UserRepo;

@Service
public class UserServiceImpl implements IUserService {

	@Autowired
	private UserRepo userRepo;

	@Override
	public List<User> getAllUsers() {
		
		List<User> allUsers = (List<User>) userRepo.findAll();

		return allUsers;
	}

	@Override
	public User createUser(User user) {
		User savedUser = userRepo.save(user);
		return savedUser;
	}

	@Override
	public User updateUser(Long uId, User user) {
		User findUser = userRepo.findById(uId).orElseThrow(null);
		findUser.setFirstName(user.getFirstName());
		findUser.setLastname(user.getLastname());
		findUser.setDateOfBirth(user.getDateOfBirth());
		findUser.setUsername(user.getUsername());
		findUser.setPassword(user.getPassword());
		findUser.setEmail(user.getEmail());
		userRepo.save(findUser);
		return findUser;

	}

	@Override
	public void deleteUser(Long uId) {
		User user = userRepo.findById(uId).orElseThrow(null);
		userRepo.delete(user);

	}

}
