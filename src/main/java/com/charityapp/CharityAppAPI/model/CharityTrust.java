package com.charityapp.charityappapi.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
@Entity(name = "ecommerce_charity_trust")
public class CharityTrust {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	@Column(name = "organisation_name")
	private String organisationname;
	@Column(name = "email")
	private String email;
	@Column(name = "address")
	private String address;
	@Column(name = "district")
	private String district;
	@Column(name = "state")
	private String state;
	
}
