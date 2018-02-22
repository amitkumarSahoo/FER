<%@page
	import="com.rs.fer.service.FERService,com.rs.fer.service.FERServiceImpl,com.rs.fer.bean.Expense"%>
<%@ page session="false"%>
<%
	FERService ferService = new FERServiceImpl();
	HttpSession session = request.getSession();

	String username = session.getAttribute("username").toString();
	String newPassword = request.getParameter("newPassword");
	String currentPassword = request.getParameter("currentPassword");

	boolean resetPasswordFlag = ferService.resetPassword(newPassword, username, currentPassword);

	if (resetPasswordFlag) {
%>
<jsp:include page="HeaderAndLeftFrame.jsp" />

<%
	out.println("Reset Password Successfully");
	} else {
		out.println("Reset Failed");
	}
%>
<jsp:include page="Footer.jsp" />
