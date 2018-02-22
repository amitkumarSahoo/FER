<%@page
	import="com.rs.fer.service.FERService,com.rs.fer.service.FERServiceImpl,com.rs.fer.bean.User"%>
<%
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
		out.println("Registration success");
	} else {
		out.println("Registration failed");
	}
%>


<jsp:include page="Login.jsp" />