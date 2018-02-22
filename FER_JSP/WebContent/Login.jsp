
<form name="form1" action="LoginPost.jsp">
	<table border="1" align="center">
		<tr>
			<td colspan="2" align="center"><b>Login</b></td>
		</tr>
		<tr>
			<td>Username</td>
			<td align="center"><input type="text" name="username"></td>
		</tr>
		<tr>
			<td>Password</td>
			<td align="center"><input type="password" name="password"></td>
		</tr>
		<tr>
			<td align="center" colspan="2"><input type="submit" onclick="return onclickSubmit()" value="Login">&nbsp;&nbsp;&nbsp; 
			<a href="Registration.jsp">registration</a></td>
		</tr>
	</table>
</form>

<script>
function onclickSubmit(){
	
	 var unameVal = document.form1.username.value;
	if(unameVal == ''){
		alert("User Name should not be empty");
		return false;
	} 
	var upassVal = document.form1.password.value;
	if(upassVal == ''){
		alert("Password should not be empty");
		return false;
	}
}
</script>