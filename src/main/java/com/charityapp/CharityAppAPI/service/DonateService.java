package com.charityapp.charityappapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.charityapp.charityappapi.dao.DonateRepository;
import com.charityapp.charityappapi.model.Donate;
import com.charityapp.charityappapi.validation.DonateValidation;


@Service
public class DonateService {
	@Autowired
	DonateRepository donateRepository;

	public void save(Donate donate) throws Exception {
		try {
			DonateValidation.validateDonate(donate);
			donateRepository.save(donate);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	public List<Donate> findAll() throws Exception {
		List<Donate> listDonate = null;
		try {
			listDonate = donateRepository.findAll();
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
		return listDonate;
	}
}