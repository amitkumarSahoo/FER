package com.rs.fer.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.rs.fer.Util.HTMLUtil;
import com.rs.fer.bean.Expense;
import com.rs.fer.service.FERService;
import com.rs.fer.service.FERServiceImpl;

public class DisplayEditExpenseDropdownServlet extends HttpServlet {

	FERService ferService = null;

	@Override
	public void init(ServletConfig config) throws ServletException {
		ferService = new FERServiceImpl();
		super.init(config);
	}

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();

		HTMLUtil.generateHeaderAndLeftFrame(out);
		List<Expense> expenses = ferService.getExpenses();

		out.println("<form action='EditExpenseDropdown' method='post'>");
		out.println("<table border='1'>");

		out.println("<align='center'>ExpenseId <select name='expenseId'>");
		for (Expense expense : expenses)
			out.println("<option value='" + expense.getExpense_id() + "'>" + expense.getExpense_id() + "</option>");

		out.println("</select> <br> <br> <input type='submit' value='Edit'>&nbsp;&nbsp;&nbsp;");
		out.println("</td>");

		out.println("</table>");
		HTMLUtil.generateFooter(out);
	}

}
