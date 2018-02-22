<%@page
	import="com.rs.fer.service.FERService,com.rs.fer.service.FERServiceImpl"%>

<%
	FERService ferService = new FERServiceImpl();
	String username = request.getParameter("username");
	String password = request.getParameter("password");
	session.setAttribute("username", username);
	boolean loginFlag = ferService.login(username, password);
	if (loginFlag) {
%>
<jsp:include page="HeaderAndLeftFrame.jsp"/>
<%
	out.println("Welcome to the User");
%>
<jsp:include page="Footer.jsp"/>
<%
	} else {
		out.println("User is not authorized");
	}
%>