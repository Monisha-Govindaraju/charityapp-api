package com.charityapp.charityappapi.validator;

import com.charityapp.charityappapi.model.User;

public class UserValidator {
	public static void validateUser(User user) throws Exception {
		if (user.getName() != null || user.getName().trim() == "") {
		} else {
			throw new Exception("The name cannot be empty");
		}
		if (user.getEmail().contains("@") && user.getEmail().contains(".com")) {
		} else {
			throw new Exception("Enter a valid email ID");
		}
		if (user.getPassword().length() > 8) {
		} else {
			throw new Exception("Enter a strong password");
		}
		if (user.getMobilenumber().length() == 10) {
		} else {
			throw new Exception("The mobile number should contain 10 digits");
		}
		System.out.println("You have registered successfully");
	}
}