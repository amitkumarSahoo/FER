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

public class EditExpenseDropdownServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		
		FERService ferservice = new FERServiceImpl();

		int expenseId = Integer.parseInt(request.getParameter("expenseId"));

		Expense expense = ferservice.getExpense(expenseId);
		
		HttpSession session = request.getSession();
		session.setAttribute("expenseId", expenseId);
		
		HTMLUtil.generateHeaderAndLeftFrame(out);
		
		out.println("<form action='EditExpense' method='post'>");
		out.println("<table border='1'>");
		out.println("<tr>");
		out.println("<td align='center' colspan='2'>Edit Expense</td>");
		out.println("</tr>");

		out.println("<tr>");
		out.println("<td>Expense Type</td>");
		out.println("<td align='center'><input type='text' name='expenseType' value=" + expense.getExpense_type() + ">");
		out.println("</td>");
		out.println("</tr>");

		out.println("<tr>");
		out.println("<td>Date</td>");
		out.println("<td align='center'><input type='text' name='date' value=" + expense.getDate() + ">");
		out.println("</td>");
		out.println("</tr>");

		out.println("<tr>");
		out.println("<td>Price</td>");
		out.println("<td align='center'><input type='text' name='price' value=" + expense.getPrice() + ">");
		out.println("</td>");
		out.println("</tr>");

		out.println("<tr>");
		out.println("<td>Number Of Items</td>");
		out.println("<td align='center'><input type='text' name='numberOfItems' value=" + expense.getNo_of_items() + "></td>");
		out.println("</tr>");

		out.println("<tr>");
		out.println("<td>Total</td>");
		out.println("<td align='center'><input type='text' name='total' value=" + expense.getTotal() + ">");
		out.println("</td>");
		out.println("</tr>");

		out.println("<tr>");
		out.println("<td>ByWhom</td>");
		out.println("<td align='center'><input type='text' name='byWhom' value=" + expense.getBywhom() + ">");
		out.println("</td>");
		out.println("</tr>");

		out.println("<tr>");
		out.println("<td align='center' colspan='2'>");
		out.println("<input type='submit' value='Edit'>&nbsp;&nbsp;&nbsp;");
		out.println("</td>");
		out.println("</tr>");
		out.println("</table>");

		HTMLUtil.generateFooter(out);
		
	}

	
	
}
