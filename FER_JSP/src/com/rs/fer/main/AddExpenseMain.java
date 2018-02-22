/*package com.rs.fer.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AddExpenseMain {

	public static void main(String[] args) {
		Connection connection = null;
		PreparedStatement prSt = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/fer_jdbc", "root", "root");
			String query = "insert into expense(expense_type, date, price, no_of_items, total, bywhom) values(?,?,?,?,?,?)";
			prSt = connection.prepareStatement(query);
			prSt.setString(1, "mobile");
			prSt.setString(2, "24.11.17");
			prSt.setString(3, "15000");
			prSt.setString(4, "2");
			prSt.setString(5, "30000");
			prSt.setString(6, "amit");

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

import com.rs.fer.bean.Expense;
import com.rs.fer.service.FERService;
import com.rs.fer.service.FERServiceImpl;

public class AddExpenseMain {

	public static void main(String[] args) {
		FERService ferService = new FERServiceImpl();
		Expense expense = new Expense();

		expense.setExpense_type("ABC");
		expense.setDate("15/9/2017");
		expense.setPrice("100");
		expense.setNo_of_items(2);
		expense.setTotal("3");
		expense.setBywhom("xyx");

		boolean addExpenseFlag = ferService.addExpense(expense);

		if (addExpenseFlag) {

			System.out.println("Expense Add Successfully");
		}

		else {
			System.out.println("Add expense Failed");
		}

	}

}