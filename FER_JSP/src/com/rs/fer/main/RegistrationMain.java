/*package com.rs.fer.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class RegistrationMain {

	public static void main(String[] args) {

		Connection connection = null;
		PreparedStatement prSt = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/fer_jdbc", "root", "root");
			String query = "insert into user(first_name, middle_name , last_name, username, password, email, phone_number) values(?,?,?,?,?,?,?)";
			prSt = connection.prepareStatement(query);
			prSt.setString(1, "amit");
			prSt.setString(2, "kumar");
			prSt.setString(3, "sahoo");
			prSt.setString(4, "admin");
			prSt.setString(5, "root");
			prSt.setString(6, "amit@gmail.com");
			prSt.setString(7, "9938228662");

			int i = prSt.executeUpdate();
			System.out.println("Number of records numOfRecsEffected: " + i);
			connection.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception ex) {
		}
	}
}
*/
package com.rs.fer.main;

import com.rs.fer.bean.User;
import com.rs.fer.service.FERService;
import com.rs.fer.service.FERServiceImpl;

public class RegistrationMain {

	public static void main(String[] args) {

		FERService ferService = new FERServiceImpl();

		User user = new User();
		user.setFirst_name("rohit");
		user.setMiddle_name("sharma");
		user.setLast_name("india");
		user.setEmail("rsi@gmail.com");
		user.setUsername("admin");
		user.setPassword("1234");
		user.setPhone_number("987654321");

		boolean registrationFlag = ferService.registration(user);
		if (registrationFlag) {
			System.out.println("Registration Successfull");
		} else {
			System.out.println("Unable To Register");
		}

	}

}