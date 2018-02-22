<%@page
	import="com.rs.fer.service.FERService,com.rs.fer.service.FERServiceImpl,com.rs.fer.bean.PersonalInfo, com.rs.fer.bean.User"%>
<%@ page session="false"%>
<%
	FERService ferservice = new FERServiceImpl();
	HttpSession session = request.getSession();
	PersonalInfo personalInfo = (PersonalInfo) session.getAttribute("personalInfo");
	boolean updateFlag = ferservice.updatePersonalInfo(personalInfo.getUser(), personalInfo.getAddress());
	if (updateFlag) {
%>
<jsp:include page="HeaderAndLeftFrame.jsp" />
<%
	out.println("Information Updated Succssfully");
	} else {
		out.println("Unable To Update");
	}
%>
<jsp:include page="Footer.jsp" />