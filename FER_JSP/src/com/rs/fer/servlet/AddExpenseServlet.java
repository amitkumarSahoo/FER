package com.rs.fer.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rs.fer.Util.HTMLUtil;
import com.rs.fer.bean.Expense;
import com.rs.fer.service.FERService;
import com.rs.fer.service.FERServiceImpl;

public class AddExpenseServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("AddExpenseServlet.doPost()");
		PrintWriter out = response.getWriter();

		FERService ferService = new FERServiceImpl();

		Expense expense = new Expense();

		int noOfItems = Integer.parseInt(request.getParameter("numberOfItems"));
		expense.setExpense_type(request.getParameter("expenseType"));
		expense.setDate(request.getParameter("date"));
		expense.setPrice(request.getParameter("price"));
		expense.setNo_of_items(noOfItems);
		expense.setTotal(request.getParameter("total"));
		expense.setBywhom(request.getParameter("byWhom"));

		boolean addExpenseFlag = ferService.addExpense(expense);
		
		HTMLUtil.generateHeaderAndLeftFrame(out);
		if (addExpenseFlag) {

			out.println("Expense Add Successfully");
		}

		else {
			out.println("Add expense Failed");
		}
		HTMLUtil.generateFooter(out);
	}

}
