package com.charityapp.charityappapi.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.charityapp.charityappapi.model.Donate;

public interface DonateRepository extends JpaRepository<Donate, Integer> {

}
