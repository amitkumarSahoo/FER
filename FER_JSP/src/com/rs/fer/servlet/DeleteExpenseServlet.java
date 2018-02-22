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

public class DeleteExpenseServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("DeleteExpenseServlet.doPost()");
		PrintWriter out = response.getWriter();

		FERService ferService = new FERServiceImpl();
		
		int expenseId =  Integer.parseInt(request.getParameter("expenseId"));
		
		
		boolean deleteExpenseFlag = ferService.deleteExpense(expenseId);
		
		HTMLUtil.generateHeaderAndLeftFrame(out);
		if (deleteExpenseFlag) {
			out.println("Delete Successfully");
		}else {
			out.println("Delete Failed");
		}
		HTMLUtil.generateFooter(out);
		
	}
	
}
