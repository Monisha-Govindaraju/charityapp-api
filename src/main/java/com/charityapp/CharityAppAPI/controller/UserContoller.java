package com.charityapp.charityappapi.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.charityapp.charityappapi.dao.UserRepository;
import com.charityapp.charityappapi.model.User;

@RestController
public class UserContoller {
	@Autowired
	UserRepository userRepository;

	@PostMapping("users/save")
	public void save(@RequestBody User user) {
		userRepository.save(user);
	}

	@GetMapping("users/list")
	public List<User> findAll() {
		List<User> usersList = userRepository.findAll();
		return usersList;
	}

	@DeleteMapping("users/{id}")
	public void delete(@PathVariable("id") Integer id) {
		userRepository.deleteById(id);
	}

	@PutMapping("users/{id}")
	public void update(@PathVariable("id") Integer id, @RequestBody User user) {
		user.setId(id);
		userRepository.save(user);
	}

	@GetMapping("users/{id}")
	public User findById(@PathVariable("id") Integer id) {
		Optional<User> user = userRepository.findById(id);
		if (user.isPresent()) {
			return user.get();
		} else {
			return null;
		}
	}
	@PostMapping("users/login")
	public User login(@RequestBody User user) {
		Optional<User> userObj=userRepository.findByEmailAndPassword(user.getEmail(),user.getPassword());
		if(userObj.isPresent()) {
			return userObj.get();
		}else {
		return null;
		}
		
	}
}
