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

public class LoginServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("LoginHttpServlet.doPost()");

		PrintWriter out = response.getWriter();

		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		HttpSession session = request.getSession();
		session.setAttribute("username", username);

		FERService ferService = new FERServiceImpl();
		boolean loginFlag = ferService.login(username, password);

		if (loginFlag) {
			HTMLUtil.generateHeaderAndLeftFrame(out);
			
			out.println("Welcome to the User");
			
			HTMLUtil.generateFooter(out);
		} else {
			out.println("User is not valid");
		}

	}

}
