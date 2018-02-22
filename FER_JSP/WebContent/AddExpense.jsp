
<jsp:include page="HeaderAndLeftFrame.jsp"></jsp:include>
<form action="AddExpensePost.jsp" method="post">
	<table border="1">
		<tr>
			<td align="center" colspan="2">Add Expense</td>
		</tr>

		<tr>
			<td>Expense Type</hd>
			<td align="center"><input type="text" name="expenseType">
			</td>
		</tr>

		<tr>
			<td>Date</hd>
			<td align="center"><input type="text" name="date"></td>
		</tr>

		<tr>
			<td>Price</hd>
			<td align="center"><input type="text" name="price"></td>
		</tr>

		<tr>
			<td>Number Of Items</hd>
			<td align="center"><input type="text" name="numberOfItems"></td>
		</tr>

		<tr>
			<td>Total</hd>
			<td align="center"><input type="text" name="total"></td>
		</tr>

		<tr>
			<td>ByWhom</hd>
			<td align="center"><input type="text" name="byWhom"></td>
		</tr>

		<tr>
			<td align="center" colspan="2"><input type="submit"
				value="AddExpense">&nbsp;&nbsp;&nbsp;</td>
		</tr>
	</table>
	<jsp:include page="Footer.jsp"></jsp:include>