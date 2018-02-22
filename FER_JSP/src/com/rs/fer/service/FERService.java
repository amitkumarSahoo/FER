package com.rs.fer.service;

import java.util.List;

import com.rs.fer.bean.Address;
import com.rs.fer.bean.Expense;
import com.rs.fer.bean.PersonalInfo;
import com.rs.fer.bean.User;

public interface FERService {
	public boolean login(String username, String password);

	public boolean registration(User user);

	boolean addExpense(Expense expense);

	boolean deleteExpense(int id);

	boolean editExpense(Expense expense);

	public Expense getExpense(int expense_id);

	boolean resetPassword(String username, String oldPassword, String newPassword);
	
	public List<Expense> getExpenses();
	
	public List<Expense> getExpenseReport(String expense_type, String fromdate, String todate);
	
	public PersonalInfo getPersonalInfo(String username);
	
	public boolean updatePersonalInfo(User user, Address address);
	
	boolean isEmailAvailable(String email);

}
