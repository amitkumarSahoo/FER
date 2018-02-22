/*package com.rs.fer.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ResetPasswordMain {

	public static void main(String[] args) {
		Connection connection = null;
		PreparedStatement prSt = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/fer_jdbc", "root", "root");
			String query = "update user set password =? where username=? and password=?";
			prSt = connection.prepareStatement(query);
			prSt.setString(1, "user@123");
			prSt.setString(2, "sachin");
			prSt.setString(3, "100200");
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

import com.rs.fer.service.FERService;
import com.rs.fer.service.FERServiceImpl;

public class ResetPasswordMain {

	public static void main(String[] args) {

		FERService ferService = new FERServiceImpl();
		boolean resetPasswordFlag = ferService.resetPassword("user123", "sachin","user@123");
		
		if (resetPasswordFlag) {
			System.out.println("user is valid");
		} else {
			System.out.println("user is invalid");
		}

	}
}
