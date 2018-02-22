package com.rs.fer.main;

import com.rs.fer.bean.Expense;
import com.rs.fer.service.FERService;
import com.rs.fer.service.FERServiceImpl;

public class EditExpenseMain {

	public static void main(String[] args) {
		FERService ferService = new FERServiceImpl();
		Expense expense = new Expense();
		expense.setExpense_type("mobile");
		expense.setDate("15.7.2017");
		expense.setPrice("200");
		expense.setNo_of_items(3);
		expense.setTotal("2");
		expense.setBywhom("me");
		expense.setExpense_id(1);

		boolean editExpenseReportFlag = ferService.editExpense(expense);

		if (editExpenseReportFlag) {
			System.out.println("edit successfully");
		} else {
			System.out.println("edit failed");
		}
	}

}
