package com.charityapp.charityappapi.controller;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.charityapp.charityappapi.dao.UserRepository;
import com.charityapp.charityappapi.dto.MessageDTO;
import com.charityapp.charityappapi.model.User;
import com.charityapp.charityappapi.service.UserService;
@RestController
public class UserController {
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	UserService userService;
	@PostMapping("users/save")
	public ResponseEntity<?> save(@RequestBody User user) {
		try {
			userService.save(user);
			MessageDTO message = new MessageDTO("Success");
			return new ResponseEntity<>(message, HttpStatus.OK);
		} catch (Exception e) {
			MessageDTO message = new MessageDTO(e.getMessage());
			return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
		}
	}
	@GetMapping("users/list")
	public List<User> findAll() {
		List<User> userlist = null;
		try {
			userlist = userService.findAll();
		} catch (Exception e) {
			e.getMessage();
		}
		return userlist;
	}
	@DeleteMapping("users/{id}")
	public void delete(@PathVariable("id") Integer id) {
		userRepository.deleteById(id);
	}
	@PutMapping("users/{id}")
	public ResponseEntity<String> update(@PathVariable("id") Integer id, @RequestBody User user) {
		try {
			userService.update(id, user);
			return new ResponseEntity<String>("success", HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
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
		Optional<User> userObj = userRepository.findByEmailAndPassword(user.getEmail(), user.getPassword());
		if (userObj.isPresent()) {
			return userObj.get();
		} else {
			return null;
		}
	}
}