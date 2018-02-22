package com.rs.fer.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rs.fer.Util.HTMLUtil;

public class DisplayExpenseReportServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		PrintWriter out = response.getWriter();

		HTMLUtil.generateHeaderAndLeftFrame(out);
		
		out.println("<form action='ExpenseReport' method='post'>");
		out.println("<table border='1' align='center'>");
		out.println("<tr height='50px'>");
		out.println("<td align='center' colspan='2' height='80px'>Expense Report");
		out.println("</tr>");
		out.println("<tr>");
		out.println("<td align='center'>Expense Type</td>");
		out.println("<td align='center'><input type='text' name='expenseType'></td>");
		out.println("</tr>");
		out.println("<tr>");
		out.println("<td align='center'>From Date</td>");
		out.println("<td align='center'><input type='text' name='fromDate'></td>");
		out.println("</tr>");
		out.println("<tr>");
		out.println("<td align='center'>To Date</td>");
		out.println("<td align='center'><input type='text' name='toDate'></td>");
		out.println("</tr>");
		out.println("<tr>");
		out.println("<td align='center' colspan='2'>");
		out.println("<input type='submit' value='GetReport'>&nbsp;&nbsp;&nbsp;");
		out.println("</tr>");
		out.println("</table>");
		
		HTMLUtil.generateFooter(out);
	}

}
