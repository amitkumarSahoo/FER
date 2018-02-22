package com.rs.fer.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.rs.fer.Util.HTMLUtil;
import com.rs.fer.bean.Expense;
import com.rs.fer.service.FERService;
import com.rs.fer.service.FERServiceImpl;

public class EditExpenseServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("EditExpenseServlet.doPost()");
		PrintWriter out = response.getWriter();
		FERService ferService = new FERServiceImpl();
		HttpSession session = request.getSession();
		Expense expense = new Expense();
		
		int numberOfItems = Integer.parseInt(request.getParameter("numberOfItems"));
		int expenseId= Integer.parseInt(session.getAttribute("expenseId").toString());
		
		expense.setExpense_id(expenseId);
		expense.setExpense_type(request.getParameter("expenseType"));
		expense.setDate(request.getParameter("date"));
		expense.setPrice(request.getParameter("price"));
		expense.setNo_of_items(numberOfItems);
		expense.setTotal(request.getParameter("total"));
		expense.setBywhom(request.getParameter("byWhom"));

		boolean editExpenseReportFlag = ferService.editExpense(expense);
		
		HTMLUtil.generateHeaderAndLeftFrame(out);
		if (editExpenseReportFlag) {
			out.println("edit successfully");
		} else {
			out.println("edit failed");
		}
		HTMLUtil.generateFooter(out);
	}
	
}
