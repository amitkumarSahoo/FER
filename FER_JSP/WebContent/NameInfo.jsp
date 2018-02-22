<%@page
	import="com.rs.fer.service.FERService,com.rs.fer.service.FERServiceImpl,com.rs.fer.bean.PersonalInfo, com.rs.fer.bean.User"%>
	<%@ page session="false" %>
<% 		
		FERService ferservice = new FERServiceImpl();
		HttpSession session = request.getSession();
		
		String username = session.getAttribute("username").toString();
		PersonalInfo personalInfo = ferservice.getPersonalInfo(username);
		session.setAttribute("personalInfo", personalInfo);
%>		
<jsp:include page="HeaderAndLeftFrame.jsp"/>
		<form action='ContactInfo.jsp' method='post'>
		<table frame='box' align='center' width='500px' height='250px'>
		<tr>
		<td align='left' colspan='2' height='80px'><u>Name Information</u>
		</tr>
		<tr>
		<td align='center'>First Name</td>
		<td align='center'><input type='text' name='firstName' value=<%= personalInfo.getUser().getFirst_name()%>></td>
		</tr>
		<tr>
		<td align='center'>Middle Name</td>
		<td align='center'><input type='text' name='middleName' value=<%= personalInfo.getUser().getMiddle_name()%>></td>
		</tr>
		<tr>
		<td align='center'>Last Name</td>
		<td align='center'><input type='text' name='lastName' value=<%= personalInfo.getUser().getLast_name()%>></td>
		</tr>
		<tr>
		<td align='right' colspan='2'>
		<input type='submit' value='Next'>&nbsp;&nbsp;&nbsp;
		</tr>
		</table>
<jsp:include page="Footer.jsp"/>