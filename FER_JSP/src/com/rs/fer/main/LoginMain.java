/*package com.rs.fer.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginMain {

	public static void main(String[] args) {
		Connection connection = null;
		PreparedStatement prSt = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/fer_jdbc", "root", "root");
			String query = "select * from user where username=? and password=?";
			prSt = connection.prepareStatement(query);
			prSt.setString(1, "admin");
			prSt.setString(2, "root");
			ResultSet resultset = prSt.executeQuery();
			while (resultset.next()) {
				if (resultset != null) {
					System.out.println("Valid user");
				} else {
					System.out.println("Invalid User");
				}
			}
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

import com.rs.fer.service.FERService;
import com.rs.fer.service.FERServiceImpl;


public class LoginMain {

	public static void main(String[] args) {

		String username = "sdfd";
		String password = "sdfd";
		
		FERService ferService = new FERServiceImpl();
		boolean loginFlag = ferService.login(username, password);
				
		if(loginFlag) {
			System.out.println("User is valid");
		}
		else {
			System.out.println("User is not valid");
		}
	}

}