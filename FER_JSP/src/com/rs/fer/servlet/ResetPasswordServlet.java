package com.rs.fer.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.rs.fer.Util.HTMLUtil;
import com.rs.fer.service.FERService;
import com.rs.fer.service.FERServiceImpl;

public class ResetPasswordServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("ResetPasswordServlet.doPost()");
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();

		String username = session.getAttribute("username").toString();
		String newPassword = request.getParameter("newPassword");
		String currentPassword = request.getParameter("currentPassword");

		FERService ferService = new FERServiceImpl();
		boolean resetPasswordFlag = ferService.resetPassword(newPassword, username, currentPassword);

		HTMLUtil.generateHeaderAndLeftFrame(out);
		if (resetPasswordFlag) {
			out.println("Reset Password Successfully");
		} else {
			out.println("Reset Failed");
		}
		HTMLUtil.generateFooter(out);
	}

}
