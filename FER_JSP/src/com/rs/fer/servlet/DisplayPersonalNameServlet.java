package com.rs.fer.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.rs.fer.Util.HTMLUtil;
import com.rs.fer.bean.PersonalInfo;
import com.rs.fer.service.FERService;
import com.rs.fer.service.FERServiceImpl;

public class DisplayPersonalNameServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		
		FERService ferservice = new FERServiceImpl();
		HttpSession session = request.getSession();
		
		String username = session.getAttribute("username").toString();
		PersonalInfo personalInfo = ferservice.getPersonalInfo(username);
		session.setAttribute("personalInfo", personalInfo);
		
		PrintWriter out = response.getWriter();
		HTMLUtil.generateHeaderAndLeftFrame(out);

		out.println("<form action='ContactInfo' method='post'>");
		out.println("<table frame='box' align='center' width='500px' height='250px'>");
		out.println("<tr>");
		out.println("<td align='left' colspan='2' height='80px'><u>Name Information</u>");
		out.println("</tr>");
		out.println("<tr>");
		out.println("<td align='center'>First Name</td>");
		out.println("<td align='center'><input type='text' name='firstName' value='" + personalInfo.getUser().getFirst_name() + "'></td>");
		out.println("</tr>");
		out.println("<tr>");
		out.println("<td align='center'>Middle Name</td>");
		out.println("<td align='center'><input type='text' name='middleName' value='" + personalInfo.getUser().getMiddle_name() + "'></td>");
		out.println("</tr>");
		out.println("<tr>");
		out.println("<td align='center'>Last Name</td>");
		out.println("<td align='center'><input type='text' name='lastName' value='" + personalInfo.getUser().getLast_name() + "'></td>");
		out.println("</tr>");
		out.println("<tr>");
		out.println("<td align='right' colspan='2'>");
		out.println("<input type='submit' value='Next'>&nbsp;&nbsp;&nbsp;");
		out.println("</tr>");
		out.println("</table>");

		HTMLUtil.generateFooter(out);

	}
}
