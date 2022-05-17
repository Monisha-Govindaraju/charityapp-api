package com.charityapp.charityappapi.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.charityapp.charityappapi.model.CharityTrust;

public interface CharityTrustRepository extends JpaRepository<CharityTrust, Integer> {
	
}
