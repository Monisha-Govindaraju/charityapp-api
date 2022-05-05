package com.charityapp.charityappapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.charityapp.charityappapi.dao.UserRepository;
import com.charityapp.charityappapi.model.User;
import com.charityapp.charityappapi.validator.UserValidator;

@Service
public class UserService {
	@Autowired
	UserRepository userRepository;

	public void save(User user) throws Exception {
		try {
			UserValidator.validateUser(user);
			userRepository.save(user);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	public List<User> findAll() throws Exception {
		List<User> listUser = null;
		try {
			listUser = userRepository.findAll();
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
		return listUser;
	}

	public void update(@PathVariable("id") Integer id, @RequestBody User user) throws Exception {
		try {
			user.setId(id);
			userRepository.save(user);
			UserValidator.validateUser(user);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}
}
