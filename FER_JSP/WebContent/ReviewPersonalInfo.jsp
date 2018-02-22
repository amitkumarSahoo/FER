<%@page
	import="com.rs.fer.service.FERService,com.rs.fer.service.FERServiceImpl,com.rs.fer.bean.PersonalInfo, com.rs.fer.bean.User"%>
<%@ page session="false"%>
<%
	HttpSession session = request.getSession();
	PersonalInfo PersonalInfo = (PersonalInfo) session.getAttribute("personalInfo");

	PersonalInfo.getAddress().setAddress_line1(request.getParameter("addressLine1"));
	PersonalInfo.getAddress().setAddress_line2(request.getParameter("addressLine2"));
	PersonalInfo.getAddress().setCity(request.getParameter("city"));
	PersonalInfo.getAddress().setState(request.getParameter("state"));
	PersonalInfo.getAddress().setZip(request.getParameter("zip"));
	PersonalInfo.getAddress().setCountry(request.getParameter("country"));
%>
<jsp:include page="HeaderAndLeftFrame.jsp" />
<form action='UpdatePersonalInfo.jsp' method='post'>
	<table border='1'>
		<tr>
			<td>FirstName</td>
			<td><%=PersonalInfo.getUser().getFirst_name()%></td>
		</tr>

		<tr>
			<td>MiddleName</td>
			<td><%=PersonalInfo.getUser().getMiddle_name()%></td>
		</tr>

		<tr>
			<td>LastName</td>
			<td><%=PersonalInfo.getUser().getLast_name()%></td>
		</tr>

		<tr>
			<td>Emailid</td>
			<td><%=PersonalInfo.getUser().getEmail()%></td>
		</tr>

		<tr>
			<td>Mobile</td>
			<td><%=PersonalInfo.getUser().getPhone_number()%></td>
		</tr>

		<tr>
			<td>Address Line 1</td>
			<td><%=PersonalInfo.getAddress().getAddress_line1()%></td>
		</tr>

		<tr>
			<td>Address Line 2</td>
			<td><%=PersonalInfo.getAddress().getAddress_line2()%></td>
		</tr>

		<tr>
			<td>City</td>
			<td><%=PersonalInfo.getAddress().getCity()%></td>
		</tr>

		<tr>
			<td>State</td>
			<td><%=PersonalInfo.getAddress().getState()%></td>
		</tr>

		<tr>
			<td>Zip</td>
			<td><%=PersonalInfo.getAddress().getZip()%></td>
		</tr>

		<tr>
			<td>Country</td>
			<td><%=PersonalInfo.getAddress().getCountry()%></td>
		</tr>

		<tr>
			<td align='center' colspan='2'><input type='submit'
				value='Update'>&nbsp;&nbsp;&nbsp;</td>
		</tr>
	</table>
	<jsp:include page="Footer.jsp" />