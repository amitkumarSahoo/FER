/*package com.rs.fer.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class GetExpensesMain {

	public static void main(String[] args) {
		Connection connection = null;
		PreparedStatement prSt = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/fer_jdbc", "root", "root");
			String query = "select * from expense ";
			prSt = connection.prepareStatement(query);
			ResultSet resultset = prSt.executeQuery();
			while (resultset.next()) {
				System.out.println("Expense Id: " + resultset.getInt(1) + " ExpenseType: " + resultset.getString(2)
						+ "  Date: " + resultset.getString(3) + "  Total: " + resultset.getString(6) + "  By whom: "
						+ resultset.getString(7));
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

import java.util.List;

import com.rs.fer.bean.Expense;
import com.rs.fer.service.FERService;
import com.rs.fer.service.FERServiceImpl;


		public class GetExpensesMain {

			public static void main(String[] args) {
			

				FERService ferService = new FERServiceImpl();
				List<Expense> expenses = ferService.getExpenses();
				if (expenses != null ){

					for (Expense expense : expenses) {
						System.out.println("expensetype=" + expense.getExpense_type()+" Date-"+expense.getDate()+ " No. of Items-"+expense.getNo_of_items()+ " Total-"+expense.getTotal()+ " Price-"+expense.getPrice()+ " By-"+expense.getBywhom());
					}
				}
				else {
					System.out.println("expense not found");
				}

			}
		}
