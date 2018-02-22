package com.rs.fer.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rs.fer.bean.User;
import com.rs.fer.service.FERService;
import com.rs.fer.service.FERServiceImpl;

public class RegistrationServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("RegistrationServlet.doPost()");
		PrintWriter out = response.getWriter();
		
		FERService ferService = new FERServiceImpl();

		User user = new User();
		user.setFirst_name(request.getParameter("firstName"));
		user.setMiddle_name(request.getParameter("middleName"));
		user.setLast_name(request.getParameter("lastName"));
		user.setEmail(request.getParameter("email"));
		user.setUsername(request.getParameter("username"));
		user.setPassword(request.getParameter("password"));
		user.setPhone_number(request.getParameter("phoneNumber"));

		boolean registrationFlag = ferService.registration(user);
		if (registrationFlag) {
			out.println("Registration Successfull");
		} else {
			out.println("Unable To Register");
		}
		
		RequestDispatcher requestdispatcher = request.getRequestDispatcher("Login.html");
		requestdispatcher.include(request, response);
		
	}

}
