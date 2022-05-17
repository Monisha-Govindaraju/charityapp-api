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

import com.charityapp.charityappapi.dao.CharityTrustRepository;
import com.charityapp.charityappapi.dto.MessageDTO;
import com.charityapp.charityappapi.model.CharityTrust;
import com.charityapp.charityappapi.service.CharityTrustService;


@RestController
public class CharityTrustController {
	@Autowired
	CharityTrustRepository trustRepository;
	
	@Autowired
	CharityTrustService trustService;
	@PostMapping("trust/save")
	public ResponseEntity<?> save(@RequestBody CharityTrust trust) {
		try {
			trustService.save(trust);
			MessageDTO message = new MessageDTO("Success");
			return new ResponseEntity<>(message, HttpStatus.OK);
		} catch (Exception e) {
			MessageDTO message = new MessageDTO(e.getMessage());
			return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
		}
	}
	@GetMapping("trust/list")
	public List<CharityTrust> findAll() {
		List<CharityTrust> trustlist = null;
		try {
			trustlist = trustService.findAll();
		} catch (Exception e) {
			e.getMessage();
		}
		return trustlist;
	}
}
