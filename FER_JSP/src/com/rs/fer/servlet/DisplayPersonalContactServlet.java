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

public class DisplayPersonalContactServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();

		PersonalInfo personalInfo = (PersonalInfo) session.getAttribute("personalInfo");

		personalInfo.getUser().setFirst_name(request.getParameter("firstName"));
		personalInfo.getUser().setMiddle_name(request.getParameter("middleName"));
		personalInfo.getUser().setLast_name(request.getParameter("lastName"));

		PrintWriter out = response.getWriter();
		HTMLUtil.generateHeaderAndLeftFrame(out);

		out.println("<form action='AddressInfo' method='post'>");
		out.println("<table frame='box' align='center'width='500px' height='250px'>");
		out.println("<tr height='80px'>");
		out.println("<td align='left' colspan='2'><u>Contact Information</u>");
		out.println("</tr>");
		out.println("<tr>");
		out.println("<td align='center'>E-mail</td>");
		out.println("<td align='center'><input type='text' name='email' value='" + personalInfo.getUser().getEmail() + "'></td>");
		out.println("</tr>");
		out.println("<tr>");
		out.println("<td align='center'>Phone Number</td>");
		out.println("<td align='center'><input type='text' name='phoneNumber' value='" + personalInfo.getUser().getPhone_number() + "'></td>");
		out.println("</tr>");
		out.println("<tr>");
		out.println("<td align='right' colspan='2'>");
		out.println("<input type='submit' value='Next'>&nbsp;&nbsp;&nbsp;");
		out.println("</td>");
		out.println("</tr>");
		out.println("</table>");

		HTMLUtil.generateFooter(out);
	}
}
