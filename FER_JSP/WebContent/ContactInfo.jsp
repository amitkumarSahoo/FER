<%@page
	import="com.rs.fer.service.FERService,com.rs.fer.service.FERServiceImpl,com.rs.fer.bean.PersonalInfo, com.rs.fer.bean.User"%>
<%@ page session="false"%>
<%
	HttpSession session = request.getSession();

	PersonalInfo personalInfo = (PersonalInfo) session.getAttribute("personalInfo");

	personalInfo.getUser().setFirst_name(request.getParameter("firstName"));
	personalInfo.getUser().setMiddle_name(request.getParameter("middleName"));
	personalInfo.getUser().setLast_name(request.getParameter("lastName"));
%>
<jsp:include page="HeaderAndLeftFrame.jsp"/>
<form action='AddressInfo.jsp' method='post'>
	<table frame='box' align='center' width='500px' height='250px'>
		<tr height='80px'>
			<td align='left' colspan='2'><u>Contact Information</u>
		</tr>
		<tr>
			<td align='center'>E-mail</td>
			<td align='center'><input type='text' name='email'
				value=<%=personalInfo.getUser().getEmail()%>></td>
		</tr>
		<tr>
			<td align='center'>Phone Number</td>
			<td align='center'><input type='text' name='phoneNumber'
				value=<%=personalInfo.getUser().getPhone_number()%>></td>
		</tr>
		<tr>
			<td align='right' colspan='2'><input type='submit' value='Next'>&nbsp;&nbsp;&nbsp;
			</td>
		</tr>
	</table>
<jsp:include page="Footer.jsp"/>