package com.rs.fer.main;

import com.rs.fer.bean.Address;
import com.rs.fer.bean.PersonalInfo;
import com.rs.fer.bean.User;
import com.rs.fer.service.FERService;
import com.rs.fer.service.FERServiceImpl;

public class UpdatePersonalInfoMain {

	public static void main(String[] args) {

		User user = new User();
		user.setFirst_name("mahendra");
		user.setMiddle_name("singh");
		user.setLast_name("dhoni");
		user.setEmail("msd@gmail.com");
		user.setUsername("msd");
		user.setPassword("bcci");
		user.setPhone_number("77777");
		user.setId(4);

		Address address = new Address();
		address.setAddress_line1("ranchi");
		address.setAddress_line2("delhi");
		address.setCity("chennai");
		address.setState("ts");
		address.setZip("500081");
		address.setCountry("india");
		address.setUser_id(user.getId());
		address.setId(4);

		FERService ferService = new FERServiceImpl();
		PersonalInfo personalInfo = new PersonalInfo();
		personalInfo.setUser(user);
		personalInfo.setAddress(address);
		
		boolean personalInfoFlag = ferService.updatePersonalInfo(user, address);
		
		
		if (personalInfoFlag) {
			System.out.println("personal info updated successfully");
		} else {
			System.out.println("unable to update");
		}
	}
}
