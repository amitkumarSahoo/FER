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

public class DisplayPersonalAddressServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		PersonalInfo personalInfo = (PersonalInfo) session.getAttribute("personalInfo");
		personalInfo.getUser().setEmail(request.getParameter("email"));
		personalInfo.getUser().setPhone_number(request.getParameter("phoneNumber"));

		PrintWriter out = response.getWriter();

		HTMLUtil.generateHeaderAndLeftFrame(out);

		out.println("<form action='Update' method='post'>");
		out.println("<table frame='box' align='center' width='500px' height='250px'>");
		out.println("<tr>");
		out.println("<td align='left' colspan='2' height='80px'><u>Address Information</u>");
		out.println("</tr>");
		out.println("<tr>");
		out.println("<td align='center'>Address Line 1</td>");
		out.println("<td align='center'><input type='text' name='addressLine1' value='"
				+ personalInfo.getAddress().getAddress_line1() + "'></td>");
		out.println("</tr>");
		out.println("<tr>");
		out.println("<td align='center'>Address Line 2</td>");
		out.println("<td align='center'><input type='text' name='addressLine2' value='"
				+ personalInfo.getAddress().getAddress_line2() + "'></td>");
		out.println("</tr>");
		out.println("<tr>");
		out.println("<td align='center'>City</td>");
		out.println("<td align='center'><input type='text' name='city' value='" + personalInfo.getAddress().getCity()
				+ "'></td>");
		out.println("</tr>");
		out.println("<tr>");
		out.println("<td align='center'>State</td>");
		out.println("<td align='center'><input type='text' name='state' value='" + personalInfo.getAddress().getState()
				+ "'></td>");
		out.println("</tr>");
		out.println("<tr>");
		out.println("<td align='center'>Zip</td>");
		out.println("<td align='center'><input type='text' name='zip' value='" + personalInfo.getAddress().getZip()
				+ "'></td>");
		out.println("</tr>");
		out.println("<tr>");
		out.println("<td align='center'>Country</td>");
		out.println("<td align='center'><input type='text' name='country' value='"
				+ personalInfo.getAddress().getCountry() + "'></td>");
		out.println("</tr>");
		out.println("<tr>");
		out.println("<td align='right' colspan='2'>");
		out.println("<input type='submit' value='Review'>&nbsp;&nbsp;&nbsp;");
		out.println("</td>");
		out.println("</tr>");
		out.println("</table>");

		HTMLUtil.generateFooter(out);

	}
}