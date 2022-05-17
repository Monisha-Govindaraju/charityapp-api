package com.charityapp.charityappapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.charityapp.charityappapi.dao.CharityTrustRepository;
import com.charityapp.charityappapi.model.CharityTrust;
import com.charityapp.charityappapi.validation.CharityTrustValidation;



@Service
public class CharityTrustService {
	@Autowired
	CharityTrustRepository trustRepository;

	public void save(CharityTrust trust) throws Exception {
		try {
			CharityTrustValidation.validateCharityTrust(trust);
			trustRepository.save(trust);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	public List<CharityTrust> findAll() throws Exception {
		List<CharityTrust> listCharityTrust = null;
		try {
			listCharityTrust = trustRepository.findAll();
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
		return listCharityTrust;
	}
}