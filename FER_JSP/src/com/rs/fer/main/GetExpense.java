package com.rs.fer.main;

import com.rs.fer.bean.Expense;
import com.rs.fer.service.FERService;
import com.rs.fer.service.FERServiceImpl;

public class GetExpense {

	public static void main(String[] args) {

		int expense_id = 3;
		FERService ferService = new FERServiceImpl();

		Expense expense = ferService.getExpense(expense_id);

		if (expense != null) {
			
			System.out.println("Get Expense " + " Type-"+expense.getExpense_type()+ " Date-"+expense.getDate()+ " No. of Items-"+expense.getNo_of_items()+ " Total-"+expense.getTotal()+ " Price-"+expense.getPrice()+ " By-"+expense.getBywhom());
		} else {
			System.out.println("Get Expense failed...");
		}

	}

}
