
<jsp:include page="HeaderAndLeftFrame.jsp"/>

<form action='ResetPasswordPost.jsp' method='post'>
	<table border='1'>
		<tr>
			<td>Current Password</td>
			<td align='center'><input type='password' name='currentPassword'></td>
		</tr>
		<tr>
			<td>New Password</td>
			<td align='center'><input type='password' name='newPassword'></td>
		</tr>
		<tr>
			<td>Confirm Password</td>
			<td align='center'><input type='password' name='newPassword'></td>
		</tr>
		<tr>
			<td align='center' colspan='2'><input type='submit'
				value='Reset'>&nbsp;&nbsp;&nbsp;</td>
		</tr>
	</table>

<jsp:include page="Footer.jsp"/>