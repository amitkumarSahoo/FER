/*package com.rs.fer.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DeleteExpenseMain {

	public static void main(String[] args) {
		Connection connection = null;
		PreparedStatement prSt = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/fer_jdbc", "root", "root");
			String query = "delete from expense where expense_id=?";
			prSt = connection.prepareStatement(query);
			prSt.setInt(1, 1);
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

public class DeleteExpenseMain {

	public static void main(String[] args) {

		FERService ferService = new FERServiceImpl();
		boolean deleteExpenseFlag = ferService.deleteExpense(6);
		if (deleteExpenseFlag) {
			System.out.println("Delete Successfully");
		}else {
			System.out.println("Delete Failed");
		}
		
		}
}		
