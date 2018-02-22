
<jsp:include page="HeaderAndLeftFrame.jsp"/>

<form action='ExpenseReportPost.jsp' method='post'>
	<table border='1' align='center'>
		<tr height='50px'>
			<td align='center' colspan='2' height='80px'>Expense Report
		</tr>
		<tr>
			<td align='center'>Expense Type</td>
			<td align='center'><input type='text' name='expenseType'></td>
		</tr>
		<tr>
			<td align='center'>From Date</td>
			<td align='center'><input type='text' name='fromDate'></td>
		</tr>
		<tr>
			<td align='center'>To Date</td>
			<td align='center'><input type='text' name='toDate'></td>
		</tr>
		<tr>
			<td align='center' colspan='2'><input type='submit'
				value='GetReport'>&nbsp;&nbsp;&nbsp;
		</tr>
	</table>
	<jsp:include page="Footer.jsp"/>