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
@Entity(name = "ecommerce_donation")
public class Donate {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	@Column(name = "donation_amount")
	private String donationamount;
	@Column(name = "donation_categories")
	private String donationcategories;
}
