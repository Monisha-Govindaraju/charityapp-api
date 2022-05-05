package com.charityapp.charityappapi.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.charityapp.charityappapi.model.User;

public interface UserRepository extends JpaRepository<User, Integer> {

	Optional<User> findByEmailAndPassword(String email, String password);

}
