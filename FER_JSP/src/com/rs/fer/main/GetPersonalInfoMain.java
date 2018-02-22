package com.rs.fer.main;

import com.rs.fer.bean.PersonalInfo;
import com.rs.fer.bean.User;
import com.rs.fer.service.FERService;
import com.rs.fer.service.FERServiceImpl;

public class GetPersonalInfoMain {

	public static void main(String[] args) {

		User user = new User();
		FERService ferService = new FERServiceImpl();

		PersonalInfo personalInfo = ferService.getPersonalInfo("abc");

		if (personalInfo != null) {
			System.out.println(personalInfo.getUser().getUsername()+personalInfo.getAddress().getAddress_line1());

		} else {
			System.out.println("Please Enter A valid Id");
		}

	}

}
