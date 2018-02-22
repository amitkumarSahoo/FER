package com.rs.fer.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rs.fer.Util.HTMLUtil;

public class DisplayAddExpenseServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();

		HTMLUtil.generateHeaderAndLeftFrame(out);
		
		out.println("<form action='AddExpense' method='post'>");
		out.println("<table border='1'>");
		out.println("<tr>");
		out.println("<td align='center' colspan='2'>Add Expense</td>");
		out.println("</tr>");

		out.println("<tr>");
		out.println("<td>Expense Type</td>");
		out.println("<td align='center'><input type='text' name='expenseType'>");
		out.println("</td>");
		out.println("</tr>");
		
		out.println("<tr>");
		out.println("<td>Date</td>");
		out.println("<td align='center'>");
		out.println("<input type='text' name='date'></td>");
		out.println("</tr>");
		
		out.println("<tr>");
		out.println("<td>Price</td>");
		out.println("<td align='center'><input type='text' name='price'></td>");
		out.println("</tr>");

		out.println("<tr>");
		out.println("<td>Number Of Items</td>");
		out.println("<td align='center'><input type='text' name='numberOfItems'></td>");
		out.println("</tr>");

		out.println("<tr>");
		out.println("<td>Total</td>");
		out.println("<td align='center'>");
		out.println("<input type='text' name='total'></td>");
		out.println("</tr>");

		out.println("<tr>");
		out.println("<td>ByWhom</td>");
		out.println("<td align='center'><input type='text' name='byWhom'>");
		out.println("</td>");
		out.println("</tr>");

		out.println("<tr>");
		out.println("<td align='center' colspan='2'>");
		out.println("<input type='submit' value='AddExpense'>&nbsp;&nbsp;&nbsp;");
		out.println("</tr>");
		out.println("</table>");
		
		HTMLUtil.generateFooter(out);
	}

}