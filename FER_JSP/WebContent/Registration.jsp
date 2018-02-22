<html>

<head>
<script>
	function isEmailAvailable() {
		var xmlhttp;
		var email = document.RegistrationForm.email.value;

		var url = "FER_Ajax.jsp?email=" + email;

		if (window.XMLHttpRequest) {
			xmlhttp = new XMLHttpRequest();
		} else {
			xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
		}

		xmlhttp.onreadystatechange = function() {
			if (xmlht tp.readyState == 4) {
				var response = xmlhttp.responseText.trim();

				//alert("."+response+".");

				var trEmailMessageId = document.getElementById('trEmailMessageId');
				var tdEmailMessageId = document.getElementById('tdEmailMessageId');

				/*  if(response == 'Y') {
				 	tdEmailMessageId.innerHTML = 'Email is available...';
				 	tdEmailMessageId.style.color = 'green';
				 } else {
				 	tdEmailMessageId.innerHTML = 'Email is not available...';
				 	tdEmailMessageId.style.color = 'red';
				 } */

				tdEmailMessageId.innerHTML = (response == 'Y') ? 'Email is available...' : 'Email is not available...';
				tdEmailMessageId.style.color = (response == 'Y') ? 'green' : 'red';

				trEmailMessageId.style.display = "";
			}
		}

		xmlhttp.open("GET", url, true);
		xmlhttp.send();
	}
</script>
</head>

<body>
	<form action="RegistrationPost.jsp" name="RegistrationForm">

		<table border="1" align="center">
			<tr>
				<th colspan="2">Register</th>
			</tr>
			<tr>
				<td>First Name</td>
				<td align="center"><input type="text" name="firstName"></td>
			</tr>
			<tr>
				<td>Middle name</td>
				<td align="center"><input type="text" name="middleName"></td>
			</tr>
			<tr>
				<td>Last Name</td>
				<td align="center"><input type="text" name="lastName"></td>
			</tr>
			<tr>
				<td>User name</td>
				<td align="center"><input type="text" name="username"></td>
			</tr>
			<tr>
				<td>Password</td>
				<td align="center"><input type="password" name="password"></td>
			</tr>
			<tr>
				<td>Email</td>
				<td><input type="text" name="email"
					onchange="javascript: isEmailAvailable();"></td>
			</tr>
			<tr id="trEmailMessageId" style="display: none;">
				<td colspan="2" id="tdEmailMessageId"></td>
			</tr>
			<tr>
				<td>Phone Number</td>
				<td align="center"><input type="text" name="phoneNumber"></td>
			</tr>
			<tr>
				<td align="center" colspan="2"><input type="submit"
					value="registration">&nbsp;&nbsp;&nbsp;
			</tr>
		</table>
	</form>
</body>
</html>
