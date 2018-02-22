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

public class UpdatePersonalInfoServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		FERService ferservice = new FERServiceImpl();
		HttpSession session = request.getSession();
		PersonalInfo personalInfo = (PersonalInfo) session.getAttribute("personalInfo");
		PrintWriter out = response.getWriter();
		boolean updateFlag = ferservice.updatePersonalInfo(personalInfo.getUser(), personalInfo.getAddress());
		HTMLUtil.generateHeaderAndLeftFrame(out);
		if (updateFlag) {
			out.println("Information Updated Succssfully");
		} else {
			out.println("Unable To Update");
		}
		HTMLUtil.generateFooter(out);
	}

}
