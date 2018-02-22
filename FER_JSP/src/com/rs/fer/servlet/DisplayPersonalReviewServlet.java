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

public class DisplayPersonalReviewServlet extends HttpServlet {
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		PersonalInfo PersonalInfo = (PersonalInfo) session.getAttribute("personalInfo");

		PersonalInfo.getAddress().setAddress_line1(request.getParameter("addressLine1"));
		PersonalInfo.getAddress().setAddress_line2(request.getParameter("addressLine2"));
		PersonalInfo.getAddress().setCity(request.getParameter("city"));
		PersonalInfo.getAddress().setState(request.getParameter("state"));
		PersonalInfo.getAddress().setZip(request.getParameter("zip"));
		PersonalInfo.getAddress().setCountry(request.getParameter("country"));

		PrintWriter out = response.getWriter();
		HTMLUtil.generateHeaderAndLeftFrame(out);
		
		out.println("<form action='UpdatePersonal' method='post'>");
		out.println("<table border='1'>");
		out.println("<tr>");
		out.println("<td>FirstName</td>");
		out.println("<td>" + PersonalInfo.getUser().getFirst_name() + "</td>");
		out.println("</tr>");

		out.println("<tr>");
		out.println("<td>MiddleName</td>");
		out.println("<td>" + PersonalInfo.getUser().getMiddle_name() + "</td>");
		out.println("</tr>");

		out.println("<tr>");
		out.println("<td>LastName</td>");
		out.println("<td>" + PersonalInfo.getUser().getLast_name() + "</td>");
		out.println("</tr>");

		out.println("<tr>");
		out.println("<td>Emailid</td>");
		out.println("<td>" + PersonalInfo.getUser().getEmail() + "</td>");
		out.println("</tr>");

		out.println("<tr>");
		out.println("<td>Mobile</td>");
		out.println("<td>" + PersonalInfo.getUser().getPhone_number() + "</td>");
		out.println("</tr>");

		out.println("<tr>");
		out.println("<td>Address Line 1</td>");
		out.println("<td>" + PersonalInfo.getAddress().getAddress_line1() + "</td>");
		out.println("</tr>");

		out.println("<tr>");
		out.println("<td>Address Line 2</td>");
		out.println("<td>" + PersonalInfo.getAddress().getAddress_line2() + "</td>");
		out.println("</tr>");

		out.println("<tr>");
		out.println("<td>City</td>");
		out.println("<td>" + PersonalInfo.getAddress().getCity() + "</td>");
		out.println("</tr>");

		out.println("<tr>");
		out.println("<td>State</td>");
		out.println("<td>" + PersonalInfo.getAddress().getState() + "</td>");
		out.println("</tr>");

		out.println("<tr>");
		out.println("<td>Zip</td>");
		out.println("<td>" + PersonalInfo.getAddress().getZip() + "</td>");
		out.println("</tr>");

		out.println("<tr>");
		out.println("<td>Country</td>");
		out.println("<td>" + PersonalInfo.getAddress().getCountry() + "</td>");
		out.println("</tr>");

		out.println("<tr>");
		out.println("<td align='center' colspan='2'>");
		out.println("<input type='submit' value='Update'>&nbsp;&nbsp;&nbsp;</td>");
		out.println("</tr>");
		out.println("</table>");

		HTMLUtil.generateFooter(out);

	}

}
