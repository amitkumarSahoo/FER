<%@page
	import="com.rs.fer.service.FERService,com.rs.fer.service.FERServiceImpl,com.rs.fer.bean.PersonalInfo, com.rs.fer.bean.User"%>
<%@ page session="false"%>
<%
	HttpSession session = request.getSession();
	PersonalInfo personalInfo = (PersonalInfo) session.getAttribute("personalInfo");
	personalInfo.getUser().setEmail(request.getParameter("email"));
	personalInfo.getUser().setPhone_number(request.getParameter("phoneNumber"));
%>
<jsp:include page="HeaderAndLeftFrame.jsp"/>
<form action='ReviewPersonalInfo.jsp' method='post'>
	<table frame='box' align='center' width='500px' height='250px'>
		<tr>
			<td align='left' colspan='2' height='80px'><u>Address
					Information</u>
		</tr>
		<tr>
			<td align='center'>Address Line 1</td>
			<td align='center'><input type='text' name='addressLine1'
				value=<%=personalInfo.getAddress().getAddress_line1()%>></td>
		</tr>
		<tr>
			<td align='center'>Address Line 2</td>
			<td align='center'><input type='text' name='addressLine2'
				value=<%=personalInfo.getAddress().getAddress_line2()%>></td>
		</tr>
		<tr>
			<td align='center'>City</td>
			<td align='center'><input type='text' name='city'
				value=<%=personalInfo.getAddress().getCity()%>></td>
		</tr>
		<tr>
			<td align='center'>State</td>
			<td align='center'><input type='text' name='state'
				value=<%=personalInfo.getAddress().getState()%>></td>
		</tr>
		<tr>
			<td align='center'>Zip</td>
			<td align='center'><input type='text' name='zip'
				value=<%=personalInfo.getAddress().getZip()%>></td>
		</tr>
		<tr>
			<td align='center'>Country</td>
			<td align='center'><input type='text' name='country'
				value=<%=personalInfo.getAddress().getCountry()%>></td>
		</tr>
		<tr>
			<td align='right' colspan='2'><input type='submit'
				value='Review'>&nbsp;&nbsp;&nbsp;</td>
		</tr>
	</table>
	<jsp:include page="Footer.jsp"/>