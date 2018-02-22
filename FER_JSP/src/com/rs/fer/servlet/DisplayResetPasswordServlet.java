package com.rs.fer.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rs.fer.Util.HTMLUtil;

public class DisplayResetPasswordServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		PrintWriter out = resp.getWriter();

		HTMLUtil.generateHeaderAndLeftFrame(out);

		out.println("<form action='ResetPassword' method='post'>");
		out.println("<table border='1'>");
		out.println("<tr>");
		out.println("<td>Current Password</td>");
		out.println("<td align='center'><input type='password' name='currentPassword'></td>");
		out.println("</tr>");
		out.println("<tr>");
		out.println("<td>New Password</td>");
		out.println("<td align='center'><input type='password' name='newPassword'></td>");
		out.println("</tr>");
		out.println("<tr>");
		out.println("<td>Confirm Password</td>");
		out.println("<td align='center'><input type='password' name='newPassword'></td>");
		out.println("</tr>");
		out.println("<tr>");
		out.println("<td align='center' colspan='2'>");
		out.println("<input type='submit' value='Reset'>&nbsp;&nbsp;&nbsp;");
		out.println("</td>");
		out.println("</tr>");
		out.println("</table>");
		//amit

		HTMLUtil.generateFooter(out);
	}

}
