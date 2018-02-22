<%@page import="com.rs.fer.service.FERServiceImpl"%>
<%@page import="com.rs.fer.service.FERService"%>

<%
	String email = (request.getParameter("email") == null) ? "" : request.getParameter("email").trim();

	FERService ferService = new FERServiceImpl();
	boolean isEmailAvailable = ferService.isEmailAvailable(email);	
	out.println(isEmailAvailable ? "Y" : "N");
%>