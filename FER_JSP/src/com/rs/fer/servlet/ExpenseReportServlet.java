package com.rs.fer.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rs.fer.Util.HTMLUtil;
import com.rs.fer.bean.Expense;
import com.rs.fer.service.FERService;
import com.rs.fer.service.FERServiceImpl;

public class ExpenseReportServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("ExpenseReportServlet.doPost()");
		PrintWriter out = response.getWriter();

		FERService ferService = new FERServiceImpl();

		String expenseType = request.getParameter("expenseType");
		String fromDate = request.getParameter("fromDate");
		String toDate = request.getParameter("toDate");
		
		HTMLUtil.generateHeaderAndLeftFrame(out);
		List<Expense> expenses = ferService.getExpenseReport(expenseType, fromDate, toDate);
		if (expenses != null) {
			
			out.println("<table border='1' align='center'>");
			out.println("<tr height='50px'>");
			out.println("<td>Expense Type</td>");
			out.println("<td>Date</td>");
			out.println("<td>Price</td>");
			out.println("<td>Number of Items</td>");
			out.println("<td>Total</td>");
			out.println("<td>By Whom</td>");
			out.println("</tr>");
			for (Expense expense : expenses) {
				
				out.println("<tr>");
				out.println("<td>" + expense.getExpense_type() + "</td>");
				out.println("<td>" + expense.getDate() + "</td>");
				out.println("<td>" + expense.getPrice() + "</td>");
				out.println("<td>" + expense.getNo_of_items() + "</td>");
				out.println("<td>" + expense.getTotal() + "</td>");
				out.println("<td>" + expense.getBywhom() + "</td>");
				
				/*out.println("Type=" + expense.getExpense_type() + " Date-" + expense.getDate() + " No. of Items-"
						+ expense.getNo_of_items() + " Total-" + expense.getTotal() + " Price-" + expense.getPrice()
						+ " By-" + expense.getBywhom());*/
			}
			out.println("<td colspan='2'></td></tr></table>");
		}
		else {
			out.println("No Expenses Found For the Given input");
		}
		HTMLUtil.generateFooter(out);
	}

}
